package com.adventofcode.y2016.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.adventofcode.BasicFileParser;
import com.adventofcode.FileParser;
import com.adventofcode.y2016.AbstractChallenge;

public class Day7Challenge1 extends AbstractChallenge {

	@Override
	public String execute(String inputFile) {
		int count = 0;
		FileParser parser = new BasicFileParser(getYear(), getDay(), inputFile);
		for( String line : parser.getFileLines() ) {
			if( supportsTLS(line) ) {
				count++;
			}
		}
		return String.valueOf(count);
	}

	private boolean supportsTLS(String ipAddress) {
		boolean supportsTLS = false;
		if( containsABBA(ipAddress) ) {
			supportsTLS = true;
			for( String hyperNet : getHyperNets(ipAddress) ) {
				supportsTLS = supportsTLS && !containsABBA(hyperNet);
			}
		}
		return supportsTLS;
	}

	private boolean containsABBA(String str) {
		Pattern pattern = Pattern.compile("([a-z])(?!\\1)([a-z])\\2\\1");
		Matcher matcher = pattern.matcher(str);
		return matcher.find();
	}

	protected List<String> getHyperNets(String ipAddress) {
		List<String> hyperNets = new ArrayList<String>();
		for( int i = 0; i < ipAddress.length(); i++ ) {
			if( ipAddress.substring(i).contains("[") && ipAddress.substring(i).contains("]") ) {
				int start = ipAddress.indexOf('[', i) + 1;
				int end = ipAddress.indexOf(']', start);
				i = end;
				hyperNets.add(ipAddress.substring(start, end));
			}
		}
		return hyperNets;
	}

}
