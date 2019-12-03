package com.adventofcode.y2016.day8;

import java.util.Arrays;

import com.adventofcode.AbstractChallenge;

public class Day8Challenge1 extends AbstractChallenge {

	private boolean[][] display;
	private static final int X = 50;
	private static final int Y = 6;

	public void initialize() {
		this.display = new boolean[X][Y];
		for( boolean[] displayRow : getDisplay() ) {
			Arrays.fill(displayRow, false);
		}
	}
	
	protected boolean[][] getDisplay() {
		return this.display;
	}
	
	public void processLine(String input) {
		callMethod(input);
	}

	private void callMethod(String command) {
		String[] parsedCommand = command.split(" ");
		switch( parsedCommand[0] ) {
			case "rect":
				if( parsedCommand.length == 2 ) {
					rect(parsedCommand[1]);
				}
				return;
			case "rotate":
				if( parsedCommand.length == 5 ) {
					switch( parsedCommand[1] ) {
						case "column":
							rotateColumn(parsedCommand[2], parsedCommand[4]);
							return;
						case "row":
							rotateRow(parsedCommand[2], parsedCommand[4]);
							return;
					}
				}
			default:
				return;
		}
	}

	private void rect(String dimensionString) {
		int[] dims = { 0, 0 };
		String[] dimStr = dimensionString.split("x");
		if( dimStr.length == 2 && isInt(dimStr[0]) && isInt(dimStr[1]) ) {
			dims[0] = Integer.parseInt(dimStr[0]);
			dims[1] = Integer.parseInt(dimStr[1]);
		}
		for( int i = 0; i < dims[0]; i++ ) {
			for( int j = 0; j < dims[1]; j++ ) {
				getDisplay()[i][j] = true;
			}
		}
	}

	private boolean isInt(String str) {
		try {
			Integer.parseInt(str);
		}
		catch( NumberFormatException e ) {
			return false;
		}
		return true;
	}

	private void rotateColumn(String index, String shift) {
		int[] dims = parseRotateCommand(index, shift);
		boolean[] column = getDisplay()[dims[0]].clone();
		for( int j = 0; j < Y; j++ ) {
			getDisplay()[dims[0]][Math.floorMod(j + dims[1], Y)] = column[j];
		}
	}

	private int[] parseRotateCommand(String index, String shift) {
		int[] dims = { 0, 0 };
		String[] indexStr = index.split("=");
		if( indexStr.length == 2 && isInt(indexStr[1]) && isInt(shift) ) {
			dims[0] = Integer.parseInt(indexStr[1]);
			dims[1] = Integer.parseInt(shift);
		}
		return dims;
	}

	private void rotateRow(String index, String shift) {
		int[] dims = parseRotateCommand(index, shift);
		boolean[] row = new boolean[X];
		for( int i = 0; i < X; i++ ) {
			row[i] = getDisplay()[i][dims[0]];
		}
		for( int i = 0; i < X; i++ ) {
			getDisplay()[Math.floorMod(i + dims[1], X)][dims[0]] = row[i];
		}
	}
	
	public String getOutput() {
		return String.valueOf(count());
	}

	private int count() {
		int count = 0;
		for( boolean[] row : getDisplay() ) {
			for( boolean cell : row ) {
				if( cell ) {
					count++;
				}
			}
		}
		return count;
	}

}
