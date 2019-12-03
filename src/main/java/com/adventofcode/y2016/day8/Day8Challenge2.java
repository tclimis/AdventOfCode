package com.adventofcode.y2016.day8;

public class Day8Challenge2 extends Day8Challenge1 {
	
	public String getOutput() {
		return displayScreen();
	}
	
	private String displayScreen() {
		String display = "";
		for( int j = 0; j < getDisplay()[0].length; j++ ) {
			for( int i = 0; i < getDisplay().length; i++ ) {
				display += (getDisplay()[i][j]) ? "#" : ".";
			}
			display += "\n";
		}
		return display;
	}

}
