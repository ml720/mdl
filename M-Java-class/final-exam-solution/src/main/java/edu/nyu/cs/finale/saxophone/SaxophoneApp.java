package edu.nyu.cs.finale.saxophone;

public class SaxophoneApp {
	static String[] acceptable = new String[] {
			"accept 1",
			"accept 2",
			"accept 3"
	};
	public boolean validate(String note) {
		for(int i=0; i<acceptable.length; i++) {
			if(acceptable[i].equals(note)) {
				return true;
			}
		}
		return false;
	}
	// option to verify
	public static void main(String[] args) {
		SaxophoneApp app = new SaxophoneApp();
		String note = "accept 1";
		System.out.println(note+", acceptable="+app.validate(note));
		note = "not accept";
		System.out.println(note+", acceptable="+app.validate(note));
	}
}
