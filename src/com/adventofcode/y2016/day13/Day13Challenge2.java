package com.adventofcode.y2016.day13;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day13Challenge2 extends Day13Challenge1 {

	@Override
	public String execute(String inputFile) {
		int size = findSizeOfGraph();
		return Integer.toString(size);
	}

	private int findSizeOfGraph() {
		List<Node> nodesToVisit = new ArrayList<Node>();
		Map<Point, Node> graph = new HashMap<Point, Node>();

		Node root = new Node(getStart(), getInput());
		root.setDistance(0);
		nodesToVisit.add(root);
		graph.put(getStart(), root);

		while( !nodesToVisit.isEmpty() ) {
			Node current = nodesToVisit.remove(0);
			for( Point node : current.getAdjacencyList() ) {
				Node adjacentNode = graph.containsKey(node) ? graph.get(node) : new Node(node, getInput());
				if( Double.isInfinite(adjacentNode.getDistance()) ) {
					adjacentNode.setDistance(current.getDistance() + 1);
					graph.put(node, adjacentNode);
					if( !nodesToVisit.contains(adjacentNode) && adjacentNode.getDistance() < 50 ) {
						nodesToVisit.add(adjacentNode);
					}
				}
			}
		}
		return graph.size();
	}

}
