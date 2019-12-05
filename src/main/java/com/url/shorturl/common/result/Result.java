package com.url.shorturl.common.result;

import com.fasterxml.jackson.annotation.JsonView;
import org.apache.commons.lang3.StringUtils;

public class Result<T> {
	
	@JsonView(ResultBase.class)
	private Integer code;
	
	@JsonView(ResultBase.class)
	private String msg;
	
	@JsonView(ResultBase.class)
	private T data;

	public Integer getCode() {
		return code;
	}

	public Result<T> setCode(Integer code) {
		this.code = code;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public Result<T> setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public T getData() {
		return data;
	}

	public Result<T> setData(T data) {
		this.data = data;
		return this;
	}

	private Result() {}
	
	
	public static <T> Result<T> ok(T data) {
		Result<T> result = new Result<T>();
		result.setCode(ResultCode.SUCCESS.getCode()).setMsg(ResultCode.SUCCESS.getMsg()).setData(data);
		return result;
	}
	
	public static <T> Result<T> fail(String failMsg) {
		Result<T> result = new Result<T>();
		result.setCode(ResultCode.FAIL.getCode()).setMsg(ResultCode.FAIL.getMsg()).setData(null);
		if (StringUtils.isNotBlank(failMsg)) {
			result.setMsg(failMsg);
		}
		return result;
	}
	
	public static <T> Result<T> fail(String failMsg, T data) {
		Result<T> result = new Result<T>();
		result.setCode(ResultCode.FAIL.getCode()).setMsg(ResultCode.FAIL.getMsg()).setData(data);
		if (StringUtils.isNotBlank(failMsg)) {
			result.setMsg(failMsg);
		}
		return result;
	}
	
	public static <T> Result<T> fail(String failMsg, int errorCode) {
		Result<T> result = new Result<T>();
		result.setCode(errorCode).setMsg(ResultCode.FAIL.getMsg()).setData(null);
		if (StringUtils.isNotBlank(failMsg)) {
			result.setMsg(failMsg);
		}
		return result;
	}
	
	
	public static <T> Result<T> todo() {
		Result<T> result = new Result<T>();
		result.setCode(ResultCode.FAIL.getCode()).setMsg("功能待完成").setData(null);
		return result;
	}
	
	
	public static <T> Result<T> mock(T data) {
		Result<T> result = new Result<T>();
		result.setCode(ResultCode.SUCCESS.getCode()).setMsg("Mock的数据").setData(data);
		return result;
	}
	
	
	public static Result<Object> unAuthorized(String errorMsg) {
		Result<Object> result = new Result<>();
		result.setCode(ResultCode.UNAUTHORIZED.getCode()).setMsg(ResultCode.UNAUTHORIZED.getMsg()).setData(null);
		if (StringUtils.isNotBlank(errorMsg)) {
			result.setMsg(errorMsg);
		}
		return result;
	}
	
	public static Result<Object> expireAuthorized(String errorMsg) {
		Result<Object> result = new Result<>();
		result.setCode(ResultCode.AUTHENTICATIONEXPIRE.getCode()).setMsg(ResultCode.AUTHENTICATIONEXPIRE.getMsg()).setData(null);
		if (StringUtils.isNotBlank(errorMsg)) {
			result.setMsg(errorMsg);
		}
		return result;
	}
	
	public static Result<Object> notFound(String errorMsg) {
		Result<Object> result = new Result<>();
		result.setCode(ResultCode.NOT_FOUND.getCode()).setMsg(ResultCode.NOT_FOUND.getMsg()).setData(null);
		if (StringUtils.isNotBlank(errorMsg)) {
			result.setMsg(errorMsg);
		}
		return result;
	}
	
	public static Result<Object> internalServerError(String errorMsg) {
		Result<Object> result = new Result<>();
		result.setCode(ResultCode.INTERNAL_SERVER_ERROR.getCode()).setMsg(ResultCode.INTERNAL_SERVER_ERROR.getMsg()).setData(null);
		if (StringUtils.isNotBlank(errorMsg)) {
			result.setMsg(errorMsg);
		}
		return result;
	}
	
	public static Result<Object> noAuthority(String errorMsg) {
		Result<Object> result = new Result<>();
		result.setCode(ResultCode.NO_AUTHORITY.getCode()).setMsg(ResultCode.NO_AUTHORITY.getMsg()).setData(null);
		if (StringUtils.isNotBlank(errorMsg)) {
			result.setMsg(errorMsg);
		}
		return result;
	}
	
	public static Result<Object> limitAccess(String errorMsg) {
		Result<Object> result = new Result<>();
		result.setCode(ResultCode.LIMIT_ACCESS.getCode()).setMsg(ResultCode.LIMIT_ACCESS.getMsg()).setData(null);
		if (StringUtils.isNotBlank(errorMsg)) {
			result.setMsg(errorMsg);
		}
		return result;
	}
	
	public static <T> Result<T> limitAccess(T data) {
		Result<T> result = new Result<>();
		result.setCode(ResultCode.LIMIT_ACCESS.getCode()).setMsg(ResultCode.LIMIT_ACCESS.getMsg()).setData(data);
		return result;
	}
	
	public static Result<Object> limitAccess() {
		Result<Object> result = new Result<>();
		result.setCode(ResultCode.LIMIT_ACCESS.getCode()).setMsg(ResultCode.LIMIT_ACCESS.getMsg()).setData(null);
		return result;
	}
	
	public boolean testServiceSuccess() {
		return this.code.intValue() >= 0;
	}
	
	
}



