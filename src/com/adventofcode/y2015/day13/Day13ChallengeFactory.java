package com.adventofcode.y2015.day13;

import com.adventofcode.Challenge;
import com.adventofcode.ChallengeFactory;
import com.adventofcode.NullChallenge;

public class Day13ChallengeFactory implements ChallengeFactory {

	@Override
	public Challenge createChallenge(int challenge) {
		switch( challenge ) {
			case 1:
				return new Day13Challenge1();
			case 2:
				return new Day13Challenge2();
			default:
				return new NullChallenge();
		}
	}

}
