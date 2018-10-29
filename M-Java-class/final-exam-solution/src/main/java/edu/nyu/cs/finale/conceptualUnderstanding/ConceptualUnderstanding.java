package edu.nyu.cs.finale.conceptualUnderstanding;

import edu.nyu.cs.finale.conceptualUnderstanding.Being;
// Error 1: missing ';' at end of the statement
// -> import edu.nyu.cs.finale.Concept 
import edu.nyu.cs.finale.conceptualUnderstanding.Concept;
import edu.nyu.cs.finale.conceptualUnderstanding.Nothingness;

public class ConceptualUnderstanding {
	// Error 2: missing size of array
	// -> private String accumulatedWisdom[] = new String[];
	// It can fix by adding size as below
	// or with values directly as new String[] {"A","B","C"};
	private static String accumulatedWisdom[] = new String[3];
	private static int wisdomCounter = 0;
	private static Concept[] concepts;

public static void main(String[] args) { 
	// Error 3: "this" is invalid in static method
	//			it can only be used in instance method
	// Error 4: missing new Concept[]
	// -> this.concepts = { 
    concepts = new Concept[] { 
    	new Being(), 
    	new Nothingness() 
    }; 
    for (int i=0; i<concepts.length; i++) { 
    	String details = concepts[i].getSummary(); 
    	try { 
    		// Error 5: "this" is invalid in static method
    		// -> if (this.comprehend(details)) { 
    		if (comprehend(details)) { 
    			System.out.println("Got it!"); 
    		} 
    		else { 
    			System.out.println("Skipping..."); 
    			// (Logic) Warning 1: continue is not necessary
    			continue; 
    		} 
    	} 
    	// Warning 2: assuming LackOfConceptualClarityException is defined
    	// in the same package. Otherwise, must import it
    	catch (LackOfConceptualClarityException e) { 
    		System.out.println("Sorry, we’re lost."); 
    	}
    	// Error 6: comprehend method() does not throw GeneralizedExistentialException
    	// 		catch statement below is invalid
    	// -> catch (GeneralizedExistentialException e) { 
    	// ->	System.out.println("We must carry on."); 
    	// ->} 
 }
 
  }

	// Error 7: missing return boolean
	// Error 8: missing throws LackOfConceptualClarityException
	// -> public static comprehend(String details) { 
	public static boolean comprehend(String details) throws LackOfConceptualClarityException{
		// Error 9: details has no field length
		//  	should use length() method
		// -> if (details.indexOf(“monism”) > 0 || details.length > 500) { 
		if (details.indexOf("monism") > 0 || details.length() > 500) { 
			throw new LackOfConceptualClarityException(); 
			// (Logic) Error 10: unreachable code
			// -> return false; 
		} 
		else { 
			// Error 11: "this" is invalid in static method
			// -> this.accumulatedWisdom[this.wisdomCounter] = details; 
			// -> this.wisdomCounter++; 
			// fix need change accumulatedWisdom[] 
			// and wisdomCounter fields to static
			accumulatedWisdom[wisdomCounter] = details; 
			wisdomCounter++; 
			return true; 
		} 
	}
}