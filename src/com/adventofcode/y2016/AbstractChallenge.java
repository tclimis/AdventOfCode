package com.adventofcode.y2016;

import com.adventofcode.Challenge;

public abstract class AbstractChallenge implements Challenge {

	private int day;

	@Override
	public int getYear() {
		return 2016;
	}

	@Override
	public void setDay(int day) {
		this.day = day;
	}

	protected int getDay() {
		return day;
	}

	@Override
	abstract public String execute(String inputFile);
}
