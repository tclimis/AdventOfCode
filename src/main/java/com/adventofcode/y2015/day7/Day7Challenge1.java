package com.adventofcode.y2015.day7;

import com.adventofcode.Challenge;
import com.adventofcode.y2015.day7.commands.Command;

public class Day7Challenge1 implements Challenge {
	
	@Override
	public void initialize() {	
		// There's no inital state to set for this challenge
	}
	
	public void processLine(String input) {
		Command command = CommandParser.parseCommand(input);
		command.execute();
	}
	
	public String getOutput() {
		return Computer.getInstance().get("a").toString();
	}
	
	public boolean runAgain() {
		return Computer.getInstance().get("a") == null;
	}
}
