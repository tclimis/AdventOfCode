package com.adventofcode.y2016.day15;

import java.util.Arrays;
import java.util.Collections;

import com.adventofcode.AbstractChallenge;

public class Day15Challenge1 extends AbstractChallenge {

	private int time;
	
	public void initialize() { 
		this.time = 0;
	}
	
	public void processLine(String input) { 
		// no lines
	}
	
	public String getOutput() {
		int[] end = new int[getSizes().length];
		for( int i = 0; i < getSizes().length; i++ ) {
			end[i] = Math.floorMod(getSizes()[i] - i - 1, getSizes()[i]);
		}

		Integer maxSize = Collections.max(Arrays.asList(getSizes()));
		int maxPosition = Arrays.asList(getSizes()).indexOf(maxSize);
		this.time = this.time + Math.floorMod(end[maxPosition] - getStart()[maxPosition], maxSize);
		int[] state = new int[getSizes().length];
		for( int i = 0; i < getSizes().length; i++ ) {
			state[i] = Math.floorMod(getStart()[i] + this.time, getSizes()[i]);
		}

		while( !Arrays.equals(state, end) ) {
			this.time += maxSize;
			for( int i = 0; i < getSizes().length; i++ ) {
				state[i] = Math.floorMod(getStart()[i] + this.time, getSizes()[i]);
			}
		}
		return Integer.toString(this.time);
	}

	protected int[] getStart() {
		return new int[] { 11, 0, 11, 0, 2, 17 };
	}

	protected Integer[] getSizes() {
		return new Integer[] { 13, 5, 17, 3, 7, 19 };
	}
}
