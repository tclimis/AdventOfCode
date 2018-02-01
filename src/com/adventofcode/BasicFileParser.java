package com.adventofcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class BasicFileParser implements FileParser {

	private int year;
	private int day;
	private String fileName;

	public BasicFileParser(int year, int day, String fileName) {
		this.year = year;
		this.day = day;
		this.fileName = fileName;
	}

	@Override
	public String getFileName() {
		return fileName;
	}

	@Override
	public Collection<String> getFileLines() {
		try {
			FileReader fileReader = new FileReader(getPath());
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

	private String getPath() {
		return "resources" + File.separator + String.valueOf(getYear()) + File.separator + "day"
				+ String.valueOf(getDay()) + File.separator + getFileName();
	}

	private int getYear() {
		return year;
	}

	private int getDay() {
		return day;
	}
}
