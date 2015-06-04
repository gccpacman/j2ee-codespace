package com.batis.mybatisdao.tests.model;



public class Student {
	private int rollNo;
	private String studentName;
	private int marks;
	
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	public String toString(){
		return "[Status]" + "(" + rollNo + ")" + studentName + "Marks:" + marks;
	}
	
}
