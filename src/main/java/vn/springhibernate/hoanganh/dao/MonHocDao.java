package vn.springhibernate.hoanganh.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.springhibernate.hoanganh.model.Diem;
import vn.springhibernate.hoanganh.model.MonHoc;
import vn.springhibernate.hoanganh.model.ViewStudent;

@Repository
@Transactional(rollbackFor = Exception.class)
public class MonHocDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	//-----33
	public List<ViewStudent> finbyViewStudentList(final String masinhvien) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM "+ViewStudent.class.getName() 
				+ " where daxoa = 0 and masinhvien = '"+masinhvien+"' ", ViewStudent.class).getResultList();	
	}
	//-----44
	public List<MonHoc> finbyMonHocList() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM "+MonHoc.class.getName() + " where daxoa = 0 order by tenmonhoc asc", MonHoc.class).getResultList();	
	}
	//-----55
	public List<ViewStudent> finbyViewMonHocList(final String mamonhoc, final String hocky, final String namhoc) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM "+ViewStudent.class.getName() 
				+ " where daxoa = 0 and mamonhoc = '"+mamonhoc+"' and hocky = '"+hocky+"' and namhoc = '"+namhoc+"' ", ViewStudent.class).getResultList();	
	}	
	//-----66
	public void popupCapNhatDiem(Diem d, final String mamonhoc, final String masinhvien) {
		Session session = this.sessionFactory.getCurrentSession();	
		List<Diem> d1 = this.finbyDiemIdQuery(masinhvien, mamonhoc);
		Diem d2 = this.finbyDiemIdQuery(d1.get(0).getId());
		d2.setQuatrinh(d.getQuatrinh());
		d2.setGiuaky(d.getGiuaky());
		d2.setThi(d.getThi());
		session.update(d2);
	}
	//-----77
	public Diem finbyDiemIdQuery(final int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Diem.class, id);
	}	
	//-----77
	public List<Diem> finbyDiemIdQuery(final String masinhvien, final String mamonhoc) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM "+Diem.class.getName()
				+ " where mamonhoc = '"+mamonhoc+"' and masinhvien = '"+masinhvien+"' ", Diem.class).getResultList();
	}	
	//-----99
	public void popupAddNewMonHoc(final MonHoc m, Authentication au) {
		Session session = this.sessionFactory.getCurrentSession();
		m.setMamonhoc(m.getMamonhoc().trim());
		m.setNgaytao(new Date());
		m.setNguoitao(au.getName());
		m.setDaxoa(0);
		session.save(m);
	}
}
