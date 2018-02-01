package com.adventofcode.y2015.day1;

import java.util.Collection;

import com.adventofcode.BasicFileParser;
import com.adventofcode.FileParser;
import com.adventofcode.y2015.AbstractChallenge;

public class Day1Challenge2 extends AbstractChallenge {

	@Override
	public String execute(String inputFile) {
		FileParser fileParser = new BasicFileParser(getYear(), getDay(), inputFile);
		Collection<String> lines = fileParser.getFileLines();
		for( String line : lines ) {
			Integer floor = new Integer(0);
			for( int i = 0; i < line.length(); i++ ) {
				if( line.charAt(i) == '(' ) {
					floor++;
				}
				else if( line.charAt(i) == ')' ) {
					floor--;
				}
				if( floor < 0 ) {
					return new Integer(++i).toString();
				}
			}
		}
		return "";
	}

}
