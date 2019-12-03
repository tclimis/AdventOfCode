package com.adventofcode;

public abstract class AbstractChallenge implements Challenge {

	@Override
	abstract public void initialize();

	@Override
	abstract public void processLine(String input);

	@Override
	abstract public String getOutput();
	
	@Override
	public boolean runAgain() {
		return false;
	}

}
