package com.adventofcode;

import java.io.File;

public class Application {
	
	private int year;
	private int day;
	private int challengeNumber;
	private File input;

	public Application(String[] args) throws IllegalArgumentException {
		if( args.length != 4 ) {
			throw new IllegalArgumentException("For arguments are required: year, day, challenge, and file name");
		}
		
		try {
			setYear(Integer.parseInt(args[0]));
			setDay(Integer.parseInt(args[1]));
			setChallengeNumber(Integer.parseInt(args[2]));
			setInput(args[3]);
		}
		catch( Exception e ) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}
	
	private void setYear(int year) {
		this.year = year;
	}
	
	private void setDay(int day) {
		this.day = day;
	}
	
	private void setChallengeNumber(int challengeNumber) {
		this.challengeNumber = challengeNumber;
	}
	
	private void setInput(String fileName) {
		this.input = new File(getPath(fileName));
	}
	
	private String getPath(String fileName) {
		return new StringBuilder("resources").append(File.separator)
				.append(getYear()).append(File.separator)
				.append("day").append(getDay()).append(File.separator)
				.append(fileName)
				.toString();
	}
	
	public int getYear() {
		return this.year;
	}
	
	public int getDay() {
		return this.day;
	}
	
	public int getChallengeNumber() {
		return this.challengeNumber;
	}
	
	public File getInput() {
		return this.input;
	}

}
