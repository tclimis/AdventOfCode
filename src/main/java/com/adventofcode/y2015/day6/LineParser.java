package com.adventofcode.y2015.day6;

import java.awt.Point;

import com.adventofcode.y2015.day6.light_actions.LightAction;
import com.adventofcode.y2015.day6.light_actions.LightsDownAction;
import com.adventofcode.y2015.day6.light_actions.LightsOffAction;
import com.adventofcode.y2015.day6.light_actions.LightsOnAction;
import com.adventofcode.y2015.day6.light_actions.LightsUpAction;
import com.adventofcode.y2015.day6.light_actions.LightsWayUpAction;
import com.adventofcode.y2015.day6.light_actions.NullLightAction;
import com.adventofcode.y2015.day6.light_actions.ToggleLightsAction;

public class LineParser {

	private static final String THROUGH = "through";

	private LineParser() {}

	public static LightAction parseLine(String line) {
		LightAction lightAction = new NullLightAction();
		String[] commandArray = line.split("[ ,]");
		Point nwCorner = new Point(0, 0);
		Point seCorner = new Point(0, 0);

		if( commandArray.length == 7 && commandArray[0].equals("turn") && commandArray[4].equals(THROUGH) ) {
			if( commandArray[1].equals("on") ) {
				lightAction = new LightsOnAction();
			}
			if( commandArray[1].equals("off") ) {
				lightAction = new LightsOffAction();
			}
			nwCorner = new Point(Integer.parseInt(commandArray[2]), Integer.parseInt(commandArray[3]));
			seCorner = new Point(Integer.parseInt(commandArray[5]), Integer.parseInt(commandArray[6]));
		}
		if( commandArray.length == 6 && commandArray[0].equals("toggle") && commandArray[3].equals(THROUGH) ) {
			lightAction = new ToggleLightsAction();
			nwCorner = new Point(Integer.parseInt(commandArray[1]), Integer.parseInt(commandArray[2]));
			seCorner = new Point(Integer.parseInt(commandArray[4]), Integer.parseInt(commandArray[5]));
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

		if( commandArray.length == 7 && commandArray[0].equals("turn") && commandArray[4].equals(THROUGH) ) {
			if( commandArray[1].equals("on") ) {
				lightAction = new LightsUpAction();
			}
			if( commandArray[1].equals("off") ) {
				lightAction = new LightsDownAction();
			}
			nwCorner = new Point(Integer.parseInt(commandArray[2]), Integer.parseInt(commandArray[3]));
			seCorner = new Point(Integer.parseInt(commandArray[5]), Integer.parseInt(commandArray[6]));
		}
		if( commandArray.length == 6 && commandArray[0].equals("toggle") && commandArray[3].equals(THROUGH) ) {
			lightAction = new LightsWayUpAction();
			nwCorner = new Point(Integer.parseInt(commandArray[1]), Integer.parseInt(commandArray[2]));
			seCorner = new Point(Integer.parseInt(commandArray[4]), Integer.parseInt(commandArray[5]));
		}

		lightAction.setNWCorner(nwCorner);
		lightAction.setSECorner(seCorner);
		return lightAction;
	}

}
