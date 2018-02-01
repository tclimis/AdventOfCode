package com.adventofcode.y2015.day12;

import com.adventofcode.BasicFileParser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Day12FileParser extends BasicFileParser {

	public Day12FileParser(int year, int day, String fileName) {
		super(year, day, fileName);
	}

	public Object getJSONTree() {
		ObjectMapper mapper = new ObjectMapper();
		return mapper;
	}

}
