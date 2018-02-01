package com.adventofcode.y2015.day2;

import com.adventofcode.BasicFileParser;

public class Day2FileParser extends BasicFileParser {
	public Day2FileParser(int year, int day, String fileName) {
		super(year, day, fileName);
	}

	public int[] parseLineToArray(String line) {
		int[] intArray = new int[3];

		String[] stringArray = line.split("x");
		if( stringArray.length == 3 ) {
			for( int i = 0; i < stringArray.length; i++ ) {
				try {
					Integer number = Integer.parseInt(stringArray[i]);
					intArray[i] = number.intValue();
				}
				catch( NumberFormatException e ) {
					intArray[i] = 0;
				}
			}
		}
		return intArray;
	}
}
