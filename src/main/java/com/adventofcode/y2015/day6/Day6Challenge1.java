package com.adventofcode.y2015.day6;

import com.adventofcode.AbstractChallenge;
import com.adventofcode.y2015.day6.lightActions.LightAction;

public class Day6Challenge1 extends AbstractChallenge {
	
	private int[][] lightFieldArray;
	
	public void initialize() {
		lightFieldArray = new int[1000][1000];
	}
	
	public void processLine(String input) {
		LightAction lightAction = LineParser.parseLine(input);
		lightAction.execute(getLightField());
	}
	
	protected int[][] getLightField() {
		return lightFieldArray;
	}
	
	public String getOutput() {
		return String.valueOf(countLightsOn(getLightField()));
	}
	
	private int countLightsOn(int[][] lightFieldArray) {
		int lightsOn = 0;
		for( int[] element : lightFieldArray ) {
			for( int j = 0; j < element.length; j++ ) {
				lightsOn += element[j];
			}
		}
		return lightsOn;
	}
}
