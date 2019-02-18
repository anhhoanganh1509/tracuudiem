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
@Table(name = "sinhvien")
public class SinhVien {
	
	@Id  
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

	public SinhVien() {
		super();
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
