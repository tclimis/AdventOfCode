package com.adventofcode.y2018.day2;

import com.adventofcode.AbstractChallenge;

public class Day2Challenge1 extends AbstractChallenge {
	
	private int two;
	private int three;
	
	public void initialize() {
		setTwo(0);
		setThree(0);
	}
	
	private void setTwo(int two) {
		this.two = two;
	}
	
	private void setThree(int three) {
		this.three = three;
	}

	public void processLine(String input) {
		if( hasThreeTheSame(input) ) {
			setThree(getThree() + 1);
		}
		if( hasTwoTheSame(input) ) {
			setTwo(getTwo() + 1);
		}
	}
	
	private boolean hasThreeTheSame(String word) {
		return hasNTheSame(word, 3);
	}
	
	private boolean hasNTheSame(String word, int n) {
		for( int i = 0; i < word.length(); i++ ) {
			if( countChars(word, word.charAt(i)) == n ) {
				return true;
			}
		}
		return false;
	}
	
	private int countChars(String haystack, char needle) {
		int count = 0;
		for(int i = 0; i < haystack.length(); i++) {
			if( haystack.charAt(i) == needle ) {
				count++;
			}
		}
		return count;
	}
	
	private int getThree() {
		return this.three;
	}
		
	private boolean hasTwoTheSame(String word) {
		return hasNTheSame(word, 2);
	}
	
	private int getTwo() {
		return this.two;
	}
	
	public String getOutput() {
		int output = getTwo() * getThree();
		return String.valueOf(output);
	}

}
