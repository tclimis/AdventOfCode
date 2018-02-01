package com.adventofcode.y2015.day9;

import java.util.Collection;

import org.apache.commons.collections4.iterators.PermutationIterator;

import com.adventofcode.y2015.AbstractChallenge;

public class Day9Challenge1 extends AbstractChallenge {

	@Override
	public String execute(String inputFile) {
		Day9FileParser fileParser = new Day9FileParser(getYear(), getDay(), inputFile);
		int[][] adjacencyMatrix = fileParser.createAdjacencyMatrix();
		Collection<Integer> cityIndices = fileParser.getCityIndexCollection();

		int shortestPathLength = findShortestPath(new PermutationIterator<Integer>(cityIndices), adjacencyMatrix);

		return new Integer(shortestPathLength).toString();
	}

	private int findShortestPath(PermutationIterator<Integer> cityPermutations, int[][] adjacencyMatrix) {
		int shortestPath = -1;
		while( cityPermutations.hasNext() ) {
			int sum = 0;
			Integer[] permutation = cityPermutations.next().toArray(new Integer[0]);
			for( int i = 1; i < permutation.length; i++ ) {
				sum += adjacencyMatrix[permutation[i - 1].intValue()][permutation[i].intValue()];
			}
			if( sum < shortestPath || shortestPath < 0 ) {
				shortestPath = sum;
			}
		}

		return shortestPath;
	}
}
