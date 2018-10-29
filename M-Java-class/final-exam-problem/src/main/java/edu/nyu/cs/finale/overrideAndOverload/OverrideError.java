package edu.nyu.cs.finale.overrideAndOverload;

public class OverrideError extends Parent{

	// Compiler error message:
	// return type is incompatible with Parent.get();
	public Object get() {
		return null;
	}
}
