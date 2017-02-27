package com.channelsoft.demo.po;


public class AjaxPo {
	
	private boolean success;
	private Integer code = 0;  //成功为0
 	private String msg;
	private Object obj;
	private long total = 0;
	
	public AjaxPo(){}
	
	public AjaxPo(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}
	
	public AjaxPo(boolean success, long total, Object obj) {
		this.success = success;
		this.total = total;
		this.obj = obj;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
	
	
}
