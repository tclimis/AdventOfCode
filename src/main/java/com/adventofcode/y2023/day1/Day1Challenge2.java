package com.adventofcode.y2023.day1;

public class Day1Challenge2 extends Day1Challenge1 {

	@Override
	protected final String getFirstNumber(String input) {
		StringBuilder word = new StringBuilder();
		for( int i = 0; i < input.length(); i++ ) {
			String digit = findDigit(input.charAt(i), word, false);
			if( digit.length() > 0 ) {
				return digit;
			}
		}
		return "";
	}

	private String findDigit(char c, StringBuilder word, boolean reverse) {
		if( Character.isDigit(c) ) {
			return String.valueOf(c);
		}

		if( Character.isLetter(c) ) {
			word.append(c);
			if( word.length() >= 3 ) {
				String digit = findNumericWords(word, reverse);
				if( digit.length() > 0 ) {
					return digit;
				}
			}
		}
		return "";
	}

	private String findNumericWords(StringBuilder word, boolean reverse) {
		if( reverse ) {
			word.reverse();
		}

		if( word.toString().contains("one") ) {
			return "1";
		}

		if( word.toString().contains("two") ) {
			return "2";
		}

		if( word.toString().contains("three") ) {
			return "3";
		}

		if( word.toString().contains("four") ) {
			return "4";
		}

		if( word.toString().contains("five") ) {
			return "5";
		}

		if( word.toString().contains("six") ) {
			return "6";
		}

		if( word.toString().contains("seven") ) {
			return "7";
		}

		if( word.toString().contains("eight") ) {
			return "8";
		}

		if( word.toString().contains("nine") ) {
			return "9";
		}

		if( reverse ) {
			// unreverse
			word.reverse();
		}

		return "";
	}

	@Override
	protected final String getLastNumber(String input) {
		StringBuilder word = new StringBuilder();
		for( int i = input.length() - 1; i >= 0; i-- ) {
			String digit = findDigit(input.charAt(i), word, true);
			if( digit.length() > 0 ) {
				return digit;
			}
		}
		return "";
	}

}
