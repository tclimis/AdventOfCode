package com.adventofcode.y2021.day9;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Day9Challenge2 extends Day9Challenge1 {

	@Override
	public String getOutput() {
		long[] basinSizes = findBasins().mapToLong(basin -> basin.distinct().count()).sorted().toArray();
		if( basinSizes.length >= 3 ) {
			long product = LongStream.of(
					basinSizes[basinSizes.length - 1], basinSizes[basinSizes.length - 2],
					basinSizes[basinSizes.length - 3]
			).reduce((a, b) -> a * b).orElse(0);
			return String.valueOf(product);
		}
		return String.valueOf(0);
	}

	public Stream<Stream<Point>> findBasins() {
		return getMins().map(p -> findBasinMembers(new ArrayList<>(), p)).map(List::stream);
	}

	private List<Point> findBasinMembers(List<Point> basin, Point p) {
		if( this.map.containsKey(p) && this.map.get(p) != 9 && !basin.contains(p)) {
			basin.add(p);

			Point top = new Point(p.x, p.y - 1);
			Point bottom = new Point(p.x, p.y + 1);
			Point left = new Point(p.x - 1, p.y);
			Point right = new Point(p.x + 1, p.y);

			findBasinMembers(basin, top);
			findBasinMembers(basin, bottom);
			findBasinMembers(basin, left);
			findBasinMembers(basin, right);
		}

		return basin;
	}

}
