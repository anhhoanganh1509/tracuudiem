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
@Table(name = "monhoc")
public class MonHoc {
	@Id  
    @Column(name = "mamonhoc")
	private String mamonhoc;

    @Column(name = "tenmonhoc")
	private String tenmonhoc;
    
    @Column(name = "ngaytao")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="dd/MM/yyyy")
	private Date ngaytao;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name = "ngaysua")
	private Date ngaysua;

    @Column(name = "nguoitao")
	private String nguoitao;

    @Column(name = "daxoa")
	private int daxoa;

	public MonHoc() {
		super();
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

	public String getNguoitao() {
		return nguoitao;
	}

	public void setNguoitao(String nguoitao) {
		this.nguoitao = nguoitao;
	}

	public int getDaxoa() {
		return daxoa;
	}

	public void setDaxoa(int daxoa) {
		this.daxoa = daxoa;
	}

}
