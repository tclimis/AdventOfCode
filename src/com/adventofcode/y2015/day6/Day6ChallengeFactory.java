package com.adventofcode.y2015.day6;

import com.adventofcode.Challenge;
import com.adventofcode.ChallengeFactory;
import com.adventofcode.NullChallenge;

public class Day6ChallengeFactory implements ChallengeFactory {

	@Override
	public Challenge createChallenge(int challenge) {
		switch( challenge ) {
			case 1:
				return new Day6Challenge1();
			case 2:
				return new Day6Challenge2();
			default:
				return new NullChallenge();
		}
	}

}
