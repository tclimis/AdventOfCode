package com.adventofcode.y2015.day6;

import com.adventofcode.y2015.day6.lightActions.LightAction;
import com.adventofcode.y2015.AbstractChallenge;

public class Day6Challenge1 extends AbstractChallenge {

	@Override
	public String execute(String inputFile) {
		int[][] lightFieldArray = new int[1000][1000];
		int lightCount = 0;
		Day6FileParser fileParser = new Day6FileParser(getYear(), getDay(), inputFile);
		for( String line : fileParser.getFileLines() ) {
			LightAction lightAction = fileParser.parseLine(line);
			lightAction.execute(lightFieldArray);
		}

		lightCount = countLightsOn(lightFieldArray);

		return new Integer(lightCount).toString();
	}

	protected int countLightsOn(int[][] lightFieldArray) {
		int lightsOn = 0;
		for( int[] element : lightFieldArray ) {
			for( int j = 0; j < element.length; j++ ) {
				lightsOn += element[j];
			}
		}
		return lightsOn;
	}
}
