package com.adventofcode;

public interface Challenge {
	
	public void initialize();

	public void processLine(String input);
	
	public String getOutput();
	
	public boolean runAgain();
	
}
