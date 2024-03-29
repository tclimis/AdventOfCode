package com.adventofcode.y2016.day5;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import jakarta.xml.bind.DatatypeConverter;

import com.adventofcode.AbstractChallenge;

public class Day5Challenge1 extends AbstractChallenge {

	private String doorCode;

	public void initialize() {
		doorCode = "";
	}

	public void processLine(String input) {
		doorCode = getDoorCode(input);
	}

	protected String getDoorCode(String input) {
		StringBuilder tempDoorCode = new StringBuilder();
		int i = 0;
		while( tempDoorCode.length() < 8 ) {
			String hash = getHash(input + String.valueOf(i++));
			if( hash.startsWith("00000") ) {
				tempDoorCode.append(hash.charAt(5));
			}
		}
		return tempDoorCode.toString();
	}

	protected String getHash(String string) {
		try {
			return DatatypeConverter.printHexBinary(MessageDigest.getInstance("MD5").digest(string.getBytes(StandardCharsets.UTF_8)));
		}
		catch( NoSuchAlgorithmException e ) {
			return e.getMessage();
		}
	}

	public String getOutput() {
		return doorCode;
	}

}
