package com.adventofcode.y2015.day7;

import com.adventofcode.y2015.day7.commands.Command;
import com.adventofcode.y2015.AbstractChallenge;

public class Day7Challenge1 extends AbstractChallenge {

	@Override
	public String execute(String inputFile) {
		Day7FileParser fileParser = new Day7FileParser(getYear(), getDay(), inputFile);
		while( Computer.getInstance().get("a") == null ) {
			for( String line : fileParser.getFileLines() ) {
				Command command = fileParser.parseCommand(line);
				command.execute();
			}
		}

		return Computer.getInstance().get("a").toString();
	}
}
