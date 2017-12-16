package edu.nyu.cs.finale.drawLine;

public class Point {
	int x = 0;
	int y = 0;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	// Question 11
	public static void main(String[] args) {
		Point p1 = new Point(1,1);
		Point p2 = new Point(10,20);
	}

}
