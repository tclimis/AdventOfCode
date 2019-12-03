package com.adventofcode.y2016.day4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.adventofcode.AbstractChallenge;

public class Day4Challenge1 extends AbstractChallenge {
	
	private int sum;

	public void initialize() {
		sum = 0;
	}
	
	public void processLine(String input) {
		if( isRealRoom(input) ) {
			sum += getSector(input);
		}
	}

	protected boolean isRealRoom(String roomEncoded) {
		String nameChecksum = getFiveMostCommonLetters(getEncryptedName(roomEncoded));
		return nameChecksum.equals(getChecksum(roomEncoded));
	}

	protected String getEncryptedName(String roomEncoded) {
		return roomEncoded.substring(0, getIndexOfRegEx(roomEncoded, "\\d"));
	}

	private int getIndexOfRegEx(String str, String pattern) {
		Pattern regEx = Pattern.compile(pattern);
		Matcher matcher = regEx.matcher(str);
		return matcher.find() ? matcher.start() : -1;
	}

	private String getFiveMostCommonLetters(String string) {
		Map<Character, Integer> letterCountMap = countLetters(string);
		Integer[] valueArray = letterCountMap.values().toArray(new Integer[letterCountMap.size()]);
		Arrays.sort(valueArray);
		String mostCommon = "";
		// loop backwards to get the highest 5
		for( int i = valueArray.length - 1; i >= valueArray.length - 5; i-- ) {
			mostCommon += getKeyByValue(letterCountMap, valueArray[i]);
		}
		return mostCommon;
	}

	private Map<Character, Integer> countLetters(String string) {
		Map<Character, Integer> letterCountMap = new HashMap<Character, Integer>();
		for( int i = 0; i < string.length(); i++ ) {
			if( string.charAt(i) == '-' ) {}
			else if( letterCountMap.containsKey(string.charAt(i)) ) {
				letterCountMap.put(string.charAt(i), letterCountMap.get(string.charAt(i)) + 1);
			}
			else {
				letterCountMap.put(string.charAt(i), 1);
			}
		}
		return letterCountMap;
	}

	private String getKeyByValue(Map<Character, Integer> map, Integer value) {
		for( char i = 'a'; i <= 'z'; i++ ) {
			if( map.containsKey(i) && map.get(i).equals(value) ) {
				map.remove(i);
				return Character.toString(i);
			}
		}
		return "";
	}

	private String getChecksum(String roomEncoded) {
		return roomEncoded.substring(roomEncoded.indexOf("[") + 1, roomEncoded.lastIndexOf("]"));
	}

	protected int getSector(String roomEncoded) {
		String sector = roomEncoded.replaceAll("[^\\d]*", "");
		if( !sector.isEmpty() ) {
			return Integer.parseInt(sector);
		}
		return 0;
	}
	
	public String getOutput() {
		return String.valueOf(sum);
	}

}
