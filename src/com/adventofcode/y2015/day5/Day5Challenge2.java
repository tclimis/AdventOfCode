package com.adventofcode.y2015.day5;

import com.adventofcode.BasicFileParser;
import com.adventofcode.FileParser;
import com.adventofcode.y2015.AbstractChallenge;

public class Day5Challenge2 extends AbstractChallenge {

	@Override
	public String execute(String inputFile) {
		int nice = 0;
		FileParser fileParser = new BasicFileParser(getYear(), getDay(), inputFile);
		for( String line : fileParser.getFileLines() ) {
			if( hasRepeatedTwoLetter(line) && hasThreeLetterSandwich(line) ) {
				nice++;
			}
		}
		return new Integer(nice).toString();
	}

	private boolean hasRepeatedTwoLetter(String name) {
		for( int i = 2; i < name.length(); i++ ) {
			if( name.substring(i).contains(name.substring(i - 2, i)) ) {
				return true;
			}
		}
		return false;
	}

	private boolean hasThreeLetterSandwich(String name) {
		for( int i = 2; i < name.length(); i++ ) {
			if( name.charAt(i - 2) == name.charAt(i) ) {
				return true;
			}
		}
		return false;
	}
}
