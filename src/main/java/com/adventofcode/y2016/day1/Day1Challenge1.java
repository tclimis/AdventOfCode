package com.adventofcode.y2016.day1;

import java.awt.Point;

import com.adventofcode.AbstractChallenge;

public class Day1Challenge1 extends AbstractChallenge {
	
	protected static final int NORTH = 0;
	private static final int EAST = 1;
	private static final int SOUTH = 2;
	private static final int WEST = 3;

	private int heading;
	private Point location;

	public void initialize() {
		setHeading(NORTH);
		Point origin = new Point(0, 0);
		setLocation(origin);
	}
	
	protected void setHeading(int heading) {
		this.heading = Math.floorMod(heading, 4);
	}

	protected void setLocation(Point location) {
		this.location = location;
	}
	
	public void processLine(String input) {
		for( String instruction : getInstructions(input) ) {
			changeDirection(getDirection(instruction));
			move(getDistance(instruction));
		}
	}

	protected String[] getInstructions(String line) {
		return line.split(", ");
	}

	protected String getDirection(String instruction) {
		return instruction.substring(0, 1);
	}

	protected void changeDirection(String direction) {
		switch( direction ) {
			case "L":
				setHeading(getHeading() - 1);
				return;
			case "R":
				setHeading(getHeading() + 1);
				return;
			default:
				return;
		}
	}

	private int getHeading() {
		return heading;
	}

	protected int getDistance(String instruction) {
		try {
			return Integer.parseInt(instruction.substring(1));
		}
		catch( NumberFormatException e ) {
			return 0;
		}
	}

	protected void move(int distance) {
		switch( getHeading() ) {
			case NORTH:
				getLocation().translate(0, distance);
				return;
			case EAST:
				getLocation().translate(distance, 0);
				return;
			case SOUTH:
				getLocation().translate(0, distance * -1);
				return;
			case WEST:
				getLocation().translate(distance * -1, 0);
				return;
			default:
				return;
		}
	}

	protected Point getLocation() {
		return location;
	}
	
	public String getOutput() {
		return String.valueOf(getTaxiCabDistance());
	}

	protected int getTaxiCabDistance() {
		return Math.abs(getLocation().x) + Math.abs(getLocation().y);
	}

}
