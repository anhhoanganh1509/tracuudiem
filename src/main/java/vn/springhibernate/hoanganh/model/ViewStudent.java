package vn.springhibernate.hoanganh.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "viewstudent")
public class ViewStudent {
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "masinhvien")
	private String masinhvien;

    @Column(name = "hosinhvien")
	private String hosinhvien;
    
    @Column(name = "tensinhvien")
	private String tensinhvien;

    @Column(name = "ngaysinh")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="dd/MM/yyyy")
	private Date ngaysinh;
    
    @Column(name = "lop")
	private String lop;

    @Column(name = "mamonhoc")
	private String mamonhoc;

    @Column(name = "tenmonhoc")
	private String tenmonhoc;
    
    @Column(name = "sotinchi")
	private String sotinchi;

    @Column(name = "hocky")
	private String hocky;
    
    @Column(name = "namhoc")
	private String namhoc;

    @Column(name = "quatrinh")
	private String quatrinh;

    @Column(name = "giuaky")
	private String giuaky;

    @Column(name = "thi")
	private String thi;

    @Column(name = "ghichu")
	private String ghichu;

    @Column(name = "daxoa")
	private int daxoa;

	public ViewStudent() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMasinhvien() {
		return masinhvien;
	}

	public void setMasinhvien(String masinhvien) {
		this.masinhvien = masinhvien;
	}

	public String getHosinhvien() {
		return hosinhvien;
	}

	public void setHosinhvien(String hosinhvien) {
		this.hosinhvien = hosinhvien;
	}

	public String getTensinhvien() {
		return tensinhvien;
	}

	public void setTensinhvien(String tensinhvien) {
		this.tensinhvien = tensinhvien;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public String getMamonhoc() {
		return mamonhoc;
	}

	public void setMamonhoc(String mamonhoc) {
		this.mamonhoc = mamonhoc;
	}

	public String getTenmonhoc() {
		return tenmonhoc;
	}

	public void setTenmonhoc(String tenmonhoc) {
		this.tenmonhoc = tenmonhoc;
	}

	public String getSotinchi() {
		return sotinchi;
	}

	public void setSotinchi(String sotinchi) {
		this.sotinchi = sotinchi;
	}

	public String getHocky() {
		return hocky;
	}

	public void setHocky(String hocky) {
		this.hocky = hocky;
	}

	public String getNamhoc() {
		return namhoc;
	}

	public void setNamhoc(String namhoc) {
		this.namhoc = namhoc;
	}

	public String getQuatrinh() {
		return quatrinh;
	}

	public void setQuatrinh(String quatrinh) {
		this.quatrinh = quatrinh;
	}

	public String getGiuaky() {
		return giuaky;
	}

	public void setGiuaky(String giuaky) {
		this.giuaky = giuaky;
	}

	public String getThi() {
		return thi;
	}

	public void setThi(String thi) {
		this.thi = thi;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public int getDaxoa() {
		return daxoa;
	}

	public void setDaxoa(int daxoa) {
		this.daxoa = daxoa;
	}

}
