package com.adventofcode.y2015.day9;

import java.awt.Point;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.collections4.iterators.PermutationIterator;

public class Day9Challenge2 extends Day9Challenge1 {
	
	@Override
	public String getOutput() {
		Collection<Integer> cityIndices = getCityIndexCollection();
		PermutationIterator<Integer> cityPermuations = new PermutationIterator<>(cityIndices);
		
		int longestPathLength = findLongestPath(cityPermuations, adjacencyMatrix);

		return Integer.toString(longestPathLength);
	}

	private int findLongestPath(PermutationIterator<Integer> cityPermutations, Map<Point,Integer> adjacencyMatrix) {
		int longestPath = 0;
		while( cityPermutations.hasNext() ) {
			int sum = 0;
			Integer[] permutation = cityPermutations.next().toArray(new Integer[0]);
			for( int i = 1; i < permutation.length; i++ ) {
				Point cityCombination = new Point(permutation[i-1], permutation[i]);
				sum += adjacencyMatrix.get(cityCombination);
			}
			if( sum > longestPath ) {
				longestPath = sum;
			}
		}

		return longestPath;
	}
}
