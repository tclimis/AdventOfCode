package com.adventofcode.y2016.day3;

import java.util.Arrays;

import com.adventofcode.AbstractChallenge;

public class Day3Challenge1 extends AbstractChallenge {
	
	protected int counter;

	public void initialize() {
		counter = 0;
	}
	
	public void processLine(String input) {
		String[] numbers = input.trim().split("\\s+");
		int[] dimensions = convertArray(numbers);
		if( isTriangle(dimensions) ) {
			counter++;
		}
	}

	protected int[] convertArray(String[] numbers) {
		int[] dimensions = new int[3];
		for( int i = 0; i < 3; i++ ) {
			dimensions[i] = Integer.parseInt(numbers[i]);
		}
		return dimensions;
	}

	protected boolean isTriangle(int[] dimensions) {
		Arrays.sort(dimensions);
		return dimensions[0] + dimensions[1] > dimensions[2];
	}
	
	public String getOutput() {
		return String.valueOf(counter);
	}

}
