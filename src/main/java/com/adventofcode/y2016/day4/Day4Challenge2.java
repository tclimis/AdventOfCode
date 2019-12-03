package com.adventofcode.y2016.day4;

public class Day4Challenge2 extends Day4Challenge1 {
	
	private String output;
	
	public void initialze() {
		output = "";
	}
	
	public void processLine(String input) {
		if( isRealRoom(input)
				&& decryptRoom(getEncryptedName(input), getSector(input)).equals("northpole object storage") ) {
			output = String.valueOf(getSector(input));
		}
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
	
	public String getOutput() {
		return output;
	}
}
