package com.example.demo.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
//Getter 코드가 존재하지만 보이지 않게 하여 전체 코드의 가독성을 높인다
@Setter
//Setter 코드를 추가해주지만 보이지 않게 하여 전체 코드의 가독성을 높인다
public class BizException extends RuntimeException{
	
	private static final long serialVersionID = 1L;
	
	private String code;
	private String message;
	
	public BizException(String message)
	{
		this("8090", message);
	}
	
	public BizException(String code, String message)
	{
		this(code,null,message);
	}
	
	public BizException(String code, Throwable cause, String message)
	{
		super(cause != null ? cause.getMessage() : code, cause);
		
		this.code = code;
		this.message = message;
	}
	

}
