package com.adventofcode.y2015.day9;

import com.adventofcode.Challenge;
import com.adventofcode.ChallengeFactory;
import com.adventofcode.NullChallenge;

public class Day9ChallengeFactory implements ChallengeFactory {

	@Override
	public Challenge createChallenge(int challenge) {
		switch( challenge ) {
			case 1:
				return new Day9Challenge1();
			case 2:
				return new Day9Challenge2();
			default:
				return new NullChallenge();
		}
	}

}
