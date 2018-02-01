package com.adventofcode.y2015.day10;

import com.adventofcode.Challenge;
import com.adventofcode.ChallengeFactory;
import com.adventofcode.NullChallenge;

public class Day10ChallengeFactory implements ChallengeFactory {

	@Override
	public Challenge createChallenge(int challenge) {
		switch( challenge ) {
			case 1:
			case 2:
				return new Day10Challenge1();
			default:
				return new NullChallenge();
		}
	}

}
