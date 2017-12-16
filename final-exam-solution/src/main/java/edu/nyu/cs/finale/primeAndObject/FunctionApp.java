package edu.nyu.cs.finale.primeAndObject;

public class FunctionApp {
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6};
		System.out.println("main: "+toString(arr));
		change(arr, new int[] {7,8,9});
		System.out.println("main: "+toString(arr));
		replace(arr, new int[] {0,0,0});
		System.out.println("main: "+toString(arr));
	}
	public static void change(int[] src, int[] toChange) {
		for (int i=0; i<toChange.length; i++) {
			src[i] = toChange[i];
		}
		System.out.println("toChange: "+toString(src));
	}
	public static void replace(int[] src, int[] replace) {
		src = replace;
		System.out.println("replace: "+toString(src));
	}
	public static String toString(int[] data) {
		String s = "";
		for(int i=0; i<data.length; i++) {
			s += " "+data[i];
		}
		return s.trim();
	}
	
}
