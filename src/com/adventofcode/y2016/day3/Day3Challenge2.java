package com.adventofcode.y2016.day3;

import java.util.Arrays;

import com.adventofcode.BasicFileParser;
import com.adventofcode.FileParser;
import com.adventofcode.y2016.AbstractChallenge;

public class Day3Challenge2 extends AbstractChallenge {

	@Override
	public String execute(String inputFile) {
		int counter = 0;
		int[][] matrix = new int[3][3];

		FileParser parser = new BasicFileParser(getYear(), getDay(), inputFile);
		String[] lines = parser.getFileLines().toArray(new String[0]);
		for( int i = 0; i < lines.length; i++ ) {
			String[] numbers = lines[i].trim().split("\\s+");
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
		}
		return String.valueOf(counter);
	}

	private int[] convertArray(String[] numbers) {
		int[] dimensions = new int[3];
		for( int i = 0; i < 3; i++ ) {
			dimensions[i] = Integer.parseInt(numbers[i]);
		}
		return dimensions;
	}

	private boolean isTriangle(int[] dimensions) {
		Arrays.sort(dimensions);
		return dimensions[0] + dimensions[1] > dimensions[2];
	}

}
