package com.loan.aggregator.client.util;

import java.util.Calendar;
import java.util.TimeZone;

public class DateUtility {
	public static Calendar getCalendarInUTCZone() {
		Calendar calendar=Calendar.getInstance();
		calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
		return calendar;
	}

}
