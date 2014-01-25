package com.jt.sd.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	private SimpleDateFormat format = new SimpleDateFormat("YYYY/mm/dd HH:mm:ss");
	
	public Date parseDate(String source) {
		try {
			return format.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Date getDate(Timestamp ts) {
		Date date = new Date(ts.getTime());
		return date;
	}

}
