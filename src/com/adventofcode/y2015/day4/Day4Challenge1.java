package com.adventofcode.y2015.day4;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.adventofcode.BasicFileParser;
import com.adventofcode.FileParser;
import com.adventofcode.y2015.AbstractChallenge;

public class Day4Challenge1 extends AbstractChallenge {

	@Override
	public String execute(String inputFile) {
		FileParser fileParser = new BasicFileParser(getYear(), getDay(), inputFile);
		for( String line : fileParser.getFileLines() ) {
			int i = 1;
			while( !md5StartsWith00000(line, i) ) {
				i++;
			}
			return new Integer(i).toString();
		}
		return "";
	}

	private boolean md5StartsWith00000(String line, int number) {
		String value = line + new Integer(number).toString();
		try {
			byte[] md5Bytes = MessageDigest.getInstance("MD5").digest(value.getBytes(StandardCharsets.UTF_8));
			return (md5Bytes[0] == 0 && md5Bytes[1] == 0 && md5Bytes[2] >= 0 && md5Bytes[2] < 16);

		}
		catch( NoSuchAlgorithmException e ) {
			return false;
		}
	}
}
