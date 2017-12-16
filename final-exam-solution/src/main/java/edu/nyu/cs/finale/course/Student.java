package edu.nyu.cs.finale.course;

public class Student {
	String name;
	String email;
	int year;
	String grade;
	public Student(String name, String email, int year) {
		this.name = name;
		this.email = email;
		this.year = year;
	}
	public void assignGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + ", year=" + year + ", grade=" + grade + "]";
	}
}
