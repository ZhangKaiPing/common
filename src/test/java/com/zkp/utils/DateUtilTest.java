package com.zkp.utils;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateUtilTest {

	@Test
	public void testGetDateByInitMonth() {
		Calendar c=Calendar.getInstance();
		c.set(2008,7,8);//2008-08-08
		Date date=DateUtil.getDateByInitMonth(c.getTime());
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(date));
	}

	@Test
	public void testGetDateByFullMonth() {
		Calendar calendar=Calendar.getInstance();
		calendar.set(2019, 10, 8);
		Date date=DateUtil.getDateByFullMonth(calendar.getTime());
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(date));
	}

	@Test
	public void testRandomDate() {
		Calendar calendar=Calendar.getInstance();
		calendar.set(2019, 10, 8);
		Calendar c=Calendar.getInstance();
		c.set(2008,7,8);//2008-08-08
		Date d1 = c.getTime();
		Date d2 = calendar.getTime();
		
	Date date=DateUtil.randomDate(d1, d2);
	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	System.out.println(df.format(date));
		
	}

}
