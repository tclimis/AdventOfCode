package com.adventofcode.y2023.day1;

import com.adventofcode.AbstractChallenge;

public class Day1Challenge1 extends AbstractChallenge {

	int runningTotal;

	@Override
	public void initialize() {
		runningTotal = 0;
	}

	@Override
	public void processLine(String input) {
		runningTotal += Integer.valueOf(getFirstNumber(input) + getLastNumber(input));
	}

	protected String getFirstNumber(String input) {
		for( char c : input.toCharArray() ) {
			if( Character.isDigit(c) ) {
				return String.valueOf(c);
			}
		}
		return "";
	}

	protected String getLastNumber(String input) {
		String tupni = new StringBuilder(input).reverse().toString();
		for( char c : tupni.toCharArray() ) {
			if( Character.isDigit(c) ) {
				return String.valueOf(c);
			}
		}
		return "";
	}

	@Override
	public String getOutput() {
		return String.valueOf(runningTotal);
	}

}
