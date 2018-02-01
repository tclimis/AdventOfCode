package com.adventofcode;

public class AdventExecuter {

	public static void main(String[] args) {

		if( args.length == 4 ) {
			try {
				int year = Integer.parseInt(args[0]);
				int day = Integer.parseInt(args[1]);
				int challengeNumber = Integer.parseInt(args[2]);
				String inputFile = args[3];

				Challenge challenge = CalendarFactory.createCalendar(year).createChallengeFactory(day)
						.createChallenge(challengeNumber);

				challenge.setDay(day);
				String output = challenge.execute(inputFile);

				System.out.println(output);
			}
			catch( NumberFormatException e ) {
				System.err.println(e.getMessage());
			}
		}

		return;
	}

}
