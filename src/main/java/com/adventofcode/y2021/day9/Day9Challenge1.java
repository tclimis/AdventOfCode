package com.adventofcode.y2021.day9;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import com.adventofcode.AbstractChallenge;

public class Day9Challenge1 extends AbstractChallenge {

	Map<Point, Integer> map;
	int lineCounter;

	@Override
	public void initialize() {
		this.map = new HashMap<>();
		this.lineCounter = 0;
	}

	@Override
	public void processLine(String input) {
		for( int i = 0; i < input.length(); i++ ) {
			this.map.put(new Point(i, this.lineCounter), Character.digit(input.charAt(i), 10));
		}
		this.lineCounter++;
	}

	@Override
	public String getOutput() {
		return String.valueOf(getMins().mapToInt(p -> this.map.get(p) + 1).sum());
	}

	public Stream<Point> getMins() {
		return map.keySet().stream().filter(this::isLowest);
	}

	private boolean isLowest(Point p) {
		int baseHeight = this.map.get(p);

		Point top = new Point(p.x, p.y - 1);
		Point bottom = new Point(p.x, p.y + 1);
		Point left = new Point(p.x - 1, p.y);
		Point right = new Point(p.x + 1, p.y);

		return ( !this.map.containsKey(top) || this.map.get(top) > baseHeight )
				&& ( !this.map.containsKey(bottom) || this.map.get(bottom) > baseHeight )
				&& ( !this.map.containsKey(left) || this.map.get(left) > baseHeight )
				&& ( !this.map.containsKey(right) || this.map.get(right) > baseHeight );
	}

}
