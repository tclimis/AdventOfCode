package com.adventofcode.y2016.day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.adventofcode.AbstractChallenge;

public class Day6Challenge1 extends AbstractChallenge {

	private List<Map<Character, Integer>> letterCountMapList;

	public void initialize() {
		letterCountMapList = new ArrayList<Map<Character, Integer>>();
	}
	
	public void processLine(String input) {
		if( getLetterCountMapList().size() == 0 ) {
			initializeLetterCountMaps(input.length());
		}
		tallyLetters(input);
	}

	protected List<Map<Character, Integer>> getLetterCountMapList() {
		return letterCountMapList;
	}

	private void initializeLetterCountMaps(int lineLength) {
		for( int i = 0; i < lineLength; i++ ) {
			getLetterCountMapList().add(new HashMap<Character, Integer>());
		}
	}

	private void tallyLetters(String string) {
		for( int i = 0; i < string.length(); i++ ) {
			if( getMap(i).containsKey(string.charAt(i)) ) {
				getMap(i).put(string.charAt(i), getMap(i).get(string.charAt(i)) + 1);
			}
			else {
				getMap(i).put(string.charAt(i), 1);
			}
		}
	}

	private Map<Character, Integer> getMap(int position) {
		return getLetterCountMapList().get(position);
	}
	
	public String getOutput() {
		String output = "";
		for( Map<Character, Integer> position : getLetterCountMapList() ) {
			output += getMostCommonLetter(position);
		}

		return output;
	}

	private String getMostCommonLetter(Map<Character, Integer> position) {
		Integer[] valueArray = position.values().toArray(new Integer[position.size()]);
		Arrays.sort(valueArray);
		return getKeyByValue(position, valueArray[valueArray.length - 1]);
	}

	protected String getKeyByValue(Map<Character, Integer> map, Integer value) {
		for( char i = 'a'; i <= 'z'; i++ ) {
			if( map.containsKey(i) && map.get(i).equals(value) ) {
				map.remove(i);
				return Character.toString(i);
			}
		}
		return "";
	}
}
