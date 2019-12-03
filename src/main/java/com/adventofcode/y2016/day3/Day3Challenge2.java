package com.adventofcode.y2016.day3;

public class Day3Challenge2 extends Day3Challenge1 {
	
	private int[][] matrix;
	private int i;
	
	public void initialize() {
		super.initialize();
		matrix = new int[3][3];
		i = 0;
	}
	
	public void processLine(String input) {
		String[] numbers = input.trim().split("\\s+");
		matrix[i % 3] = convertArray(numbers);

		if( i % 3 == 2 ) {
			for( int j = 0; j < 3; j++ ) {
				int[] dimensions = new int[3];
				for( int k = 0; k < 3; k++ ) {
					dimensions[k] = matrix[k][j];
				}
				if( isTriangle(dimensions) ) {
					counter++;
				}
			}
		}
		i++;
	}

}
