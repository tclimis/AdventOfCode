package com.adventofcode.y2016.day5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import com.adventofcode.BasicFileParser;
import com.adventofcode.FileParser;
import com.adventofcode.y2016.AbstractChallenge;

public class Day5Challenge1 extends AbstractChallenge {

	@Override
	public String execute(String inputFile) {
		String doorCode = "";
		FileParser parser = new BasicFileParser(getYear(), getDay(), inputFile);
		for( String line : parser.getFileLines() ) {
			doorCode = getDoorCode(line);
		}
		return doorCode;
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

}
