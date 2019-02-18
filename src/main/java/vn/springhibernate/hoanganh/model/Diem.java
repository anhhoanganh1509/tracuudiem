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
@Table(name = "diem")
public class Diem {

	@Id
	@Column(name = "id")
	private int id;
	
    @Column(name = "masinhvien")
	private String masinhvien;
    
    @Column(name = "mamonhoc")
   	private String mamonhoc;

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

	public Diem() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMasinhvien() {
		return masinhvien;
	}

	public void setMasinhvien(String masinhvien) {
		this.masinhvien = masinhvien;
	}

	public String getMamonhoc() {
		return mamonhoc;
	}

	public void setMamonhoc(String mamonhoc) {
		this.mamonhoc = mamonhoc;
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
