package edu.nyu.cs.finale.Interface;

/*
 * Interface demo
 * 
 * Both HelloListener and WelcomeListener implement Listener interface
 * But their proc method print same input parameter with different
 * prefix.
 */
public class InterfaceApp {
	public static void main(String[] args) {
		Listener[] listeners = new Listener[] {
				new HelloListener(),
				new WelcomeListener()
		};
		for(int i=0; i<listeners.length; i++) {
			Listener l = listeners[i];
			l.proc("Michael");
		}
		Event e = new Event();
		e.setName("Michael Li");
		for(int i=0; i<listeners.length; i++) {
			Listener l = listeners[i];
			l.proc(e);
		}
	}
}
