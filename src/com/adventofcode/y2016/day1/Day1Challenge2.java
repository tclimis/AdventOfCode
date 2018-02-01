package com.adventofcode.y2016.day1;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.adventofcode.BasicFileParser;
import com.adventofcode.FileParser;

public class Day1Challenge2 extends Day1Challenge1 {

	private List<Point> placesVisited;

	@Override
	public String execute(String inputFile) {
		FileParser fileParser = new BasicFileParser(getYear(), getDay(), inputFile);
		Point origin = new Point(0, 0);
		setHeading(NORTH);
		setLocation(origin);
		setPlacesVisited(new ArrayList<Point>());
		for( String line : fileParser.getFileLines() ) {
			doStuff(line);
		}
		return Integer.toString(getTaxiCabDistance());
	}

	private void setPlacesVisited(List<Point> placesVisited) {
		this.placesVisited = placesVisited;
	}

	@Override
	protected void doStuff(String line) {
		recordPoint();
		for( String instruction : getInstructions(line) ) {
			changeDirection(getDirection(instruction));
			for( int i = 0; i < getDistance(instruction); i++ ) {
				move(1);
				if( beenHereBefore() ) {
					return;
				}
				recordPoint();
			}
		}
	}

	private boolean beenHereBefore() {
		return getPlacesVisited().contains(getLocation());
	}

	private List<Point> getPlacesVisited() {
		return placesVisited;
	}

	private void recordPoint() {
		Point place = new Point();
		place.setLocation(getLocation());
		getPlacesVisited().add(place);
	}

}
