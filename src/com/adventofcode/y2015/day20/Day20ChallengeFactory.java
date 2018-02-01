package com.adventofcode.y2015.day20;

import com.adventofcode.Challenge;
import com.adventofcode.ChallengeFactory;
import com.adventofcode.NullChallenge;

public class Day20ChallengeFactory implements ChallengeFactory {

	@Override
	public Challenge createChallenge(int challenge) {
		switch( challenge ) {
			case 1:
				return new Day20Challenge1();
			case 2:
				return new Day20Challenge2();
			default:
				return new NullChallenge();
		}
	}

}
