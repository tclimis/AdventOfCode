package com.adventofcode.y2015.day17;

import com.adventofcode.Challenge;
import com.adventofcode.ChallengeFactory;
import com.adventofcode.NullChallenge;

public class Day17ChallengeFactory implements ChallengeFactory {

	@Override
	public Challenge createChallenge(int challenge) {
		switch( challenge ) {
			case 1:
				return new Day17Challenge1();
			case 2:
				return new Day17Challenge2();
			default:
				return new NullChallenge();
		}
	}

}
