package com.example.demo.user.application.object.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor

public class ErrorVo {
	private String errorCode;
	private String errorMessage;
	
	public ErrorVo()
	{
		this("0000","");
	}

}
