package com.adventofcode.y2016.day5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

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
		String doorCode = "";
		int i = 0;
		while( doorCode.length() < 8 ) {
			String hash = getHash(input + String.valueOf(i++));
			if( hash.startsWith("00000") ) {
				doorCode += hash.charAt(5);
			}
		}
		return doorCode;
	}

	protected String getHash(String string) {
		try {
			return DatatypeConverter.printHexBinary(MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8")));
		}
		catch( NoSuchAlgorithmException e ) {
			return e.getMessage();
		}
		catch( UnsupportedEncodingException e ) {
			return e.getMessage();
		}
	}
	
	public String getOutput() {
		return doorCode;
	}

}
