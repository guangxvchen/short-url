package com.url.shorturl.common.result;

public enum ResultCode {
	
	SUCCESS(0, "成功"), FAIL(-1, "失败"), UNAUTHORIZED(-2, "未认证"), NOT_FOUND(-3, "没有发现相关资源"), INTERNAL_SERVER_ERROR(-4, "服务器内部错误"), AUTHENTICATIONEXPIRE(-5, "token过期"), NO_AUTHORITY(-6, "没有相关权限"), LIMIT_ACCESS(-7, "限制访问，请重试");
	
	ResultCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	private Integer code;
	
	private String msg;
	
	public int getCode() {
		 return this.code;
	}

	public String getMsg() {
		return msg;
	}
	
}
