package com.adventofcode.y2016.day3;

import java.util.Arrays;

import com.adventofcode.BasicFileParser;
import com.adventofcode.FileParser;
import com.adventofcode.y2016.AbstractChallenge;

public class Day3Challenge1 extends AbstractChallenge {

	@Override
	public String execute(String inputFile) {
		int counter = 0;

		FileParser parser = new BasicFileParser(getYear(), getDay(), inputFile);
		for( String line : parser.getFileLines() ) {
			String[] numbers = line.trim().split("\\s+");
			int[] dimensions = convertArray(numbers);
			if( isTriangle(dimensions) ) {
				counter++;
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
