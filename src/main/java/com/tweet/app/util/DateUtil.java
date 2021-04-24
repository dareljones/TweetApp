package com.tweet.app.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.tweet.app.constants.BatchConstants;

public class DateUtil {
	public static Date convertToDate(String date) {
		Date parsedDate = null;
		try {
			SimpleDateFormat dateFormate = new SimpleDateFormat(BatchConstants.DOB_FORMAT);
			dateFormate.setLenient(false);
			parsedDate = dateFormate.parse(date);
		} catch (ParseException parseException) {
			System.out.println("invalid Date format... please enter the DateOfBirth "+BatchConstants.DOB_FORMAT +" format");
		}
		return parsedDate;
	}
}