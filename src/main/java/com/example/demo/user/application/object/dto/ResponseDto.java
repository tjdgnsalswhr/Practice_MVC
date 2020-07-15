package com.example.demo.user.application.object.dto;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpStatus;

import com.example.demo.user.application.object.vo.ErrorVo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class ResponseDto<T> {
	
	private T data;
	private ErrorVo erroVo;
	
	public ResponseDto(T data)
	{
		this(data, new ErrorVo);
	}
	
	public ResponseDto(ErrorVo errorVo)
	{
		this(null, errorVo);
	}
	
	public ResponseDto(CompletableFuture <String> canceledUpdateInventory, HttpStatus ok)
	{
		
	}
}
