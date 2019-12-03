package com.adventofcode.y2015.day8;

import com.adventofcode.AbstractChallenge;

public class Day8Challenge1 extends AbstractChallenge {
	
	protected int actualCharacters;
	private int interprettedCharacters;
	
	public void initialize() {
		actualCharacters = 0;
		interprettedCharacters = 0;
	}
	
	public void processLine(String input) {
		actualCharacters += input.length();
		interprettedCharacters += getInterprettedCharacters(input);
	}

	private int getInterprettedCharacters(String string) {
		return stripBackslash(replaceUnicode(stripFirstLastQuote(string))).length();
	}

	private String stripFirstLastQuote(String string) {
		if( string.startsWith("\"") && string.endsWith("\"") ) {
			return string.substring(1, string.length() - 1);
		}

		return string;
	}

	private String replaceUnicode(String string) {
		return string.replaceAll("\\\\x[0-9a-f]{2}", "a");
	}

	private String stripBackslash(String string) {
		return string.replaceAll("\\\\.", "a");
	}
	
	public String getOutput() {
		return String.valueOf(actualCharacters - interprettedCharacters);
	}
	
}
