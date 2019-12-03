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
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			Collection<String> lines = new ArrayList<String>();
			String line = new String();

			while( (line = bufferedReader.readLine()) != null ) {
				lines.add(line);
			}

			bufferedReader.close();

			return lines;
		}
		catch( IOException e ) {
			return new ArrayList<String>();
		}
	}
	
}
