package com.adventofcode.y2015.day9;

import java.awt.Point;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.iterators.PermutationIterator;

import com.adventofcode.AbstractChallenge;

public class Day9Challenge1 extends AbstractChallenge {
	
	private Map<String, Integer> vertexMap;
	protected Map<Point, Integer> adjacencyMatrix;

	public void initialize() {
		vertexMap = new HashMap<>();
		adjacencyMatrix = new HashMap<>();
	}
	
	public void processLine(String input) {
		String[] values = input.split(" ");
		if( isValidValues(values) ) {
			addCity(values[0]);
			addCity(values[2]);
			setDistance(values);
		}
	}
	
	private boolean isValidValues(String[] values) {
		boolean isValid = values.length == 5 && values[1].equals("to") && values[3].equals("=");
		if( isValid ) {
			try {
				Integer.valueOf(values[4]);
			}
			catch( NumberFormatException e ) {
				return false;
			}
		}
		return isValid;
	}

	private void addCity(String city) {
		vertexMap.putIfAbsent(city, Integer.valueOf(vertexMap.size()));
	}
	
	private void setDistance(String[] values) {
		Integer city1 = getCityIndex(values[0]);
		Integer city2 = getCityIndex(values[2]);
		
		Point city1ToCity2 = new Point(city1, city2);
		Point city2ToCity1 = new Point(city2, city1);
		Integer distance = Integer.valueOf(values[4]);
		
		adjacencyMatrix.put(city1ToCity2, distance);
		adjacencyMatrix.put(city2ToCity1, distance);
	}
	
	private int getCityIndex(String city) {
		return getCityMapping().get(city).intValue();
	}
	
	private Map<String, Integer> getCityMapping() {
		return vertexMap;
	}

	public String getOutput() {
		Collection<Integer> cityIndices = getCityIndexCollection();
		PermutationIterator<Integer> cityPermuations = new PermutationIterator<>(cityIndices);
		
		int shortestPathLength = findShortestPath(cityPermuations, adjacencyMatrix);
		
		return String.valueOf(shortestPathLength);
	}
	
	protected Collection<Integer> getCityIndexCollection() {
		return getCityMapping().values();
	}

	private int findShortestPath(PermutationIterator<Integer> cityPermutations, Map<Point, Integer> adjacencyMatrix) {
		int shortestPath = -1;
		while( cityPermutations.hasNext() ) {
			int sum = 0;
			Integer[] permutation = cityPermutations.next().toArray(new Integer[0]);
			for( int i = 1; i < permutation.length; i++ ) {
				Point cityCombination = new Point(permutation[i-1], permutation[i]);
				sum += adjacencyMatrix.get(cityCombination);
			}
			if( sum < shortestPath || shortestPath < 0 ) {
				shortestPath = sum;
			}
		}

		return shortestPath;
	}
}
