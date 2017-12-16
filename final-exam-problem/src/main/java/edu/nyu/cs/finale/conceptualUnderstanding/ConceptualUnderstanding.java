package edu.nyu.cs.finale.conceptualUnderstanding; 
 
/* assume that the following imports all exist and do not contain errors */ 
import edu.nyu.cs.finale.Concept // Error 1
import edu.nyu.cs.finale.Being; 
import edu.nyu.cs.finale.Nothingness;  
 
public class ConceptualUnderstanding { 
  private String accumulatedWisdom[] = new String[]; // Error 2
  private int wisdomCounter = 0; 
  private static Concept[] concepts; 
  
public static void main(String[] args) { 
    this.concepts = { // Error 3-4
new Being(), 
new Nothingness() 
}; 
for (int i=0; i<concepts.length; i++) { 
String details = concepts[i].getSummary(); 
  try { 
if (this.comprehend(details)) { // Error 5
  System.out.println(“Got it!”); 
} 
else { 
  System.out.println(“Skipping...”); 
  continue; // Warning 1
} 
      } 
catch (LackOfConceptualClarityException e) { // Warning 2
  System.out.println(“Sorry, we’re lost.”); 
} 
catch (GeneralizedExistentialException e) { // Error 6
  System.out.println(“We must carry on.”); 
} 
 }
 
  } 
  
public static comprehend(String details) { // Error 7-8
      if (details.indexOf(“monism”) > 0 || details.length > 500) { // Error 9 
    throw new LackOfConceptualClarityException(); 
    return false; // Error 10
    } 
    else { 
  this.accumulatedWisdom[this.wisdomCounter] = details; // Error 11
  this.wisdomCounter++; 
  return true; 
    } 
  } 
} 