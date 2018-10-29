package edu.nyu.cs.finale.overrideAndOverload;

public class OverloadError {
	// compiler error: duplicated method
	public String get() {
		return "";
	}
	// compiler error: duplicated method
	public int get() {
		return 0;
	}
}
