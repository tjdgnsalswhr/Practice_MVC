package com.example.demo.common.exception;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.user.application.object.dto.ResponseDto;
import com.example.demo.user.application.object.vo.ErrorVo;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = BizException.class)
	public ResponseEntity<Object> bizExceptionHandler(BizException e)
	{
		ErrorVo errorVo = ErrorVo.builder()
				.errorCode(e.getCode())
				.errorMessage(e.getMessage())
				.build();
		return new ResponseEntity<>(new ResponseDto(errorVo), HttpStatus.OK);
	}

}
