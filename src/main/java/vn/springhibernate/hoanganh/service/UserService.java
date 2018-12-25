package vn.springhibernate.hoanganh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.springhibernate.hoanganh.dao.UserDao;
import vn.springhibernate.hoanganh.model.Student;
import vn.springhibernate.hoanganh.model.Users;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserDao uDao;
	
	public void CreateNewUser(final Users u) {
		uDao.CreateNewUser(u);
	}
	
	public Users finbyId(final String id) {
		return uDao.finbyId(id);
	}
	
	public void ActiveUser(final Users u) {
		uDao.ActiveUsers(u);
	}
	
	public Long countCheckMail(String email){
		return uDao.countCheckMail(email);
	}

	public Long countCheckMaSo(String username){
		return uDao.countCheckMaSo(username);
	}
	
	public Student finbyStudentId(final String id) {
		return uDao.finbyStudentId(id);
	}
	
	public void UpdatePass(final String newPass, final String id) {
		uDao.UpdatePass(newPass, id);
	}
}
