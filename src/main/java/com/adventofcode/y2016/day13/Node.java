package com.adventofcode.y2016.day13;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Node {

	private Point label;
	private int input;
	private Double distanceToRoot;

	public Node(Point label, int input) {
		this.label = label;
		this.input = input;
		this.distanceToRoot = Double.POSITIVE_INFINITY;
	}

	public Point getLabel() {
		return this.label;
	}

	public List<Point> getAdjacencyList() {
		List<Point> adjacencyList = new ArrayList<>();
		for( Point possibleNode : listAdjacentCombinations() ) {
			Node node = new Node(possibleNode, this.input);
			if( node.isValid() ) {
				adjacencyList.add(node.getLabel());
			}
		}
		return adjacencyList;
	}

	private List<Point> listAdjacentCombinations() {
		List<Point> list = new ArrayList<>();
		list.add(new Point(getLabel().x + 1, getLabel().y));
		list.add(new Point(getLabel().x - 1, getLabel().y));
		list.add(new Point(getLabel().x, getLabel().y + 1));
		list.add(new Point(getLabel().x, getLabel().y - 1));
		return list;
	}

	public double getDistance() {
		return this.distanceToRoot;
	}

	public void setDistance(double distance) {
		if( Double.isInfinite(this.distanceToRoot) ) {
			this.distanceToRoot = distance;
		}
	}

	public boolean isValid() {
		if( getLabel().x < 0 || getLabel().y < 0 ) {
			return false;
		}

		int x = getLabel().x;
		int y = getLabel().y;
		int value = x * x + 3 * x + 2 * x * y + y + y * y;
		value += this.input;
		return countChar(Integer.toBinaryString(value), '1') % 2 == 0;
	}

	private int countChar(String haystack, char needle) {
		int first = haystack.indexOf(Character.toString(needle));
		if( first < 0 ) {
			return 0;
		}

		int last = haystack.lastIndexOf(Character.toString(needle));
		if( first == last ) {
			return 1;
		}

		int count = 0;
		for( char character : haystack.substring(first, last + 1).toCharArray() ) {
			if( character == needle ) {
				count++;
			}
		}
		return count;
	}

}
