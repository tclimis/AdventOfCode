package com.adventofcode.y2015.day23;

import com.adventofcode.Challenge;
import com.adventofcode.ChallengeFactory;
import com.adventofcode.NullChallenge;

public class Day23ChallengeFactory implements ChallengeFactory {

	@Override
	public Challenge createChallenge(int challenge) {
		switch( challenge ) {
			case 1:
				return new Day23Challenge1();
			case 2:
				return new Day23Challenge2();
			default:
				return new NullChallenge();
		}
	}

}
