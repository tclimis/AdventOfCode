package com.adventofcode.y2015.day2;

import java.util.Arrays;

import com.adventofcode.AbstractChallenge;

public class Day2Challenge2 extends AbstractChallenge {
	
	private int totalRibbon;

	public void initialize() {
		setTotalRibbon(0);
	}
	
	private void setTotalRibbon(int totalRibbon) {
		this.totalRibbon = totalRibbon;
	}
	
	public void processLine(String input) {
		int[] dimensions = LineParser.parseLineToArray(input);
		setTotalRibbon(getTotalRibbon() + calculateRequiredRibbon(dimensions));
	}
	
	private int getTotalRibbon() {
		return this.totalRibbon;
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
	
	public String getOutput() {
		return String.valueOf(totalRibbon);
	}
}
