package com.adventofcode.y2015.day1;

import java.util.Collection;

import com.adventofcode.BasicFileParser;
import com.adventofcode.FileParser;
import com.adventofcode.y2015.AbstractChallenge;

public class Day1Challenge1 extends AbstractChallenge {

	@Override
	public String execute(String inputFile) {
		FileParser fileParser = new BasicFileParser(getYear(), getDay(), inputFile);
		Collection<String> lineCollection = fileParser.getFileLines();
		for( String line : lineCollection ) {
			Integer floor = new Integer(0);
			for( int i = 0; i < line.length(); i++ ) {
				if( line.charAt(i) == '(' ) {
					floor++;
				}
				else if( line.charAt(i) == ')' ) {
					floor--;
				}
			}
			return floor.toString();
		}
		return "";
	}

}
