package com.adventofcode.y2015.day10;

import com.adventofcode.BasicFileParser;
import com.adventofcode.FileParser;
import com.adventofcode.y2015.AbstractChallenge;

public class Day10Challenge1 extends AbstractChallenge {

	@Override
	public String execute(String inputFile) {
		FileParser fileParser = new BasicFileParser(getYear(), getDay(), inputFile);
		String pattern = "";
		for( String line : fileParser.getFileLines() ) {
			String[] args = line.split(" ");
			if( args.length == 2 ) {
				pattern = args[0];
				int iterations = 0;
				try {
					iterations = new Integer(args[1]).intValue();
				}
				catch( NumberFormatException e ) {}
				pattern = getNewPattern(pattern, iterations);
			}
		}
		return new Integer(pattern.length()).toString();
	}

	private String getNewPattern(String pattern, int iterations) {
		if( iterations == 0 ) {
			return pattern;
		}

		String newPattern = "";
		Integer counter = new Integer(1);
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

}
