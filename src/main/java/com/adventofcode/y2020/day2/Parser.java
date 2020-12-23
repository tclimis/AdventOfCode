package com.adventofcode.y2020.day2;

public class Parser {

    private Parser() {}

	public static Character getCharacter(String rule) {
		String[] pieces = rule.split(" ");
        if( pieces.length == 2 && pieces[1].trim().length() == 1 ) {
            return pieces[1].charAt(0);
        }

        return '\0';
	}

	public static Integer getFirstNumber(String rule) {
		String minString = rule.split(" ")[0].split("-")[0];
        return Integer.valueOf(minString);
	}

	public static Integer getSecondNumber(String rule) {
		String[] pieces = rule.split(" ")[0].split("-");
        if( pieces.length == 2 ) {
            return Integer.valueOf(pieces[1]);
        }

        return 0;
	}

}
