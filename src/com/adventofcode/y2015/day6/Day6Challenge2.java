package com.adventofcode.y2015.day6;

import com.adventofcode.y2015.day6.lightActions.LightAction;

public class Day6Challenge2 extends Day6Challenge1 {

	@Override
	public String execute(String inputFile) {
		int[][] lightFieldArray = new int[1000][1000];
		int lightCount = 0;
		Day6FileParser fileParser = new Day6FileParser(getYear(), getDay(), inputFile);
		for( String line : fileParser.getFileLines() ) {
			LightAction lightAction = fileParser.parseLineOldElvish(line);
			lightAction.execute(lightFieldArray);
		}

		lightCount = countLightsOn(lightFieldArray);

		return new Integer(lightCount).toString();
	}

}
