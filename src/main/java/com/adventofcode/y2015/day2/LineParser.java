package com.adventofcode.y2015.day2;

public class LineParser {
	
	public static int[] parseLineToArray(String line) {
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
