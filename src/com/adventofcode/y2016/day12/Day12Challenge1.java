package com.adventofcode.y2016.day12;

import java.util.HashMap;
import java.util.Map;

import com.adventofcode.BasicFileParser;
import com.adventofcode.FileParser;
import com.adventofcode.y2016.AbstractChallenge;

public class Day12Challenge1 extends AbstractChallenge {

	private Map<String, Integer> registers;
	private int currentLine;

	@Override
	public String execute(String inputFile) {
		initializeRegisters();

		FileParser parser = new BasicFileParser(getYear(), getDay(), inputFile);
		String[] program = parser.getFileLines().toArray(new String[0]);
		while( this.currentLine < program.length ) {
			performOperation(program[this.currentLine]);
		}
		return Integer.toString(this.registers.get("a"));
	}

	protected void initializeRegisters() {
		this.registers = new HashMap<String, Integer>();
		getRegisters().put("a", 0);
		getRegisters().put("b", 0);
		getRegisters().put("c", 0);
		getRegisters().put("d", 0);
		this.currentLine = 0;
	}

	protected Map<String, Integer> getRegisters() {
		return this.registers;
	}

	private void performOperation(String command) {
		String[] operationArray = command.split(" ");
		switch( operationArray[0] ) {
			case "cpy":
				copy(operationArray[1], operationArray[2]);
				return;
			case "inc":
				increment(operationArray[1]);
				return;
			case "dec":
				decrement(operationArray[1]);
				return;
			case "jnz":
				jump(operationArray[1], operationArray[2]);
				return;
			default:
				return;
		}
	}

	private void copy(String src, String dest) {
		setRegister(dest, (isRegister(src) ? getRegister(src) : getInteger(src)));
		this.currentLine++;
	}

	private Integer getRegister(String register) {
		if( isRegister(register) ) {
			return this.registers.get(register);
		}
		return 0;
	}

	private boolean isRegister(String input) {
		return input.matches("[a-d]");
	}

	private Integer getInteger(String input) {
		try {
			return Integer.parseInt(input);
		}
		catch( NumberFormatException e ) {
			return 0;
		}
	}

	private void setRegister(String register, Integer value) {
		if( isRegister(register) ) {
			this.registers.put(register, value);
		}
	}

	private void increment(String register) {
		setRegister(register, getRegister(register) + 1);
		this.currentLine++;
	}

	private void decrement(String register) {
		setRegister(register, getRegister(register) - 1);
		this.currentLine++;
	}

	private void jump(String src, String offset) {
		int jumpValue = 1;
		Integer checkValue = isRegister(src) ? getRegister(src) : getInteger(src);
		if( !checkValue.equals(0) ) {
			jumpValue = getInteger(offset);
		}
		this.currentLine += jumpValue;
	}

}
