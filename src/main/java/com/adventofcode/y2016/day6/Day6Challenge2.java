package com.adventofcode.y2016.day6;

import java.util.Arrays;
import java.util.Map;

public class Day6Challenge2 extends Day6Challenge1 {

	@Override
	public String getOutput() {
		StringBuilder output = new StringBuilder();
		for( Map<Character, Integer> position : getLetterCountMapList() ) {
			output.append(getLeastCommonLetter(position));
		}

		return output.toString();
	}

	private String getLeastCommonLetter(Map<Character, Integer> position) {
		Integer[] valueArray = position.values().toArray(new Integer[position.size()]);
		Arrays.sort(valueArray);
		return getKeyByValue(position, valueArray[0]);
	}

}
