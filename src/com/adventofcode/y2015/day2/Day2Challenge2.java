package com.adventofcode.y2015.day2;

import java.util.Arrays;
import java.util.Collection;

import com.adventofcode.y2015.AbstractChallenge;

public class Day2Challenge2 extends AbstractChallenge {

	@Override
	public String execute(String inputFile) {
		int totalRibbon = 0;
		Day2FileParser fileParser = new Day2FileParser(getYear(), getDay(), inputFile);
		Collection<String> lines = fileParser.getFileLines();
		for( String line : lines ) {
			int[] dimensions = fileParser.parseLineToArray(line);
			totalRibbon += calculateRequiredRibbon(dimensions);
		}
		return new Integer(totalRibbon).toString();
	}

	private int calculateRequiredRibbon(int[] dimensions) {
		int requiredRibbon = 0;
		if( dimensions.length == 3 ) {
			int bow = dimensions[0] * dimensions[1] * dimensions[2];
			Arrays.sort(dimensions);
			int perimeterOfSmallestSide = 2 * (dimensions[0] + dimensions[1]);

			requiredRibbon = bow + perimeterOfSmallestSide;
		}

		return requiredRibbon;
	}
}
