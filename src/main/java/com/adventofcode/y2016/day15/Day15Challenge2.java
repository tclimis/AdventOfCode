package com.adventofcode.y2016.day15;

public class Day15Challenge2 extends Day15Challenge1 {
	
	@Override
	protected int[] getStart() {
		int[] start = new int[super.getStart().length + 1];
		System.arraycopy(super.getStart(), 0, start, 0, super.getStart().length);
		start[start.length - 1] = 0;
		return start;
	}
	
	@Override
	protected Integer[] getSizes() {
		Integer[] sizes = new Integer[super.getSizes().length + 1];
		System.arraycopy(super.getSizes(), 0, sizes, 0, super.getSizes().length);
		sizes[sizes.length - 1] = 11;
		return sizes;
	}

}
