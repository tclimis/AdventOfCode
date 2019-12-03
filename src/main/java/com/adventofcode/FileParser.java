package com.adventofcode;

import java.io.File;
import java.util.Collection;

public interface FileParser {	
	
	public File getFile();
	
	public Collection<String> getFileLines();
}
