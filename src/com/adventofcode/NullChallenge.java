package com.adventofcode;

public class NullChallenge implements Challenge {

	@Override
	public String execute(String input) {
		return "Challenge not found";
	}

	@Override
	public int getYear() {
		return 0;
	}

	@Override
	public void setDay(int day) {}

}
