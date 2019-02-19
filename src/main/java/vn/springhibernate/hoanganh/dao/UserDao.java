package vn.springhibernate.hoanganh.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.springhibernate.hoanganh.model.Diem;
import vn.springhibernate.hoanganh.model.SinhVien;
import vn.springhibernate.hoanganh.model.User_roles;
import vn.springhibernate.hoanganh.model.User_admin;
import vn.springhibernate.hoanganh.model.ViewStudent;

@Repository
@Transactional(rollbackFor = Exception.class)
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;	
	//-----11
	public User_admin finbyUserId(final String id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(User_admin.class, id);
	}
	//-----22
	public SinhVien finbyStudent(final String id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(SinhVien.class, id);
	}
	//-----33
	public List<SinhVien> finbyStudentList(final String id) {
		Session session = this.sessionFactory.getCurrentSession();		
		return session.createQuery("FROM "+SinhVien.class.getName() 
				+ " where daxoa = 0 order by tensinhvien asc", SinhVien.class).getResultList();		
	}
	//-----88
	public void UpdatePass(final String newPass, final String id) {
		Session session = this.sessionFactory.getCurrentSession();
		User_admin u = this.finbyUserId(id);
		u.setPassword(newPass.trim());
		u.setNgaysua(new Date());
		if(u.getDaxoa() == 2) {
			u.setDaxoa(2);
		}else {
			u.setDaxoa(1);
		}
		session.update(u);
		String subject = "Change Password";
		String message = "The change password process has completed successfully." + "\n" + "- Username:"
				+ u.getUsername() + "\n" + "- Password:" + newPass;
		SimpleMailMessage email = new SimpleMailMessage();
		//email.setTo(u.getEmail());
		email.setSubject(subject);
		email.setText(message);
		try {					
			//mailSender.send(email);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	static SimpleDateFormat formatDateShort = new SimpleDateFormat("dd/MM/yyyy");
	
	public static Date parseStringToDate(String data) {
		try {
			return formatDateShort.parse(data);
		} catch (Exception es) {
		}
		return null;
	}
	//-----10
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
	public void popupAddNewSinhVien(final ViewStudent v, Authentication au, final String ngaysinhNew) {
		try {					
			Session session = this.sessionFactory.getCurrentSession();
			String masv = v.getMasinhvien().trim();
			String sqlSinhVien = "Select count(o.masinhvien) from "+SinhVien.class.getName() + " o where o.daxoa = 0 and o.masinhvien = '"+masv+"'";
			Long value = (Long)session.createQuery(sqlSinhVien).uniqueResult();
			if(value == 0) {
				SinhVien sv = new SinhVien();
				sv.setMasinhvien(masv);
				sv.setHosinhvien(v.getHosinhvien());
				sv.setTensinhvien(v.getTensinhvien());
				sv.setNgaysinh(parseStringToDate(ngaysinhNew));
				sv.setLop(v.getLop());
				sv.setNgaytao(new Date());
				sv.setNguoitao(au.getName());
				sv.setDaxoa(0);
				session.save(sv);
				User_roles ur = new User_roles();
				ur.setUser_role_id(this.maxUser_role() + 1);
				ur.setUsername(masv);
				ur.setRole("ROLE_ADMIN");
				session.save(ur);
				User_admin u = new User_admin();
				u.setUsername(masv);
				u.setPassword(masv);
				u.setEnabled(1);
				u.setNgaytao(new Date());
				u.setDaxoa(0);
				session.save(u);
			}
			String sqlDiemSinhViem = "Select count(o.id) from "+Diem.class.getName() + " o where o.daxoa = 0 and o.masinhvien = '"+masv+"' and o.mamonhoc = '"+v.getMamonhoc()+"' ";
			Long valueDiem = (Long)session.createQuery(sqlDiemSinhViem).uniqueResult();
			if(valueDiem == 0) {
				Diem d = new Diem();
				d.setId(this.maxDiem() + 1);
				d.setMamonhoc(v.getMamonhoc());
				d.setMasinhvien(masv);
				d.setHocky(v.getHocky());
				d.setNamhoc(v.getNamhoc());
				d.setSotinchi(v.getSotinchi());
				d.setQuatrinh(v.getQuatrinh());
				d.setGiuaky(v.getGiuaky());
				d.setThi(v.getThi());
				d.setNgaytao(new Date());
				d.setNguoitao(au.getName());
				d.setDaxoa(0);
				session.save(d);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	
	
	public Diem finbyDiem(final String id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Diem.class, Integer.parseInt(id));
	}
	//-----66
	public void myFunctionDelete(final String masinhvien) {
		Session session = this.sessionFactory.getCurrentSession();	
		Diem sv = this.finbyDiem(masinhvien);
		sv.setDaxoa(1);
		sv.setNgaytao(new Date());
		session.update(sv);
	}
	
}
