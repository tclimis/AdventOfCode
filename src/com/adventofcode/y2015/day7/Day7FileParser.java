package com.adventofcode.y2015.day7;

import com.adventofcode.BasicFileParser;
import com.adventofcode.y2015.day7.commands.And;
import com.adventofcode.y2015.day7.commands.Command;
import com.adventofcode.y2015.day7.commands.LShift;
import com.adventofcode.y2015.day7.commands.Not;
import com.adventofcode.y2015.day7.commands.NullCommand;
import com.adventofcode.y2015.day7.commands.Or;
import com.adventofcode.y2015.day7.commands.Put;
import com.adventofcode.y2015.day7.commands.RShift;

public class Day7FileParser extends BasicFileParser {

	public Day7FileParser(int year, int day, String fileName) {
		super(year, day, fileName);
	}

	public Command parseCommand(String command) {
		String[] commandArray = command.split(" ");

		Command commandObj = new NullCommand();

		if( commandArray.length == 3 && commandArray[1].equals("->") ) {
			commandObj = new Put(commandArray[0], commandArray[2]);
		}
		else if( commandArray.length == 4 && commandArray[0].equals("NOT") && commandArray[2].equals("->") ) {
			commandObj = new Not(commandArray[1], commandArray[3]);
		}
		else if( commandArray.length == 5 && commandArray[3].equals("->") && commandArray[1].equals("AND") ) {
			commandObj = new And(commandArray[0], commandArray[2], commandArray[4]);
		}
		else if( commandArray.length == 5 && commandArray[3].equals("->") && commandArray[1].equals("OR") ) {
			commandObj = new Or(commandArray[0], commandArray[2], commandArray[4]);
		}
		else if( commandArray.length == 5 && commandArray[3].equals("->") && commandArray[1].equals("LSHIFT") ) {
			commandObj = new LShift(commandArray[0], commandArray[2], commandArray[4]);
		}
		else if( commandArray.length == 5 && commandArray[3].equals("->") && commandArray[1].equals("RSHIFT") ) {
			commandObj = new RShift(commandArray[0], commandArray[2], commandArray[4]);
		}

		return commandObj;
	}

}
