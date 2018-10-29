package edu.nyu.cs.finale.overloaded;

public class OverloadedApp {
	String name;
	boolean gender;
	int age;
	public OverloadedApp(String name) {
		this.name = name;
	}
	public OverloadedApp(String name, boolean gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	public static void main(String[] args) {
		OverloadedApp app = new OverloadedApp("Eric Dunn");
		System.out.println(app);
		app = new OverloadedApp("Eric Dunn", true, 23);
		System.out.println(app);
	}
	
	
	// utility for testing 
	@Override
	public String toString() {
		return "OverloadedApp [name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
	
	
}
