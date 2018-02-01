package com.adventofcode.y2016.day19;

import com.adventofcode.BasicFileParser;
import com.adventofcode.FileParser;
import com.adventofcode.y2016.AbstractChallenge;

public class Day19Challenge1 extends AbstractChallenge {

	@Override
	public String execute(String inputFile) {
		FileParser parser = new BasicFileParser(getYear(), getDay(), inputFile);
		for( String line : parser.getFileLines() ) {}
		return "";
	}

}
