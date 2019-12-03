package com.adventofcode;

import java.io.File;

public class ChallengeRunner {
		
	public static String run(Challenge challenge, File inputFile) {
		challenge.initialize();
		
		FileParser parser = new BasicFileParser(inputFile);
		do {
			for( String line : parser.getFileLines() ) {
				challenge.processLine(line);
			}
		}
		while( challenge.runAgain() );
		
		return challenge.getOutput();
	}

}
