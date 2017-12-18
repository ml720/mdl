package edu.nyu.cs.finale.Interface;

public class HelloListener implements Listener{

	public void proc(String name) {
		System.out.println("Hello "+name);
	}
	public void proc(Event event) {
		System.out.println("Event: Hello "+event.getName());
	}

}
