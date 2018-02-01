package com.adventofcode.y2015.day2;

import java.util.Arrays;
import java.util.Collection;

import com.adventofcode.y2015.AbstractChallenge;

public class Day2Challenge1 extends AbstractChallenge {

	@Override
	public String execute(String inputFile) {
		Day2FileParser fileParser = new Day2FileParser(getYear(), getDay(), inputFile);
		Collection<String> lines = fileParser.getFileLines();
		int totalWrappingPaper = 0;
		for( String line : lines ) {
			int[] dimensions = fileParser.parseLineToArray(line);
			totalWrappingPaper += calculateWrappingPaper(dimensions);
		}
		return new Integer(totalWrappingPaper).toString();
	}

	private int calculateWrappingPaper(int[] dimensions) {
		int wrappingPaperArea = 0;

		if( dimensions.length == 3 ) {
			int surfaceArea = 2 * (dimensions[0] * dimensions[1] + dimensions[0] * dimensions[2] + dimensions[1]
					* dimensions[2]);
			Arrays.sort(dimensions);
			int areaOfSmallestSide = dimensions[0] * dimensions[1];
			wrappingPaperArea = surfaceArea + areaOfSmallestSide;
		}

		return wrappingPaperArea;
	}

}
