package com.adventofcode.y2016.day1;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Day1Challenge2 extends Day1Challenge1 {

	private List<Point> placesVisited;
	
	public void initialize() {
		super.initialize();
		setPlacesVisited(new ArrayList<Point>());
		recordPoint();
	}
	
	private void recordPoint() {
		Point place = new Point();
		place.setLocation(getLocation());
		getPlacesVisited().add(place);
	}
	
	private List<Point> getPlacesVisited() {
		return placesVisited;
	}

	private void setPlacesVisited(List<Point> placesVisited) {
		this.placesVisited = placesVisited;
	}

	public void processLine(String input) {
		for( String instruction : getInstructions(input) ) {
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





}
