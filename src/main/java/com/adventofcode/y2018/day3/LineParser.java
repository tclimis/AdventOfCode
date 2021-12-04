package com.adventofcode.y2018.day3;

public class LineParser {

	private LineParser() {}

	public static Rectangle getRectangle(String input) {
		String[] commands = input.replaceFirst("#", "").split("([,x]| @ |: )");
		if( commands.length == 5 ) {
			return new Rectangle(commands[0], commands[1], commands[2], commands[3], commands[4]);
		}
		return new Rectangle("", "", "", "", "");
	}

}
