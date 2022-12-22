package com.gym.proj.common.bean;

import java.math.BigDecimal;
import java.util.HashMap;

import com.gym.proj.common.exception.LogicException;
import com.gym.proj.common.util.CommonUtil;

public class ResultMap extends HashMap<String, Object>{

	private static final long serialVersionUID = 1L;

	public ResultMap() {
		super();
        this.put("status", "200");
		this.put("msg", "success");
	}
	
	public ResultMap(String status){
		super();
		this.put("status", status);
	}
	
	public ResultMap(String status, String msg){
		super();
		this.put("status", status);
		this.put("msg", msg);
	}

	public void setErr(Exception e) {
		this.put("status", "999");
		this.put("msg", e.getMessage());
	}
	
	public void setErr(LogicException le) {
		this.put("status", (CommonUtil.isNull(le.getCode()) ? "999" : le.getCode()));
		this.put("msg", le.getMessage());
	}
	
	public String getStatus() {
		if (this.get("status") == null) {
			return "";
		} else {
			return (String)this.get("status");
		}
	}

	public void setStatus(String status) {
		this.put("status", status);
	}

	public String getMsg() {
		if (this.get("msg") == null) {
			return "";
		} else {
			return (String)this.get("msg");
		}
	}

	public void setMsg(String errMsg) {
		this.put("msg", errMsg);
	}
	
	/**
	 * Object 값 반환 
	 * */
	public Object get(String key) {
		
		Object result = super.get(key);
		
		if (result == null) {
			result = "";
		}
		
		return result;
	}
	
	/**
	 * Long 반환
	 * */
	public long getLong(String key) {
		
		long result = 0;
		Object obj = super.get(key);
		
		try{
			if(obj != null) {
				if(obj instanceof String) {
					result = Long.parseLong((String)obj);
				} else if(obj instanceof Number) {
					result = ((Number)obj).longValue();
				}
			}
			
		} catch(Exception e) {
			result = 0;
		}
		
		return result;
	}
	
	/**
	 * Boolean 값 반환
	 * */
	public Boolean getBoolean(String key) {
		
		boolean result = false;
		
		Object obj = super.get(key);
		try {
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
