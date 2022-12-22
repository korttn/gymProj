package com.gym.proj.common.bean;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public class ParamMap extends HashMap<String, Object> {
	
private static final long serialVersionUID = 1L;
	
	private HttpServletRequest request = null;
	private HttpSession session = null;
	
	public ParamMap() {
		
	}
	
	public ParamMap(Map<String, Object> map) {
		if(map != null)	super.putAll(map);
	}
	
	public ParamMap(HttpServletRequest request) throws UnsupportedEncodingException {
		
		Enumeration<String> names = request.getParameterNames();
		
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			String param = request.getParameter(name);
			super.put(name, param);
		}
		
		this.request = request;
		this.session = request.getSession();
	}
	
	/**
	 *  containKeys
	 * 
	 * */
	public boolean containKeys(String[] keys) {
		
		for(String key : keys) {
			if(!super.containsKey(key)) {
				super.put("containsKeysFalseData", key);
				return false;
			}
			
		}
		return true;
	}
	
	/**
	 * removes
	 * */
	public ParamMap removes(String[] keys) {
		
		for(String key : keys) {
			super.remove(key);
		}
		
		return this;
	}
	
	
	/**
	 * get Request
	 * */
	public HttpServletRequest getRequest() {
		return this.request;
	}
	
	
	/**
	 * get Multipart Request
	 * */
	public MultipartHttpServletRequest getMultipartRequest() {
		
		if(request instanceof MultipartHttpServletRequest) {
			return (MultipartHttpServletRequest) request;
		} else {
			return null;
		}
	}
	
	/**
	 * Object 값 반환 
	 * */
	public Object get(String key) {
		
		Object result = super.get(key);
		
		if(result == null) {
			result = "";
		}
		
		return result;
	}
	
	/**
	 * Integer 반환
	 * */
	public int getInt(String key) {
		
		int result = 0;
		
		Object obj = super.get(key);
		
		try{
			
			if(obj != null) {
				
				if(obj instanceof String) {
					result = Integer.parseInt((String)obj);
				} else if(obj instanceof Number) {
					result = ((Number)obj).intValue();
				}
			}
			
		} catch(Exception e) {
			result = 0;
		}
		
		return result;
	}
	
	/**
	 * Long 반환
	 * getLongN에서 마지막 N은 Nullable의 약자
	 */
	public Long getLongN(String key) {
		Object obj = super.get(key);
		Long result = null;
		try{
			if(obj != null) {
				if(obj instanceof String) {
					result = Long.parseLong((String)obj);
				} else if(obj instanceof Number) {
					result = ((Number)obj).longValue();
				}
			}
			
		} catch(Exception e) {
		}
		return result;
	}
	/**
	 * long 반환
	 * */
	public long getLong(String key) {
		Long result = getLongN(key);
		if (result == null)
			result = 0L;
		return result;
	}
	
	/**
	 * Boolean 값 반환
	 * */
	public Boolean getBoolean(String key) {
		
		boolean result = false;
		
		Object obj = super.get(key);
		try{
			
			if(obj != null) {
				if (obj instanceof Boolean) {
					if ((Boolean)obj) {
						result = true;
					} else {
						result = false;
					}
				}
			}
			
		} catch(Exception e) {
			result = false;
		}
		
		return result;
	}
	
	/**
	 * String 값 반환
	 **/
	public String getString(String key) {
		String result = "";
		Object obj = super.get(key);
		try {
			if (obj != null) {
				if (obj instanceof String) {
					result = (String)obj;
				} else if (obj instanceof Boolean) {
					result = String.valueOf((Boolean)obj);
				} else if (obj instanceof Integer) {
					result = String.valueOf((Integer)obj);
				} else if (obj instanceof Long) {
					result = String.valueOf((Long)obj);
				} else if (obj instanceof Short) {
					result = String.valueOf((Short)obj);
				} else if (obj instanceof Float) {
					result = String.valueOf((Float)obj);
				} else if (obj instanceof Double) {
					result = String.valueOf((Double)obj);
				} else if (obj instanceof Character) {
					result = String.valueOf((Character)obj);
				} else if (obj instanceof BigDecimal) {
					result = ((BigDecimal)obj).toString();
				} else {
					result = obj.toString();
				}
			}
		} catch(Exception e) {
			result = "";
		}
		return result;
	}
	
	/**
	 * 객체 명 반환
	 **/
	public String[] getNames() {
		Iterator<String> iterator = this.keySet().iterator();
		String[] names = new String[this.keySet().size()];
		for (int i=0; iterator.hasNext(); i++) {
			names[i] = iterator.next();
		}
		return names;
	}
	
	public Object getAttribute(String key) {
		return (request != null) ? request.getAttribute(key) : null;
	}
	
	public void setAttribute(String key, Object obj) {
		if (request != null)  {
			request.setAttribute(key, obj);
		}
	}
	
	public Object getSessionAttribute(String key) {
		return (session != null) ? session.getAttribute(key) : null;
	}
	
	public void setSessionValue(String key, Object obj) {
		if (session != null)  {
			session.setAttribute(key, obj);
		}
	}
	
	public boolean strToBoolean(String str) {
		boolean result = false;
		if (str.toLowerCase().equals("true")) {
			result = true;
		} else if (str.toLowerCase().equals("false")) {
			result = false;
		}
		return result;
	}
}
