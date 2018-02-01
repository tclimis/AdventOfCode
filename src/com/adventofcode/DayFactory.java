package com.adventofcode;

public interface DayFactory {

	public ChallengeFactory createChallengeFactory(int day);
}
