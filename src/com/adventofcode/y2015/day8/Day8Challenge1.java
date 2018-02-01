package com.adventofcode.y2015.day8;

import com.adventofcode.BasicFileParser;
import com.adventofcode.FileParser;
import com.adventofcode.y2015.AbstractChallenge;

public class Day8Challenge1 extends AbstractChallenge {

	@Override
	public String execute(String inputFile) {
		int actualCharacters = 0;
		int interprettedCharacters = 0;
		FileParser fileParser = new BasicFileParser(getYear(), getDay(), inputFile);
		for( String line : fileParser.getFileLines() ) {
			actualCharacters += line.length();
			interprettedCharacters += getInterprettedCharacters(line);
		}
		return new Integer(actualCharacters - interprettedCharacters).toString();
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
}
