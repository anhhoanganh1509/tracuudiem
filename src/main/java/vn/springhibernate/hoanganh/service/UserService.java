package vn.springhibernate.hoanganh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import vn.springhibernate.hoanganh.controller.ImportExportThongtin;
import vn.springhibernate.hoanganh.dao.UserDao;
import vn.springhibernate.hoanganh.model.SinhVien;
import vn.springhibernate.hoanganh.model.User_admin;
import vn.springhibernate.hoanganh.model.ViewStudent;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserDao uDao;
	
	@Autowired
	private ImportExportThongtin im;
	//-----11
	public User_admin finbyUserId(final String id) {
		return uDao.finbyUserId(id);
	}
	//-----22
	public SinhVien finbyStudent(final String id) {
		return uDao.finbyStudent(id);
	}
	//-----88
	public void UpdatePass(final String newPass, final String id) {
		uDao.UpdatePass(newPass, id);
	}
	//-----10
	public void popupAddNewSinhVien(ViewStudent sv, Authentication au, final String ngaysinhNew) {
		uDao.popupAddNewSinhVien(sv, au, ngaysinhNew);
	}
	//-----66
	public void myFunctionDelete(final String masinhvien) {
		uDao.myFunctionDelete(masinhvien);
	}
	//-----66
	public void myFunctionDeleteSinhVien(CommonsMultipartFile fileUpload, ViewStudent sv) {
		im.importDuLieuTuFileExcel(fileUpload, sv);
	}
}
