package com.adventofcode;

public class AdventExecuter {

	public static void main(String[] args) {
		try {
			Application app = new Application(args);
			
			Challenge challenge = ChallengeFactory.createChallenge(app.getYear(), app.getDay(), app.getChallengeNumber());
			
			String output = ChallengeRunner.run(challenge, app.getInput());
			
			System.out.println(output);
		}
		catch( IllegalArgumentException e ) {
			System.err.println(e.getMessage());
		}

		return;
	}
	
}
