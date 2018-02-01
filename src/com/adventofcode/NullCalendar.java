package com.adventofcode;

public class NullCalendar implements DayFactory {

	@Override
	public ChallengeFactory createChallengeFactory(int day) {
		return new NullChallengeFactory();
	}

}
