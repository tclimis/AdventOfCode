package com.adventofcode.y2016.day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.adventofcode.AbstractChallenge;

public class Day11Challenge1 extends AbstractChallenge {

	private Map<Integer, Node> graph;

	// initial state
	//                               C1c1P0p0R1r1S0s0T1t2E0
	private static final Integer START = 0b0101000001010000011000;
	private static final Integer END =   0b1111111111111111111111;
	
	public void initialize() {
		buildGraph();
	}
	
	private void buildGraph() {
		this.graph = new HashMap<>();
		for( int i = 0; i <= getEnd(); i++ ) {
			Node node = new Node(i);
			if( node.isValid() ) {
				this.graph.putIfAbsent(node.getLabel(), node);
			}
		}
	}

	@Override
	// This should read the file, and set the start state
	public void processLine(String input) {
		// this challenage was too hard to be worth parsing programatically.  
		// Instead manually parse into the bit strings below
	}


	protected Integer getStart() {
		return START;
	}

	protected Integer getEnd() {
		return END;
	}

	// Dijkstra's Algorithm
	private double findShortestPath() {
		List<Node> nodesToVisit = new ArrayList<>();

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
	
	public String getOutput() {
		double pathLength = findShortestPath();
		return String.valueOf(pathLength);
	}

}
