package edu.nyu.cs.finale.course;

import java.util.Arrays;

public class ComputerSicenceCourse {
	String title;
	String description;
	String[] days;
	String time;
	Student[] students;
	int numberOfStudent = 0;
	public ComputerSicenceCourse(String title,
			String description,
			String[] days,
			String time,
			Student[] students) {
		this.title = title;
		this.description = description;
		this.days = days;
		this.time = time;
		this.students = students;
	}
	public void registerStudent(Student student) {
		// if statement is option code 
		if(numberOfStudent == students.length) {
			throw new RuntimeException("class is full");
		}
		students[numberOfStudent] = student;
		numberOfStudent++;
	}
	
	@Override
	public String toString() {
		return "ComputerSicenceCourse [title=" + title + ", description=" + description + ", days="
				+ Arrays.toString(days) + ", time=" + time + ", students=" + Arrays.toString(students) + "]";
	}
	public static void main(String[] args) { 
		ComputerSicenceCourse computerSicenceCourse = new ComputerSicenceCourse(
				"Computer Sicence 101",
				"Basic Computer Sicence Knowledge",
				new String[] {"Monday","Wednesday","Friday"},
				"9:30-10:45",
				new Student[50]
				);
		Student michael = new Student("Micheal LI","michael.li@nyu.edu",3);
		computerSicenceCourse.registerStudent(michael);
		Student other = new Student("other","other@nyu.edu",1);
		computerSicenceCourse.registerStudent(other);
		michael.assignGrade("A");
		other.assignGrade("B");
		// note required code but for verify
		System.out.println(computerSicenceCourse);
	}
	
	
}
