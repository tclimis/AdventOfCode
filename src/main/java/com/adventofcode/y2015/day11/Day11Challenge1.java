package com.adventofcode.y2015.day11;

import com.adventofcode.AbstractChallenge;

public class Day11Challenge1 extends AbstractChallenge {
	
	private String newPassword;
	
	public void initialize() {
		setNewPassword("");
	}
	
	private void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public void processLine(String input) {
		setNewPassword(createNewPassword(input));
	}

	private String createNewPassword(String oldPassword) {
		String tempNewPassword = ensureEightAlphaLowerCase(oldPassword);
		while (oldPassword.equals(tempNewPassword) || !containsStraight(tempNewPassword) || !containsTwoDoubles(tempNewPassword)
				|| containsIOL(tempNewPassword)) {
			tempNewPassword = nextPassword(tempNewPassword);
		}
		return tempNewPassword;
	}

	private String ensureEightAlphaLowerCase(String oldPassword) {
		StringBuilder passwordFiller = new StringBuilder();
		oldPassword = oldPassword.toLowerCase().replaceAll("[^a-z]", "");
		for (int i = 0; i < 8 - oldPassword.length(); i++) {
			passwordFiller.append("a");
		}

		return (oldPassword + passwordFiller).substring(0, 8);
	}

	private boolean containsStraight(final String string) {
		for (int i = 2; i < string.length(); i++) {
			if (string.charAt(i - 2) == string.charAt(i) - 2 && string.charAt(i - 1) == string.charAt(i) - 1) {
				return true;
			}
		}
		return false;
	}

	private boolean containsTwoDoubles(final String string) {
		int doublesFound = 0;
		char previousDoubleChar = '\0';
		for (int i = 1; i < string.length() && doublesFound < 2; i++) {
			if (string.charAt(i) != previousDoubleChar && string.charAt(i - 1) == string.charAt(i)) {
				previousDoubleChar = string.charAt(i);
				doublesFound++;
			}
		}
		return doublesFound >= 2;
	}

	private boolean containsIOL(final String string) {
		return string.matches("[ilo]");
	}

	private String nextPassword(final String password) {
		final char[] letters = password.toCharArray();

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
	
	public String getOutput() {
		return getNewPassword();
	}
	
	private String getNewPassword() {
		return this.newPassword;
	}
}
