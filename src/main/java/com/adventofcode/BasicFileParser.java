package com.adventofcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class BasicFileParser implements FileParser {

	private File file;

	public BasicFileParser(File file) {
		this.file = file;
	}

	public File getFile() {
		return file;
	}

	public Collection<String> getFileLines() {
		try {
			FileReader fileReader = new FileReader(getFile());
			return readFile(fileReader);
		}
		catch( IOException e ) {
			return new ArrayList<>();
		}
	}

	private Collection<String> readFile(FileReader fileReader) {
		try( BufferedReader bufferedReader = new BufferedReader(fileReader) ) {
			return bufferedReader.lines().toList();
		}
		catch( IOException e ) {
			return new ArrayList<>();
		}
	}
	
}
