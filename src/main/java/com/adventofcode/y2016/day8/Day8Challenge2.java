package com.adventofcode.y2016.day8;

public class Day8Challenge2 extends Day8Challenge1 {
	
	@Override
	public String getOutput() {
		return displayScreen();
	}
	
	private String displayScreen() {
		StringBuilder display = new StringBuilder();
		for( int j = 0; j < getDisplay()[0].length; j++ ) {
			for( int i = 0; i < getDisplay().length; i++ ) {
				display.append(getDisplay()[i][j] ? "#" : ".");
			}
			display.append("\n");
		}
		return display.toString();
	}

}
