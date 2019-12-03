package com.adventofcode.y2015.day6;

import java.awt.Point;

import com.adventofcode.y2015.day6.lightActions.LightAction;
import com.adventofcode.y2015.day6.lightActions.LightsDownAction;
import com.adventofcode.y2015.day6.lightActions.LightsOffAction;
import com.adventofcode.y2015.day6.lightActions.LightsOnAction;
import com.adventofcode.y2015.day6.lightActions.LightsUpAction;
import com.adventofcode.y2015.day6.lightActions.LightsWayUpAction;
import com.adventofcode.y2015.day6.lightActions.NullLightAction;
import com.adventofcode.y2015.day6.lightActions.ToggleLightsAction;

public class LineParser {

	public static LightAction parseLine(String line) {
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
			nwCorner = new Point(Integer.valueOf(commandArray[2]).intValue(), Integer.valueOf(commandArray[3]).intValue());
			seCorner = new Point(Integer.valueOf(commandArray[5]).intValue(), Integer.valueOf(commandArray[6]).intValue());
		}
		if( commandArray.length == 6 && commandArray[0].equals("toggle") && commandArray[3].equals("through") ) {
			lightAction = new ToggleLightsAction();
			nwCorner = new Point(Integer.valueOf(commandArray[1]).intValue(), Integer.valueOf(commandArray[2]).intValue());
			seCorner = new Point(Integer.valueOf(commandArray[4]).intValue(), Integer.valueOf(commandArray[5]).intValue());
		}

		lightAction.setNWCorner(nwCorner);
		lightAction.setSECorner(seCorner);
		return lightAction;
	}

	public static LightAction parseLineOldElvish(String line) {
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
			nwCorner = new Point(Integer.valueOf(commandArray[2]).intValue(), Integer.valueOf(commandArray[3]).intValue());
			seCorner = new Point(Integer.valueOf(commandArray[5]).intValue(), Integer.valueOf(commandArray[6]).intValue());
		}
		if( commandArray.length == 6 && commandArray[0].equals("toggle") && commandArray[3].equals("through") ) {
			lightAction = new LightsWayUpAction();
			nwCorner = new Point(Integer.valueOf(commandArray[1]).intValue(), Integer.valueOf(commandArray[2]).intValue());
			seCorner = new Point(Integer.valueOf(commandArray[4]).intValue(), Integer.valueOf(commandArray[5]).intValue());
		}

		lightAction.setNWCorner(nwCorner);
		lightAction.setSECorner(seCorner);
		return lightAction;
	}

}
