package edu.nyu.cs.finale.drawLine;

public class Line {
	Point start;
	Point end;
	public Line(Point start, Point end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public String toString() {
		return "Line [start=" + start + ", end=" + end + "]";
	}

	// Question 13
	public static void main(String[] args) {
		Point start = new Point(0,0);
		Point end =  new Point(100,100);
		Line line = new Line(start, end);
	}
}
