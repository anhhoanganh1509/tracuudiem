package vn.springhibernate.hoanganh.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import vn.springhibernate.hoanganh.model.Diem;
import vn.springhibernate.hoanganh.model.SinhVien;
import vn.springhibernate.hoanganh.model.User_roles;
import vn.springhibernate.hoanganh.model.User_admin;
import vn.springhibernate.hoanganh.model.ViewStudent;

@Repository
@Transactional(rollbackFor = Exception.class)
public class ImportExportThongtin {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	static SimpleDateFormat formatDateShort = new SimpleDateFormat("dd/MM/yyyy");	
	public static Date parseStringToDate(String data) {
		try {
			return formatDateShort.parse(data);
		} catch (Exception es) {
		}
		return null;
	}

    public int maxDiem() {
		Session session = this.sessionFactory.getCurrentSession();		
    	String sql = "Select max(o.id) from " + Diem.class.getName() + " o ";
    	Integer value = (Integer)session.createQuery(sql).uniqueResult();    	
        if (value == null) {
            return 0;
        }
        return value;
    }

    public int maxUser_role() {
		Session session = this.sessionFactory.getCurrentSession();		
    	String sql = "Select max(o.user_role_id) from " + User_roles.class.getName() + " o ";
    	Integer value = (Integer)session.createQuery(sql).uniqueResult();    	
        if (value == null) {
            return 0;
        }
        return value;
    }
    
	public void importDuLieuTuFileExcel(CommonsMultipartFile fileUpload, ViewStudent sv1) {
		String note = "";
		boolean flag = false;
		
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(fileUpload.getInputStream());
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		Map<String, CellStyle> styles = createStyles(workbook);
		XSSFSheet worksheet = workbook.getSheetAt(0);
		XSSFRow rowTitle = worksheet.createRow(3);
		XSSFCell cellTitle = rowTitle.createCell(5);
		cellTitle.setCellValue("DANH S\u00C1CH D\u1EEE LI\u1EC6U L\u1ED6I");

		short rowIndex = 10;
		int indexDiem = this.maxDiem() + 1;
		int indexUser_role = this.maxUser_role() + 1;
		while (true) {
						
			note = "";
			XSSFRow row = worksheet.getRow(rowIndex);
			String stt = "";
			try {
				stt = getHSSFCellValue(row.getCell(0));
			} catch (Exception e) {
				
			}
			if (stt.equals("")) {
				break;
			}

			XSSFCell cellMasinhvien = row.getCell(1);
			XSSFCell cellHosinhvien = row.getCell(2);
			XSSFCell cellTensinhvien = row.getCell(3);
			XSSFCell cellNgaysinh = row.getCell(4);
			XSSFCell cellLop = row.getCell(5);
			XSSFCell cellQuatrinh = row.getCell(6);
			XSSFCell cellGiuaky = row.getCell(7);
			XSSFCell cellThi = row.getCell(8);

			String Masinhvien = getHSSFCellValue(cellMasinhvien);
			String Hosinhvien = getHSSFCellValue(cellHosinhvien);
			String Tensinhvien = getHSSFCellValue(cellTensinhvien);
			String Ngaysinh = getHSSFCellValue(cellNgaysinh);
			String Lop = getHSSFCellValue(cellLop);
			String Quatrinh = getHSSFCellValue(cellQuatrinh);
			String Giuaky = getHSSFCellValue(cellGiuaky);
			String Thi = getHSSFCellValue(cellThi);

			flag = false;

			try {
				Session session = this.sessionFactory.getCurrentSession();
				String sql = "Select count(o.masinhvien) from "+SinhVien.class.getName() + " o where o.daxoa = 0 and o.masinhvien = '"+Masinhvien.trim()+"'";
				Long value = (Long)session.createQuery(sql).uniqueResult();
		        if (value == 0) {
		        	SinhVien sv = new SinhVien ();
					sv.setMasinhvien(Masinhvien.trim());
					sv.setHosinhvien(Hosinhvien);
					sv.setTensinhvien(Tensinhvien);
					sv.setNgaysinh(parseStringToDate(Ngaysinh));
					sv.setLop(Lop);
					sv.setNgaytao(new Date());
					sv.setDaxoa(0);
					session.save(sv);
					if(sv != null){
					   flag = true;
				   }
					User_roles ur = new User_roles();
					ur.setUser_role_id(indexUser_role);
					ur.setUsername(Masinhvien.trim());
					ur.setRole("ROLE_ADMIN");
					session.save(ur);
					User_admin u = new User_admin();
					u.setUsername(Masinhvien.trim());
					u.setPassword(Masinhvien.trim());
					u.setEnabled(1);
					u.setNgaytao(new Date());
					u.setDaxoa(0);
					session.save(u);
		        }
		        String sqlDiemSinhViem = "Select count(o.id) from "+Diem.class.getName() + " o where o.daxoa = 0 and o.masinhvien = '"+Masinhvien.trim()+"' and o.mamonhoc = '"+sv1.getMamonhoc().trim()+"' ";
				Long valueDiem = (Long)session.createQuery(sqlDiemSinhViem).uniqueResult();
				if(valueDiem == 0) {
					Diem d = new Diem();
					d.setId(indexDiem);
					d.setMamonhoc(sv1.getMamonhoc().trim());
					d.setMasinhvien(Masinhvien.trim());
					d.setHocky(sv1.getHocky());
					d.setNamhoc(sv1.getNamhoc());
					d.setSotinchi(sv1.getSotinchi());
					d.setQuatrinh(Quatrinh);
					d.setGiuaky(Giuaky);
					d.setThi(Thi);
					d.setNgaytao(new Date());
					d.setDaxoa(0);
					session.save(d);
				}
					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			

			if(!flag){
				XSSFCell noteCell=row.createCell(15);
				noteCell.setCellValue(note);
				noteCell.setCellStyle(styles.get("cell-error"));
			}			
			row.setZeroHeight(flag);				
			rowIndex++;indexDiem++;indexUser_role++;	
		}		
	}
	
	public static Map<String, CellStyle> createStyles(Workbook wb) {
		Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
		CellStyle style;
		Font titleFont = wb.createFont();
		titleFont.setFontHeightInPoints((short) 13);
		titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style = wb.createCellStyle();
		style = wb.createCellStyle();
		Font cellFont = wb.createFont();
		cellFont.setFontHeightInPoints((short) 10);
		style.setFont(cellFont);
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setWrapText(false);
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.RED.getIndex());
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.RED.getIndex());
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.RED.getIndex());
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.RED.getIndex());
		styles.put("cell-error", style);
		return styles;
	}
	
	private static String getHSSFCellValue(XSSFCell cell) {
		// Default value if row is null
		String value = "";
		if (cell == null) {
			return value.trim();
		}
		try {
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				value = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_FORMULA:
				value = cell.getCellFormula();
				break;
			case Cell.CELL_TYPE_NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					try {
						value = format.format(cell.getDateCellValue());
					} catch (Exception e) {
						value = cell.getDateCellValue().toString();
					}
				} else {
					value = new BigDecimal(cell.getNumericCellValue())
							.toString();
				}
				break;
			case Cell.CELL_TYPE_BLANK:
				value = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				value = Boolean.toString(cell.getBooleanCellValue());
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value.trim();
	}
}
