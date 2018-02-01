package com.adventofcode;

import java.util.Collection;

public interface FileParser {	
	
	public String getFileName();
	
	public Collection<String> getFileLines();
}
