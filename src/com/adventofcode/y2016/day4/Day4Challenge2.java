package com.adventofcode.y2016.day4;

import com.adventofcode.BasicFileParser;
import com.adventofcode.FileParser;

public class Day4Challenge2 extends Day4Challenge1 {

	@Override
	public String execute(String inputFile) {
		FileParser parser = new BasicFileParser(getYear(), getDay(), inputFile);
		for( String line : parser.getFileLines() ) {
			if( isRealRoom(line)
					&& decryptRoom(getEncryptedName(line), getSector(line)).equals("northpole object storage") ) {
				return String.valueOf(getSector(line));
			}
		}
		return "";
	}

	private String decryptRoom(String encryptedName, int sector) {
		String roomName = "";
		for( int i = 0; i < encryptedName.length(); i++ ) {
			if( encryptedName.charAt(i) >= 'a' && encryptedName.charAt(i) <= 'z' ) {
				char newChar = (char) (Math.floorMod((encryptedName.charAt(i)) - 'a' + sector, 26) + 'a');
				roomName += Character.toString(newChar);
			}
			else {
				roomName += " ";
			}
		}
		return roomName.trim();
	}
}
