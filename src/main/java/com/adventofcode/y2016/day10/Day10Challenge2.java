package com.adventofcode.y2016.day10;

import java.util.Iterator;

public class Day10Challenge2 extends Day10Challenge1 {
	
	public String getOutput() {
		Iterator<Robot> robots = getRobots().values().iterator();
		boolean robotsAreEmpty = true;
		while( robots.hasNext() ) {
			Robot robot = robots.next();
			if( robot.areHandsFull() ) {
				robotsAreEmpty = false;
				robot.giveHandContents();
				if( endingOutboxesExist() && outboxesContainValues() ) {
					return String.valueOf(getOutboxProduct());
				}
			}
			if( !robots.hasNext() ) {
				if( robotsAreEmpty ) {
					return "";
				}
				robots = getRobots().values().iterator();
				robotsAreEmpty = true;
			}
		}

		return "";
	}

	private boolean endingOutboxesExist() {
		return getOutputs().containsKey(0) && getOutputs().containsKey(1) && getOutputs().containsKey(2);
	}

	private boolean outboxesContainValues() {
		return getOutputs().get(0).getContents().size() > 0 && getOutputs().get(1).getContents().size() > 0
				&& getOutputs().get(2).getContents().size() > 0;
	}

	private int getOutboxProduct() {
		return getOutputs().get(0).getContents().get(0) * getOutputs().get(1).getContents().get(0)
				* getOutputs().get(2).getContents().get(0);
	}

}
