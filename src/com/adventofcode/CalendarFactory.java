package com.adventofcode;

import com.adventofcode.y2015.Calendar2015;
import com.adventofcode.y2016.Calendar2016;

public class CalendarFactory {
	public static DayFactory createCalendar(int year) {
		switch( year ) {
			case 2016:
				return new Calendar2016();
			case 2015:
				return new Calendar2015();
			default:
				return new NullCalendar();
		}
	}
}
