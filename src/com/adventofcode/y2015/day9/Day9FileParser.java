package com.adventofcode.y2015.day9;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.adventofcode.BasicFileParser;

public class Day9FileParser extends BasicFileParser {

	private Map<String, Integer> vertexMap;

	public Day9FileParser(int year, int day, String fileName) {
		super(year, day, fileName);
		vertexMap = new HashMap<String, Integer>();
	}

	public int[][] createAdjacencyMatrix() {
		populateVertexMap();

		int[][] adjacencyMatrix = new int[getCityMapping().size()][getCityMapping().size()];
		populateAdjacencyMatrix(adjacencyMatrix);

		return adjacencyMatrix;
	}

	private void populateVertexMap() {
		for( String line : getFileLines() ) {
			String[] values = line.split(" ");
			if( isValidValues(values) ) {
				addCity(values[0]);
				addCity(values[2]);
			}
		}
	}

	private boolean isValidValues(String[] values) {
		boolean isValid = values.length == 5 && values[1].equals("to") && values[3].equals("=");
		if( isValid ) {
			try {
				new Integer(values[4]);
			}
			catch( NumberFormatException e ) {
				return false;
			}
		}
		return isValid;
	}

	private void addCity(String city) {
		vertexMap.putIfAbsent(city, vertexMap.size());
	}

	private Map<String, Integer> getCityMapping() {
		return vertexMap;
	}

	private void populateAdjacencyMatrix(int[][] adjacencyMatrix) {
		for( String line : getFileLines() ) {
			String[] values = line.split(" ");
			setDistance(adjacencyMatrix, values);
		}
	}

	private void setDistance(int[][] adjacencyMatrix, String[] values) {
		if( isValidValues(values) ) {
			adjacencyMatrix[getCityIndex(values[0])][getCityIndex(values[2])] = new Integer(values[4]).intValue();
			adjacencyMatrix[getCityIndex(values[2])][getCityIndex(values[0])] = new Integer(values[4]).intValue();
		}
	}

	private int getCityIndex(String city) {
		return getCityMapping().get(city).intValue();
	}

	public Collection<Integer> getCityIndexCollection() {
		populateVertexMap();
		return getCityMapping().values();
	}

}
