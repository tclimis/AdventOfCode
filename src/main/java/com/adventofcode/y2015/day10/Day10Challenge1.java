package com.adventofcode.y2015.day10;

import com.adventofcode.AbstractChallenge;

public class Day10Challenge1 extends AbstractChallenge {
	
	private String pattern;

	public void initialize() {
		setPattern("");
	}
	
	private void setPattern(final String pattern) {
		this.pattern = pattern;
	}
	
	public void processLine(final String input) {
		final String[] args = input.split(" ");
		if( args.length == 2 ) {
			setPattern(args[0]);
			final int iterations = setIterations(args[1]);
			setPattern(getNewPattern(getPattern(), iterations));
		}
	}
	
	private int setIterations(final String arg) {
		try {
			return Integer.valueOf(arg).intValue();
		}
		catch( final NumberFormatException e ) {
			return 0;
		}
	}
	
	private String getPattern() {
		return this.pattern;
	}

	private String getNewPattern(final String pattern, final int iterations) {
		if( iterations == 0 ) {
			return pattern;
		}

		String newPattern = "";
		Integer counter = Integer.valueOf(1);
		for( int i = 1; i < pattern.length() + 1; i++ ) {
			if( i == pattern.length() || pattern.charAt(i - 1) != pattern.charAt(i) ) {
				newPattern += counter.toString() + pattern.charAt(i - 1);
				counter = 1;
			}
			// if this character equals the previous one
			else {
				counter++;
			}
		}
		return getNewPattern(newPattern, iterations - 1);
	}
	
	public String getOutput() {
		return Integer.valueOf(getPattern().length()).toString();
	}

}
