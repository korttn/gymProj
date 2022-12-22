package com.gym.proj.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import com.gym.proj.common.bean.ParamMap;


public class DateUtil {
	
	public static String getCurrentDate() {
        Date today = new Date();
        Locale currentLocale = new Locale("KOREAN", "KOREA");
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, currentLocale);
        return formatter.format(today);
    }
	
	public static String getCurrentDateTime() {
        Date today = new Date();
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, Locale.KOREA);
        return formatter.format(today);
    }
	
	public static String getCurrentDateTimeSSS() {
        Date today = new Date();
        String pattern = "yyyy-MM-dd HH:mm:ss.SSS";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, Locale.KOREA);
        return formatter.format(today);
    }
	
	public static String getCurrentTime() {
        Date today = new Date();
        Locale currentLocale = new Locale("KOREAN", "KOREA");
        String pattern = "HH:mm:ss";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, currentLocale);
        return formatter.format(today);
    }
	
	public static String getCurrentTimeSSS() {
        Date today = new Date();
        Locale currentLocale = new Locale("KOREAN", "KOREA");
        String pattern = "HHmmssSSS";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, currentLocale);
        return formatter.format(today);
    }
	
	public static String getCurrentDateToKoreaSSS() {
		TimeZone time;
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
 
        time = TimeZone.getTimeZone("Asia/Seoul");
        df.setTimeZone(time);
        System.out.format("%s%n%s%n", time.getDisplayName(), df.format(date));
        
        return df.format(date);
	}
	
	public static String getCurrentDateToKorea() {
		TimeZone time;
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 
        time = TimeZone.getTimeZone("Asia/Seoul");
        df.setTimeZone(time);
        System.out.format("%s%n%s%n", time.getDisplayName(), df.format(date));
        
        return df.format(date);
	}
	
	/**
   	 * 회계년 조회 날짜 작년 10월 부터 금년 9월 까지
   	 * @param String Year YYYY 형태
   	 * @return String ParamMap start date, end date          
   	 * @since 2019. 10. 23.
   	 */
	public static ParamMap getFiscalYearDate(String Year) {
		ParamMap map = new ParamMap();
		int inputYear = Integer.parseInt(Year) - 1;
		
		Calendar start = Calendar.getInstance();
		start.set(Calendar.YEAR, inputYear);
		start.set(Calendar.MONTH, 9);
		start.set(Calendar.DATE, start.getMinimum(Calendar.DAY_OF_MONTH));
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		map.put("start", formatter.format(start.getTime()));
		
		Calendar end = Calendar.getInstance();
		end.set(Calendar.YEAR, Integer.parseInt(Year));
		end.set(Calendar.MONTH, 8);
		end.set(Calendar.DATE, end.getActualMaximum(Calendar.DAY_OF_MONTH));
		map.put("end", formatter.format(end.getTime()));
		
		return map;
	}

	
	public static void main(String[] args) {
        //
		System.out.format("%s%n%s%n", "local korea", DateUtil.getCurrentDate());
		System.out.format("%s%n%s%n", "local korea,korean", DateUtil.getCurrentDateTimeSSS());
		
		ParamMap map = DateUtil.getFiscalYearDate("2018");
		System.out.println("start date : " + (String)map.get("start"));
		System.out.println("end date : " + (String)map.get("end"));
		
        TimeZone time;
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS (z Z)");
 
        time = TimeZone.getTimeZone("Asia/Seoul");
        df.setTimeZone(time);
        System.out.format("%s%n%s%n", time.getDisplayName(), df.format(date));

        time = TimeZone.getTimeZone("America/Los_Angeles");
        df.setTimeZone(time);
        System.out.format("%s%n%s%n", time.getDisplayName(), df.format(date));
 
        time = TimeZone.getTimeZone("America/New_York");
        df.setTimeZone(time);
        System.out.format("%s%n%s%n", time.getDisplayName(), df.format(date));
 
        time = TimeZone.getTimeZone("Pacific/Honolulu");
        df.setTimeZone(time);
        System.out.format("%s%n%s%n", time.getDisplayName(), df.format(date));
        
    }

}
