package com.adventofcode.y2016.day9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day9Challenge2 extends Day9Challenge1 {
	
	public String getOutput() {
		long decompressedLength = getDecompressedLength(compressedFile);
		return String.valueOf(decompressedLength);
	}

	private long getDecompressedLength(String compressedString) {
		Pattern pattern = Pattern.compile("\\(\\d+x\\d+\\)");
		Matcher matcher = pattern.matcher(compressedString);
		int index = 0;
		String decompressedSubString = "";
		long length = 0;
		while( matcher.find(index) ) {
			length += matcher.start() - index;
			int[] params = parseMarker(matcher.group());
			decompressedSubString = compressedString.substring(matcher.end(), matcher.end() + params[0]);
			index = matcher.end() + params[0];
			length += getDecompressedLength(decompressedSubString) * params[1];
		}
		length += compressedString.length() - index;
		return length;
	}

}
