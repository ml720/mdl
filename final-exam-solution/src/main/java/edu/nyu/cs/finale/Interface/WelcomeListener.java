package edu.nyu.cs.finale.Interface;

public class WelcomeListener implements Listener{

	public void proc(String value) {
		System.out.println("Welcome: "+value);
	}
	public void proc(Event event) {
		System.out.println("Event: Welcome "+event.getName());
	}

}
