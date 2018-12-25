package vn.springhibernate.hoanganh.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.springhibernate.hoanganh.model.Student;
import vn.springhibernate.hoanganh.model.User_roles;
import vn.springhibernate.hoanganh.model.Users;

@Repository
@Transactional(rollbackFor = Exception.class)
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private JavaMailSender mailSender;

	public void CreateNewUser(final Users u) {
		Session session = this.sessionFactory.getCurrentSession();
		String pass = String.valueOf(new Date().getTime());
		u.setUsername(u.getUsername());		
		u.setPassword(pass.substring(8));
		u.setEnabled(0);
		u.setEmail(u.getEmail());
		u.setNgaytao(new Date());
		u.setDaxoa(0);
		session.save(u);
		User_roles ur = new User_roles();
		ur.setUsername(u.getUsername());
		ur.setRole("ROLE_ADMIN");
		session.save(ur);
		String subject = "User Activation Account";
		String message = "Please click on the following link to active your account."
				+"\n"+"http://localhost:8080/TraCuuDiem/activeUser/"+u.getUsername()+"\n\n"
				+"- Username:"+u.getUsername()+"\n"+"- Password:"+pass.substring(8);
		
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(u.getEmail());
		email.setSubject(subject);
		email.setText(message);		
		//mailSender.send(email);
	}

	public Users finbyId(final String id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Users.class, id);
	}

	public void ActiveUsers(Users u) {
		if(u.getEnabled() == 0) {
			Session session = this.sessionFactory.getCurrentSession();
			u.setEnabled(1);
			u.setNgaysua(new Date());	
			session.update(u);
		}
	}
	
	public Long countCheckMail(String email) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "Select count(o.username) from " 
				+Users.class.getName() + " o where o.daxoa = 0 and o.email like '"+email+"'";
		Long value = (Long)session.createQuery(sql).uniqueResult();
        if (value == null) {
            return 0L;
        }
        return value;
	}
	
	public Long countCheckMaSo(String username) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "Select count(o.username) from " 
				+Users.class.getName() + " o where o.daxoa = 0 and o.username like '"+username+"'";
		Long value = (Long)session.createQuery(sql).uniqueResult();
        if (value == null) {
            return 0L;
        }
        return value;
	}	

	public Student finbyStudentId(final String id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Student.class, id);
	}
	
	public void UpdatePass(final String newPass, final String id) {
		Session session = this.sessionFactory.getCurrentSession();
		Users u = this.finbyId(id);
		u.setPassword(newPass);
		u.setNgaysua(new Date());
		session.update(u);
		String subject = "Change Password";
		String message = "The change password process has completed successfully."
				+"\n"+"- Username:"+u.getUsername()+"\n"+"- Password:"+newPass;		
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(u.getEmail());
		email.setSubject(subject);
		email.setText(message);		
		mailSender.send(email);
	}

}
