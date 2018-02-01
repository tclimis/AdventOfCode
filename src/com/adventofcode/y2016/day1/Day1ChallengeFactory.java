package com.adventofcode.y2016.day1;

import com.adventofcode.Challenge;
import com.adventofcode.ChallengeFactory;
import com.adventofcode.NullChallenge;

public class Day1ChallengeFactory implements ChallengeFactory {

	@Override
	public Challenge createChallenge(int challenge) {
		switch( challenge ) {
			case 1:
				return new Day1Challenge1();
			case 2:
				return new Day1Challenge2();
			default:
				return new NullChallenge();
		}
	}

}
