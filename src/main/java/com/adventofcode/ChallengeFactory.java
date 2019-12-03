package com.adventofcode;

public class ChallengeFactory {

	public static Challenge createChallenge(final int year, final int day, final int challenge) {
		try {
			final String packageName = "com.adventofcode.y" + year + ".day" + day;
			final String className = "Day" + day + "Challenge" + challenge;
			final Object challengeObj = Class.forName(packageName + "." + className).getConstructor().newInstance();
			return (Challenge) challengeObj;
		} catch (final Exception e) {
			return new NullChallenge();
		}
	}

}
