package com.adventofcode;

public class ChallengeFactory {

	public static Challenge createChallenge(int year, int day, int challenge) {
		try {
			String packageName = "com.adventofcode.y" + year + ".day" + day;
			String className = "Day" + day + "Challenge" + challenge;
			Object challengeObj = Class.forName(packageName + "." + className)
					.getConstructor()
					.newInstance();
			return (Challenge) challengeObj;
		}
		catch( Exception e ) {
			return new NullChallenge();
		}
	}

}
