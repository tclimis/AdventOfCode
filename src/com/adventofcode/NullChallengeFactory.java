package com.adventofcode;

public class NullChallengeFactory implements ChallengeFactory {

	@Override
	public Challenge createChallenge(int challenge) {
		return new NullChallenge();
	}

}
