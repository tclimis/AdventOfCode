package com.adventofcode.y2016.day5;

import java.util.logging.Logger;

public class Day5Challenge2 extends Day5Challenge1 {
	
	@Override
	protected String getDoorCode(String input) {
		String doorCode = "";
		char[] doorCodeArray = { '-', '-', '-', '-', '-', '-', '-', '-' };
		int i = 0;
		while( String.valueOf(doorCodeArray).indexOf('-') > -1 ) {
			String hash = getHash(input + String.valueOf(i++));
			if( hash.matches("^0{5}[0-7][0-9A-F]+") && doorCodeArray[Character.getNumericValue(hash.charAt(5))] == '-' ) {
				doorCodeArray[Character.getNumericValue(hash.charAt(5))] = hash.charAt(6);
				String doorCodeString = String.valueOf(doorCodeArray);
				Logger.getGlobal().info(doorCodeString);
			}
		}
		doorCode = String.valueOf(doorCodeArray);
		return doorCode.toLowerCase();
	}
}
