package com.adventofcode.y2015.day6;

import com.adventofcode.y2015.day6.lightActions.LightAction;

public class Day6Challenge2 extends Day6Challenge1 {
	
	public void processLine(String input) {
		LightAction lightAction = LineParser.parseLineOldElvish(input);
		lightAction.execute(getLightField());
	}

}
