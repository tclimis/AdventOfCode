package com.adventofcode.y2016.day10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.adventofcode.AbstractChallenge;

public class Day10Challenge1 extends AbstractChallenge {

	private Map<Integer, Robot> robots;
	private Map<Integer, Outbox> outputs;

	public void initialize() {
		this.robots = new HashMap<Integer, Robot>();
		this.outputs = new HashMap<Integer, Outbox>();
	}
	
	public void processLine(String input) {
		parseInstruction(input);
	}

	private void parseInstruction(String instruction) {
		String[] instructionArray = instruction.split(" ");
		if( isGiveInstruction(instructionArray) ) {
			Robot robot = getRobot(Integer.parseInt(instructionArray[1]));
			Recipient lowRecipient = getRecipient(instructionArray[5], Integer.parseInt(instructionArray[6]));
			Recipient highRecipient = getRecipient(instructionArray[10], Integer.parseInt(instructionArray[11]));
			processGiveInstruction(robot, lowRecipient, highRecipient);
		}
		else if( isPutInstruction(instructionArray) ) {
			Robot robot = getRobot(Integer.parseInt(instructionArray[5]));
			processPutInstruction(robot, Integer.parseInt(instructionArray[1]));
		}
	}

	private boolean isGiveInstruction(String[] instruction) {
		return instruction.length == 12 && (instruction[5].equals("bot") || instruction[5].equals("output"))
				&& (instruction[10].equals("bot") || instruction[10].equals("output")) && isInt(instruction[1])
				&& isInt(instruction[6]) && isInt(instruction[11]);
	}

	private boolean isInt(String integer) {
		try {
			Integer.parseInt(integer);
		}
		catch( NumberFormatException e ) {
			return false;
		}
		return true;
	}

	private Robot getRobot(int id) {
		getRobots().putIfAbsent(id, new Robot(id));
		return getRobots().get(id);
	}

	protected Map<Integer, Robot> getRobots() {
		return this.robots;
	}

	private Recipient getRecipient(String type, int id) {
		if( type.equals("bot") ) {
			return getRobot(id);
		}

		return getOutbox(id);
	}

	private Outbox getOutbox(int id) {
		getOutputs().putIfAbsent(id, new Outbox(id));
		return getOutputs().get(id);
	}

	protected Map<Integer, Outbox> getOutputs() {
		return this.outputs;
	}

	private void processGiveInstruction(Robot robot, Recipient lowRecipient, Recipient highRecipient) {
		robot.setRecipientLow(lowRecipient);
		robot.setRecipientHigh(highRecipient);
	}

	private boolean isPutInstruction(String[] instruction) {
		return instruction.length == 6 && isInt(instruction[1]) && isInt(instruction[5]);
	}

	private void processPutInstruction(Robot robot, Integer chip) {
		robot.give(chip);
	}
	
	public String getOutput() {
		Iterator<Robot> robots = getRobots().values().iterator();
		boolean robotsAreEmpty = true;
		while( robots.hasNext() ) {
			Robot robot = robots.next();
			if( robot.areHandsFull() ) {
				robotsAreEmpty = false;
				if( robot.getContents().contains(61) && robot.getContents().contains(17) ) {
					return String.valueOf(robot.getID());
				}
				robot.giveHandContents();
			}
			if( !robots.hasNext() ) {
				if( robotsAreEmpty ) {
					return "";
				}
				robots = getRobots().values().iterator();
				robotsAreEmpty = true;
			}
		}

		return "";
	}

}
