package com.adventofcode.y2016.day2;

import com.adventofcode.Challenge;
import com.adventofcode.ChallengeFactory;
import com.adventofcode.NullChallenge;

public class Day2ChallengeFactory implements ChallengeFactory {

	@Override
	public Challenge createChallenge(int challenge) {
		switch( challenge ) {
			case 1:
				return new Day2Challenge1();
			case 2:
				return new Day2Challenge2();
		}
		return new NullChallenge();
	}

}
