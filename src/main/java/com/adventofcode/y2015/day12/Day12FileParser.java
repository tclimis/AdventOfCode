package com.adventofcode.y2015.day12;

import java.io.File;

import com.adventofcode.BasicFileParser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Day12FileParser extends BasicFileParser {

	public Day12FileParser(File file) {
		super(file);
	}

	public Object getJSONTree() {
		ObjectMapper mapper = new ObjectMapper();
		return mapper;
	}

}
