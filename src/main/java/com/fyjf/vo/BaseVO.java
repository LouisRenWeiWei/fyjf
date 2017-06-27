package com.fyjf.vo;


public class BaseVO {
	public static final int CODE_LOGIN_NEED = -2;//登录失败
	public static final int CODE_LOGIN_ERROR = -1;//登录失败
	public static final int CODE_SUCCESS = 0;
	public static final int CODE_ERROR = 1;
	public static final int CODE_AUTH_RROR = 2;
	public static final int CODE_AUTH_SUCCESS = 4;
	
	
	
	private int code;
	private Object data;
	private String msg;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	

}
