package com.adventofcode.y2015.day11;

import com.adventofcode.BasicFileParser;
import com.adventofcode.FileParser;
import com.adventofcode.y2015.AbstractChallenge;

public class Day11Challenge1 extends AbstractChallenge {

	@Override
	public String execute(String inputFile) {
		String newPassword = "";
		FileParser fileParser = new BasicFileParser(getYear(), getDay(), inputFile);
		for( String password : fileParser.getFileLines() ) {
			newPassword = createNewPassword(password);
		}
		return newPassword;
	}

	private String createNewPassword(String oldPassword) {
		String newPassword = ensureEightAlphaLowerCase(oldPassword);
		while( oldPassword.equals(newPassword) || !containsStraight(newPassword) || !containsTwoDoubles(newPassword)
				|| containsIOL(newPassword) ) {
			newPassword = nextPassword(newPassword);
		}
		return newPassword;
	}

	private String ensureEightAlphaLowerCase(String oldPassword) {
		String passwordFiller = "";
		oldPassword.toLowerCase().replaceAll("[^a-z]", "");
		for( int i = 0; i < 8 - oldPassword.length(); i++ ) {
			passwordFiller += "a";
		}

		return (oldPassword + passwordFiller).substring(0, 8);
	}

	private boolean containsStraight(String string) {
		for( int i = 2; i < string.length(); i++ ) {
			if( string.charAt(i - 2) == string.charAt(i) - 2 && string.charAt(i - 1) == string.charAt(i) - 1 ) {
				return true;
			}
		}
		return false;
	}

	private boolean containsTwoDoubles(String string) {
		int doublesFound = 0;
		char previousDoubleChar = '\0';
		for( int i = 1; i < string.length() && doublesFound < 2; i++ ) {
			if( string.charAt(i) != previousDoubleChar && string.charAt(i - 1) == string.charAt(i) ) {
				previousDoubleChar = string.charAt(i);
				doublesFound++;
			}
		}
		return doublesFound >= 2;
	}

	private boolean containsIOL(String string) {
		return string.matches("[ilo]");
	}

	private String nextPassword(String password) {
		char[] letters = password.toCharArray();

		boolean carry = false;
		for( int i = letters.length - 1; i >= 0; i-- ) {
			if( i == letters.length - 1 // run for last char
					|| carry ) { // or the last char carried
				letters[i] = (char) (((letters[i] - 'a' + 1) % 26) + 'a');
				carry = letters[i] == 'a';
			}
			else {
				carry = false;
			}
		}
		return new String(letters);
	}
}
