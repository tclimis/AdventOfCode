package com.adventofcode.y2015.day2;

import java.util.Arrays;

import com.adventofcode.AbstractChallenge;

public class Day2Challenge1 extends AbstractChallenge {

	private int totalWrappingPaper;
	
	public void initialize() {
		setTotalWrappingPaper(0);
	}
	
	private void setTotalWrappingPaper(int totalWrappingPaper) {
		this.totalWrappingPaper = totalWrappingPaper;
	}
	
	public void processLine(String input) {
		int[] dimensions = LineParser.parseLineToArray(input);
		setTotalWrappingPaper(getTotalWrappingPaper() + calculateWrappingPaper(dimensions));
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
	
	public String getOutput() {
		return Integer.toString(getTotalWrappingPaper());
	}
	
	private int getTotalWrappingPaper() {
		return this.totalWrappingPaper;
	}

}
