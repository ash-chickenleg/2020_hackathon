/*
 * Mt. Shasta Ski Simulator
 * 
 * Sam Platt
 * 4 April 2020
 * 
 * Run.java
 */

public class Run {
	
	// INSTANCE VARIABLES
	
	public String name; // The name of the run
	public String level; // The level of the run
	
	// CONSTRUCTORS
	
	public Run(String name, String level) {
		this.name = name;
		this.level = level;
	}
	
	/*
	 * Returns the name of the run as a String; 
	 */
	public String getRunName() {
		return name;
	}
	
	/*
	 * Returns the level of the run as a String; 
	 * This should return "green", "blue", or "black"; 
	 */
	public String getRunLevel() {
		return level;
		
	}
	
	
}
