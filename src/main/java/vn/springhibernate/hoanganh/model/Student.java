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

    @Column(name = "lastName")
	private String lastName;
    
    @Column(name = "firstName")
	private String firstName;

    @Column(name = "dayOfBirth")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dayOfBirth;
    
    @Column(name = "classname")
	private String classname;
    
    @Column(name = "process")
	private String process;

    @Column(name = "midTerm")
	private String midTerm;

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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(Date dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
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

	public String getMidTerm() {
		return midTerm;
	}

	public void setMidTerm(String midTerm) {
		this.midTerm = midTerm;
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
