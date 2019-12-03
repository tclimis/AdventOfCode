package com.adventofcode;

public interface Challenge {
	
	/**
	 * sets up the initial state for the problem
	 * create empty base objects, etc.
	 */
	public void initialize();

	/**
	 * parses a line of the input file to populate data into the
	 * objects created in initialize()
	 * @param input a line of the input file
	 */
	public void processLine(String input);
	
	/**
	 * caclulates the result
	 * @return the output of the challenge
	 */
	public String getOutput();
	
	/**
	 * if the challenge needs to run as a loop, defines the stop condition.
	 * @return true to run again, false to stop running
	 */
	public boolean runAgain();
	
}
