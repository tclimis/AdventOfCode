package com.adventofcode.y2016.day13;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.adventofcode.AbstractChallenge;

public class Day13Challenge1 extends AbstractChallenge {

	protected static final int INPUT = 1350;
	
	@Override
	public void initialize() {	
		// there's nothing to intialize for this challenge
	}
	
	@Override
	public void processLine(String input) {	
		// no inputs to process		
	}
	
	public String getOutput() {
		double pathLength = findShortestPath();
		return Double.toString(pathLength);
	}

	private double findShortestPath() {
		List<Node> nodesToVisit = new ArrayList<>();
		Map<Point, Node> graph = new HashMap<>();

		Node root = new Node(getStart(), INPUT);
		root.setDistance(0);
		nodesToVisit.add(root);
		graph.put(getStart(), root);

		while( !nodesToVisit.isEmpty() ) {
			Node current = nodesToVisit.remove(0);
			for( Point node : current.getAdjacencyList() ) {
				Node adjacentNode = graph.containsKey(node) ? graph.get(node) : new Node(node, INPUT);
				if( Double.isInfinite(adjacentNode.getDistance()) ) {
					adjacentNode.setDistance(current.getDistance() + 1);
					graph.put(node, adjacentNode);
					if( adjacentNode.getLabel().equals(getEnd()) ) {
						return adjacentNode.getDistance();
					}
					if( !nodesToVisit.contains(adjacentNode) ) {
						nodesToVisit.add(adjacentNode);
					}
				}
			}
		}
		return Double.POSITIVE_INFINITY;
	}

	protected Point getStart() {
		return new Point(1, 1);
	}

	private Point getEnd() {
		return new Point(31, 39);
	}

}
