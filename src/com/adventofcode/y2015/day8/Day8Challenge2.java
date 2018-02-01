package com.adventofcode.y2015.day8;

import com.adventofcode.BasicFileParser;
import com.adventofcode.FileParser;
import com.adventofcode.y2015.AbstractChallenge;

public class Day8Challenge2 extends AbstractChallenge {

	@Override
	public String execute(String inputFile) {
		int actualCharacters = 0;
		int encodedCharacters = 0;
		FileParser fileParser = new BasicFileParser(getYear(), getDay(), inputFile);
		for( String line : fileParser.getFileLines() ) {
			actualCharacters += line.length();
			encodedCharacters += getEncodedCharacters(line);
		}
		return new Integer(encodedCharacters - actualCharacters).toString();
	}

	private int getEncodedCharacters(String string) {
		return surroundWithQuotes(escapeWithBackslash(string)).length();
	}

	private String escapeWithBackslash(String string) {
		return string.replace("\\", "\\\\").replace("\"", "\\\"");
	}

	private String surroundWithQuotes(String string) {
		return "\"" + string + "\"";

	}
}
