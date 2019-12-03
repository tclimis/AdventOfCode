package com.adventofcode.y2018.day2;

import java.util.ArrayList;
import java.util.List;

import com.adventofcode.AbstractChallenge;

public class Day2Challenge2 extends AbstractChallenge {
	
	List<String> file;
	
	public void initialize() {
		file = new ArrayList<String>();
	}

	@Override
	public void processLine(String input) {
		file.add(input);
	}
	
	public String getOutput() {
		for( int i = 0; i < file.size()-1; i++ ) {
			for( int j = i+1; j < file.size(); j++) {
				String match = getMatch(file.get(i), file.get(j));
				if( match.length() == file.get(i).length() - 1 ) {
					return match;
				}
			}
		}
		return "no match found";
	}
	
	private String getMatch(String base, String compare) {
		StringBuilder match = new StringBuilder();
		for( int j = 0; j < base.length(); j++ ) {
			if( base.charAt(j) == compare.charAt(j) ) {
				match.append(base.charAt(j));
			}
		}
		return match.toString();
	}
	
}

/*
Have a Merry Christmas and
a happy new year.

This year we did stuff.
Look at the pictures to see.
More haikus later.*/
