package com.adventofcode;

public class NullChallenge extends AbstractChallenge {
	
	@Override
	public void initialize() { 
		// the null challenge doesn't do anything
	}

	@Override
	public void processLine(final String input) { 
		// the null challenge has nothing to process
	}
	
	@Override
	public String getOutput() {
		return "Challenge not found";
	}

}
