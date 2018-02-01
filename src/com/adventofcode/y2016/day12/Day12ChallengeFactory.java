package com.adventofcode.y2016.day12;

import com.adventofcode.Challenge;
import com.adventofcode.ChallengeFactory;
import com.adventofcode.NullChallenge;

public class Day12ChallengeFactory implements ChallengeFactory {

	@Override
	public Challenge createChallenge(int challenge) {
		switch( challenge ) {
			case 1:
				return new Day12Challenge1();
			case 2:
				return new Day12Challenge2();
			default:
				return new NullChallenge();
		}
	}

}
