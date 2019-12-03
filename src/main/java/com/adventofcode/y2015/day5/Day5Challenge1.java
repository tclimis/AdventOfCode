package com.adventofcode.y2015.day5;

import com.adventofcode.AbstractChallenge;

public class Day5Challenge1 extends AbstractChallenge {
	
	protected int nice;

	public void initialize() {
		nice = 0;
	}
	
	public void processLine(String input) {
		if( shouldIncreaseNice(input) ) {
			nice++;
		}
	}
		
	protected boolean shouldIncreaseNice(String name) {
		return hasThreeVowels(name) 
				&& hasDoubleLetter(name) 
				&& !hasABCDPQXY(name); 
	}

	private boolean hasThreeVowels(String name) {
		return name.split("[aeiou]", 4).length > 3;
	}

	private boolean hasDoubleLetter(String name) {
		for( int i = 1; i < name.length(); i++ ) {
			if( name.charAt(i - 1) == name.charAt(i) ) {
				return true;
			}
		}
		return false;
	}

	private boolean hasABCDPQXY(String name) {
		return name.contains("ab") || name.contains("cd") || name.contains("pq") || name.contains("xy");
	}
	
	public String getOutput() {
		return String.valueOf(nice);
	}
}
