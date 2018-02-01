package com.adventofcode.y2016.day6;

import java.util.Arrays;
import java.util.Map;

import com.adventofcode.BasicFileParser;
import com.adventofcode.FileParser;

public class Day6Challenge2 extends Day6Challenge1 {

	@Override
	public String execute(String inputFile) {
		String output = "";
		FileParser parser = new BasicFileParser(getYear(), getDay(), inputFile);
		for( String line : parser.getFileLines() ) {
			if( getLetterCountMapList().size() == 0 ) {
				initializeLetterCountMaps(line.length());
			}
			tallyLetters(line);
		}
		for( Map<Character, Integer> position : getLetterCountMapList() ) {
			output += getLeastCommonLetter(position);
		}

		return output;
	}

	private String getLeastCommonLetter(Map<Character, Integer> position) {
		Integer[] valueArray = position.values().toArray(new Integer[position.size()]);
		Arrays.sort(valueArray);
		return getKeyByValue(position, valueArray[0]);
	}

}
