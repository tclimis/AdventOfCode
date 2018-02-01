package com.adventofcode.y2016.day9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.adventofcode.BasicFileParser;
import com.adventofcode.FileParser;
import com.adventofcode.y2016.AbstractChallenge;

public class Day9Challenge1 extends AbstractChallenge {

	@Override
	public String execute(String inputFile) {
		String decompressedFile = "";
		String compressedFile = "";
		FileParser parser = new BasicFileParser(getYear(), getDay(), inputFile);
		for( String line : parser.getFileLines() ) {
			compressedFile += line;
		}
		decompressedFile = decompress(compressedFile);
		return String.valueOf(decompressedFile.length());
	}

	private String decompress(String compressedString) {
		Pattern pattern = Pattern.compile("\\(\\d+x\\d+\\)");
		Matcher matcher = pattern.matcher(compressedString);
		int index = 0;
		String decompressedString = "";
		while( matcher.find(index) ) {
			int[] params = parseMarker(matcher.group());
			for( int i = 0; i < params[1]; i++ ) {
				decompressedString += compressedString.substring(matcher.end(), matcher.end() + params[0]);
			}
			index = matcher.end() + params[0];
		}
		return decompressedString;
	}

	private int[] parseMarker(String marker) {
		int[] params = { 0, 0 };
		if( marker.startsWith("(") && marker.endsWith(")") ) {
			String numbers = marker.substring(1, marker.length() - 1);
			String[] numberArray = numbers.split("x");
			if( numberArray.length == 2 ) {
				try {
					params[0] = Integer.parseInt(numberArray[0]);
					params[1] = Integer.parseInt(numberArray[1]);
				}
				catch( NumberFormatException e ) {
					params[0] = 0;
					params[1] = 0;
				}
			}
		}
		return params;
	}
}
