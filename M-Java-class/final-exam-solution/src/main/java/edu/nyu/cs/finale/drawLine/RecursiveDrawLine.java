package edu.nyu.cs.finale.drawLine;

public class RecursiveDrawLine {
	public void recursiveDrawLine(Point start, Point end, int recursiveNumber) {
		if(recursiveNumber == 0) {
			return;
		}
		Line line = new Line(start, end);
		System.out.println(recursiveNumber+" - "+line);
		int midX = (start.x+end.x)/2;
		int midY = (start.y+end.y)/2;
		Point mid = new Point(midX,midY);
		recursiveDrawLine(start, mid, recursiveNumber-1);
		recursiveDrawLine(mid, end, recursiveNumber-1);		
	}
	
	public static void main(String[] args) {
		Point start = new Point(0,0);
		Point end = new Point(800,800);
		new RecursiveDrawLine().recursiveDrawLine(start, end, 3);
	}
}
