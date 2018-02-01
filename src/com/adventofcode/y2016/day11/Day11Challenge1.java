package com.adventofcode.y2016.day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.adventofcode.y2016.AbstractChallenge;

public class Day11Challenge1 extends AbstractChallenge {

	private Map<Integer, Node> graph;

	@Override
	public String execute(String inputFile) {
		buildGraph();

		double pathLength = findShortestPath();
		return Double.toString(pathLength);
	}

	private void buildGraph() {
		this.graph = new HashMap<Integer, Node>();
		for( int i = 0; i <= getEnd(); i++ ) {
			Node node = new Node(i);
			if( node.isValid() ) {
				this.graph.putIfAbsent(node.getLabel(), node);
			}
		}
	}

	protected Integer getStart() {
		return 0b0101000001010000011000;
	}

	protected Integer getEnd() {
		return 0b1111111111111111111111;
	}

	private double findShortestPath() {
		List<Node> nodesToVisit = new ArrayList<Node>();

		Node root = this.graph.get(new Node(getStart()).getLabel());
		root.setDistance(0);
		nodesToVisit.add(root);

		Integer end = new Node(getEnd()).getLabel();

		while( !nodesToVisit.isEmpty() ) {
			Node current = nodesToVisit.remove(0);
			for( Integer node : current.getAdjacencyList() ) {
				if( this.graph.containsKey(node) && Double.isInfinite(this.graph.get(node).getDistance()) ) {
					Node adjacentNode = this.graph.get(node);
					adjacentNode.setDistance(current.getDistance() + 1);
					if( adjacentNode.getLabel().equals(end) ) {
						return adjacentNode.getDistance();
					}
					if( !nodesToVisit.contains(adjacentNode) ) {
						nodesToVisit.add(adjacentNode);
					}
				}
			}
		}
		return this.graph.get(end).getDistance();
	}
}
