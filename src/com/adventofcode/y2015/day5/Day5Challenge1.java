package com.adventofcode.y2015.day5;

import com.adventofcode.BasicFileParser;
import com.adventofcode.FileParser;
import com.adventofcode.y2015.AbstractChallenge;

public class Day5Challenge1 extends AbstractChallenge {

	@Override
	public String execute(String inputFile) {
		int nice = 0;
		FileParser fileParser = new BasicFileParser(getYear(), getDay(), inputFile);
		for( String line : fileParser.getFileLines() ) {
			if( hasThreeVowels(line) && hasDoubleLetter(line) && !hasABCDPQXY(line) ) {
				nice++;
			}
		}
		return new Integer(nice).toString();
	}

	private boolean hasThreeVowels(String name) {
		return name.split("[aeiou]", 4).length > 3;
	}

	private boolean hasDoubleLetter(String name) {
		for( int i = 1; i < name.length(); i++ ) {
			if( name.charAt(i - 1) == name.charAt(i) ) {
				return true;
			}
		}
		return false;
	}

	private boolean hasABCDPQXY(String name) {
		return name.contains("ab") || name.contains("cd") || name.contains("pq") || name.contains("xy");
	}
}
