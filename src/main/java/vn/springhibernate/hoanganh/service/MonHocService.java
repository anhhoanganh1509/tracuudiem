package vn.springhibernate.hoanganh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.springhibernate.hoanganh.dao.MonHocDao;
import vn.springhibernate.hoanganh.model.Diem;
import vn.springhibernate.hoanganh.model.MonHoc;
import vn.springhibernate.hoanganh.model.ViewStudent;

@Service
@Transactional
public class MonHocService {
	
	@Autowired
	private MonHocDao monHocDao;
	//-----33
	public List<ViewStudent> finbyViewStudent(final String masinhvien) {
		return monHocDao.finbyViewStudentList(masinhvien);
	}
	//-----44
	public List<MonHoc> finbyMonHocList() {
		return monHocDao.finbyMonHocList();
	}
	//-----55
	public List<ViewStudent> finbyViewMonHocList(final String mamonhoc, final String hocky, final String namhoc) {
		return monHocDao.finbyViewMonHocList(mamonhoc, hocky, namhoc);
	}
	//-----66
	public void popupCapNhatDiem(Diem d, final String mamonhoc,final String masinhvien) {
		monHocDao.popupCapNhatDiem(d, mamonhoc, masinhvien);
	}
	//-----99
	public void popupAddNewMonHoc(MonHoc m, Authentication au) {
		monHocDao.popupAddNewMonHoc(m, au);
	}
}
