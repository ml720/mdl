package edu.nyu.cs.finale.exam;

public class Exam {
	String[] questions;
	int defficultyLevel;
	String author;
	private int count = 0;
	public Exam() {
		questions = new String[] {
				"Question 1",
				"Question 2",
				"Question 3"
		};
	}
	public void askNextQuestion() {
		if(count == questions.length) {
			System.out.println("No more questions");
		} else {
			System.out.println(questions[count]);
			count++;
			askNextQuestion();
		}
	}
	
	public static void main(String[] args) {
		new Exam().askNextQuestion();
	}
}
