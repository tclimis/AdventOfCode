package com.adventofcode.y2015.day6;

import java.awt.Point;

import com.adventofcode.BasicFileParser;
import com.adventofcode.y2015.day6.lightActions.LightAction;
import com.adventofcode.y2015.day6.lightActions.LightsDownAction;
import com.adventofcode.y2015.day6.lightActions.LightsOffAction;
import com.adventofcode.y2015.day6.lightActions.LightsOnAction;
import com.adventofcode.y2015.day6.lightActions.LightsUpAction;
import com.adventofcode.y2015.day6.lightActions.LightsWayUpAction;
import com.adventofcode.y2015.day6.lightActions.NullLightAction;
import com.adventofcode.y2015.day6.lightActions.ToggleLightsAction;

public class Day6FileParser extends BasicFileParser {

	public Day6FileParser(int year, int day, String fileName) {
		super(year, day, fileName);
	}

	public LightAction parseLine(String line) {
		LightAction lightAction = new NullLightAction();
		String[] commandArray = line.split("[ ,]");
		Point nwCorner = new Point(0, 0);
		Point seCorner = new Point(0, 0);

		if( commandArray.length == 7 && commandArray[0].equals("turn") && commandArray[4].equals("through") ) {
			if( commandArray[1].equals("on") ) {
				lightAction = new LightsOnAction();
			}
			if( commandArray[1].equals("off") ) {
				lightAction = new LightsOffAction();
			}
			nwCorner = new Point(new Integer(commandArray[2]).intValue(), new Integer(commandArray[3]).intValue());
			seCorner = new Point(new Integer(commandArray[5]).intValue(), new Integer(commandArray[6]).intValue());
		}
		if( commandArray.length == 6 && commandArray[0].equals("toggle") && commandArray[3].equals("through") ) {
			lightAction = new ToggleLightsAction();
			nwCorner = new Point(new Integer(commandArray[1]).intValue(), new Integer(commandArray[2]).intValue());
			seCorner = new Point(new Integer(commandArray[4]).intValue(), new Integer(commandArray[5]).intValue());
		}

		lightAction.setNWCorner(nwCorner);
		lightAction.setSECorner(seCorner);
		return lightAction;
	}

	public LightAction parseLineOldElvish(String line) {
		LightAction lightAction = new NullLightAction();
		String[] commandArray = line.split("[ ,]");
		Point nwCorner = new Point(0, 0);
		Point seCorner = new Point(0, 0);

		if( commandArray.length == 7 && commandArray[0].equals("turn") && commandArray[4].equals("through") ) {
			if( commandArray[1].equals("on") ) {
				lightAction = new LightsUpAction();
			}
			if( commandArray[1].equals("off") ) {
				lightAction = new LightsDownAction();
			}
			nwCorner = new Point(new Integer(commandArray[2]).intValue(), new Integer(commandArray[3]).intValue());
			seCorner = new Point(new Integer(commandArray[5]).intValue(), new Integer(commandArray[6]).intValue());
		}
		if( commandArray.length == 6 && commandArray[0].equals("toggle") && commandArray[3].equals("through") ) {
			lightAction = new LightsWayUpAction();
			nwCorner = new Point(new Integer(commandArray[1]).intValue(), new Integer(commandArray[2]).intValue());
			seCorner = new Point(new Integer(commandArray[4]).intValue(), new Integer(commandArray[5]).intValue());
		}

		lightAction.setNWCorner(nwCorner);
		lightAction.setSECorner(seCorner);
		return lightAction;
	}

}
