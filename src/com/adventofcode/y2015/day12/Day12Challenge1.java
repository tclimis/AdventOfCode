package com.adventofcode.y2015.day12;

import com.adventofcode.FileParser;
import com.adventofcode.y2015.AbstractChallenge;

public class Day12Challenge1 extends AbstractChallenge {

	@Override
	public String execute(String inputFile) {
		Integer total = new Integer(0);
		FileParser fileParser = new Day12FileParser(getYear(), getDay(), inputFile);
		for( String line : fileParser.getFileLines() ) {
			String[] jsonArray = line.split("[\\[\\]\\{\\}:,=]");
			for( String element : jsonArray ) {
				try {
					Integer intVal = new Integer(element);
					total += intVal;
				}
				catch( NumberFormatException e ) {}
			}
		}
		return total.toString();
	}
}
