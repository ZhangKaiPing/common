package com.zkp.utils;
/**
 * 
 * @ClassName: DateUtil 
 * @Description: 日期的工具类
 * @author: lenovo
 * @date: 2019年11月8日 下午7:53:11
 */

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	//思考：返回年龄在[20--60]岁之间的随机日期
	/**
	 * 方法1：返回治党日期的月初
	 * 给一个时间对象，返回该时间所在的月的1日0时0分0秒。例如一个date对象值是2019-05-18 11:37:22
	 * 则返回的结果为2019-05-01 00:00:00
	 */
	
	public  static Date getDateByInitMonth(Date src) {
		Calendar c=Calendar.getInstance();
		c.setTime(src);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND,0);
		return c.getTime();
	}
	
	/**
	 * 方法2：(5分) 返回指定日期的月末
	* 给一个时间对象，返回该时间所在月的最后日23时59分59秒，需要考虑月大月小和二月特殊情况。
	* 例如一个Date对象的值是2019-05-18 11:37:22，则返回的时间为2019-05-31 23:59:59
	* 例如一个Date对象的值是2019-02-05 15:42:18，则返回的时间为2019-02-28 23:59:59
	 */
	public static Date getDateByFullMonth(Date src) {
		Calendar c=Calendar.getInstance();
		c.setTime(src);
		c.add(Calendar.MONTH, 1);
		Date date=getDateByInitMonth(c.getTime());
		c.setTime(date);
		c.add(Calendar.SECOND,-1);
		return c.getTime();
	}
	
	//生成指定范围内随机日期：如2010年1月1日至今任意时间
	public static Date randomDate(Date d1,Date d2) {
		//开始的毫秒数
		long l1=d1.getTime();
		//结束的毫秒数
		long l2=d2.getTime();
		
		long l3=(long) ((Math.random()*(l2-l1+1))+l1);
		return new Date(l3);
	}
}
