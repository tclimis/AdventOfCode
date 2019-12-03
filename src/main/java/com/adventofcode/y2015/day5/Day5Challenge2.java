package com.adventofcode.y2015.day5;

public class Day5Challenge2 extends Day5Challenge1 {
	
	protected boolean shouldIncreaseNice(String name) {
		return hasRepeatedTwoLetter(name) 
				&& hasThreeLetterSandwich(name);
	}

	private boolean hasRepeatedTwoLetter(String name) {
		for( int i = 2; i < name.length(); i++ ) {
			if( name.substring(i).contains(name.substring(i - 2, i)) ) {
				return true;
			}
		}
		return false;
	}

	private boolean hasThreeLetterSandwich(String name) {
		for( int i = 2; i < name.length(); i++ ) {
			if( name.charAt(i - 2) == name.charAt(i) ) {
				return true;
			}
		}
		return false;
	}
}
