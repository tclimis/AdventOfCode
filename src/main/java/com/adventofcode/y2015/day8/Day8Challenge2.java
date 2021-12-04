package com.adventofcode.y2015.day8;

public class Day8Challenge2 extends Day8Challenge1 {
	
	private int encodedCharacters;
	
	@Override
	public void initialize() {
		super.initialize();
		encodedCharacters = 0;
	}

	@Override
	public void processLine(String input) {
		actualCharacters += input.length();
		encodedCharacters += getEncodedCharacters(input);
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
	
	@Override
	public String getOutput() {
		return String.valueOf(encodedCharacters - actualCharacters);
	}
	
}
