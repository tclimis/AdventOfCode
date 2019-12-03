package com.adventofcode.y2015.day1;

import com.adventofcode.AbstractChallenge;

public class Day1Challenge1 extends AbstractChallenge {
	
	private Integer floor;
	
	public void initialize() {
		setFloor(Integer.valueOf(0));
	}
	
	private void setFloor(Integer floor) {
		this.floor = floor;
	}

	public void processLine(String input) {
		for( int i = 0; i < input.length(); i++ ) {
			move(input.charAt(i));
		}
	}
	
	protected void move(char control) {
		if( control == '(' ) {
			setFloor(getFloor() + 1);
		}
		else if( control == ')' ) {
			setFloor(getFloor() - 1 );
		}
	}
	
	protected Integer getFloor() {
		return this.floor;
	}
	
	public String getOutput() {
		return getFloor().toString();
	}

}
