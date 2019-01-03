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
@Table(name = "student")
public class Student {
	
	@Id  
    @Column(name = "studentma")
	private String studentma;

    @Column(name = "lastname")
	private String lastname;
    
    @Column(name = "firstname")
	private String firstname;

    @Column(name = "dayofbirth")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dayofbirth;
    
    @Column(name = "classname")
	private String classname;
    
    @Column(name = "process")
	private String process;

    @Column(name = "midterm")
	private String midterm;

    @Column(name = "exam")
	private String exam;

    @Column(name = "note")
	private String note;
    
    @Column(name = "daxoa")
	private int daxoa;

	public Student() {
		super();
	}

	public String getStudentma() {
		return studentma;
	}

	public void setStudentma(String studentma) {
		this.studentma = studentma;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Date getDayofbirth() {
		return dayofbirth;
	}

	public void setDayofbirth(Date dayofbirth) {
		this.dayofbirth = dayofbirth;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public String getMidterm() {
		return midterm;
	}

	public void setMidterm(String midterm) {
		this.midterm = midterm;
	}

	public String getExam() {
		return exam;
	}

	public void setExam(String exam) {
		this.exam = exam;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getDaxoa() {
		return daxoa;
	}

	public void setDaxoa(int daxoa) {
		this.daxoa = daxoa;
	}

}
