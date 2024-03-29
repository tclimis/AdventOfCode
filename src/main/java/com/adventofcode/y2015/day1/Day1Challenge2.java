package com.adventofcode.y2015.day1;

public class Day1Challenge2 extends Day1Challenge1 {
	
	private int steps;
	
	@Override
	public void initialize() {
		super.initialize();
		setSteps(0);
	}
	
	private void setSteps(final int steps) {
		this.steps = steps;
	}

	@Override
	public void processLine(final String input) {
		for( int i = 0; i < input.length(); i++ ) {
			if( getFloor() >= 0 ) {
				super.move(input.charAt(i));
			}
			else {
				setSteps(i + 1);
			}
		}
	}
	
	@Override
	public String getOutput() {
		return String.valueOf(getSteps());
	}
	
	private int getSteps() {
		return this.steps;
	}

}
