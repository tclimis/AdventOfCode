package com.adventofcode;

public class AdventExecuter {

	public static void main(final String[] args) {
		try {
			final Application app = new Application(args);

			final Challenge challenge = ChallengeFactory.createChallenge(app.getYear(), app.getDay(),
					app.getChallengeNumber());

			final String output = ChallengeRunner.run(challenge, app.getInput());

			System.out.println(output);
		} catch (final IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}

		return;
	}
	
}
