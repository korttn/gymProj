package com.gym.proj.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gym.proj.common.exception.LogicException;


public class CommonUtil {
	
	public static boolean isNull(Object obj) {
		boolean result = false;
		try {
			if (obj == null) {
				throw new LogicException("Object empty");
			} else if (obj instanceof String && obj.equals("")) {
				throw new LogicException("String empty");
			} else if (obj instanceof Map && ((Map<?, ?>) obj).isEmpty()) {
				throw new LogicException("Map empty");
			} else if (obj instanceof Set && ((Set<?>) obj).isEmpty()) {
				throw new LogicException("Set empty");
			} else if (obj instanceof List) {
				List<?> list = (List<?>)obj;
				if(list.size() == 0) {
					throw new LogicException("List empty");
				} else {
					for(Object listObj: list) {
						if(isNull(listObj)) {
							result = true;
							break;
						}
					}
				}
			} 
		} catch (Exception e) {
			result = true;
		}
		
		return result;
	}

	/**
	 * Integer null 체크
	 * 
	 * @param Integer str : 체크할 Integer data
	 * @return int : 0 or str          
	 * @since 2019. 10. 23.
	 */
	public static int nvl(Integer str) {
		if(isNull(str)) return 0;
		else return str;
	}
	
	/**
	 * 현 시간을 리턴
	 * 
	 * @param 
	 * @return String : yyyy-MM-dd hh:mm:ss date format으로 현 시간 리턴
	 * @since 2019. 10
	 */
	public static String getCurrentTime() {
    	Calendar calendar = Calendar.getInstance();
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	return formatter.format(calendar.getTime());
    }
    
	/**
	 * 현 시간을 리턴
	 * 
	 * @param String : 리턴될 date format형태
	 * @return String : parameter로 받은 date format으로 현 시간을 리턴
	 * @since 2019. 10
	 */
    public static String getCurrentTime(String dataFormat) {
    	Calendar calendar = Calendar.getInstance();
    	SimpleDateFormat formatter = new SimpleDateFormat(dataFormat);
    	return formatter.format(calendar.getTime());
    }
    
    /**
	 * 문자형 숫자를 int 형으로 리턴
	 * 
	 * @param String : 0~9로 된 숫자형 String
	 * @return int 
	 * @since 2019. 10
	 */
    public static int convertStringToInt(String num) {
    	if (isNull(num)) 
    		num = "0";
    	else if (!num.matches("[0-9]+"))
    		num = "0";
    	return Integer.parseInt(num); 
    }
    
    /**
	 * 문자형 숫자를 Long 형으로 리턴
	 * 
	 * @param String : 0~9로 된 숫자형 String
	 * @return Long 
	 * @since 2019. 10
	 */
    public static long convertStringToLong(String num) {
    	if (isNull(num)) 
    		num = "0";
    	else if (!num.matches("[0-9]+"))
    		num = "0";
    	return Long.parseLong(num); 
    }
    
   
	
}
