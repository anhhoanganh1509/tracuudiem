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
@Table(name = "user_admin")
public class Users {
	
	@Id
	@Column(name = "username")
	private String username;
	  
    @Column(name = "password")
	private String password;
	
    @Column(name = "enabled")
	private int enabled;
    
    @Column(name = "email")
	private String email;
	
    @Column(name = "ngaytao")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="dd/MM/yyyy")
	private Date ngaytao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ngaysua")
	private Date ngaysua;

    @Column(name = "daxoa")
	private int daxoa;
	
	public Users() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNgaytao() {
		return ngaytao;
	}

	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}

	public Date getNgaysua() {
		return ngaysua;
	}

	public void setNgaysua(Date ngaysua) {
		this.ngaysua = ngaysua;
	}

	public int getDaxoa() {
		return daxoa;
	}

	public void setDaxoa(int daxoa) {
		this.daxoa = daxoa;
	}

}
