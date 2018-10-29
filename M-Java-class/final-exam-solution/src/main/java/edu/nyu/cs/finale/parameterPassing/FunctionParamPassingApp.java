package edu.nyu.cs.finale.parameterPassing;
/*
 * Question 21 and 21 in Sample 1
 */
public class FunctionParamPassingApp {
	public static void main(String[] args) {
		Cat catObj = new Cat();
		catObj.setName("Cuddles");
		change(catObj, "Killer");
		System.out.println("Object param: change: "+catObj.getName());
		String cat = "Cuddles";
		change(cat, "Killer");
		System.out.println("String param: no change: "+cat);
		cat = returnChange(cat, "Killer");
		System.out.println("return overwrite original: "+cat);		
	}
	public static void change(Cat pCat, String name) {
		pCat.setName(name);
	}
	
	public static void change(String msg, String name) {
		msg = name;
	}
	
	public static String returnChange(String msg, String name) {
		msg = name;
		return msg;
	}
	
}
