package com.adventofcode;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AdventExecuter {

	public static void main(final String[] args) {
		try {
			final Application app = new Application(args);

			final Challenge challenge = ChallengeFactory.createChallenge(app.getYear(), app.getDay(),
					app.getChallengeNumber());

			final String output = ChallengeRunner.run(challenge, app.getInput());

			Logger.getGlobal().info(output);
		} catch (final IllegalArgumentException e) {
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
		}
	}
	
}
