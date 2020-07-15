package com.example.demo.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.application.service.UserService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//Simple Logging Facade for JAVA의 줄임말
//프로그램에 대해서 발생할 수 있는 오류에 대해 디버깅하고 모니터링 하기 위해 로그를 기록하는 것 중 하나
@RestController
//Spring MVC Controller에 ResponseBody가 추가된 것
//JSON/XML 형태로 객체 데이터를 반환
@RequiredArgsConstructor
//의존성 주입
//초기화 되지 않은 final 필드나, @NonNull이 붙은 필드에 생성자를 주입해줌
@RequestMapping("/api/user-api")
//node.js에서의 Router와 비슷한 개념

public class UserController {
	
	private final UserService userService;
	//원칙적으로 Controller로 드어온 요청은 서비스로 분류되어 Back-end로 넘어간다.
	
	@GetMapping(value = "/users")
	//Controller에서 세부 Service로 넘길때 URL뒤에 붙이는 개념.
	//Nodejs에서의 Express 개념을 생각!
	@ApiOperation(value = "사용자 정보 전체 조회", httpMethod = "GET", notes = "사용자 정보 전체 조회 API.")
	//Swagger 상에서 노출될 때 현재 service의 이름이 value, 간단한 설명이 notes
	
	public ResponseEntity<Object> getAllUserInfoList()
	//RestController가 별도의 View를 제공하지 않기 때문에, 예외적인 상황에 대비해야 하는 세밀한 제어에 사용
	{
		return new ResponseEntity<>(new ResponseDto(userService.getAllUser()),HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/user/{id}")
	@ApiOperation(value = "사용자 정보 1건 조회", httpMethod = "GET", notes = "사용자 정보 1건 조회 API.")
	public ResponseEntity<Object> getUserInfo(@PathVariable Long id)
	{
		return new ResponseEntity<>(new ResponseDto(userService.getOneUser(id)),HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/user")
	@ApiOperation(value = "사용자 정보 1건 추가", httpMethod = "POST", notes = "사용자 정보 1건 추가 API.")
	public ResponseEntity<Object> insetUserInfo(@RequestBody UserVo userVo)
	{
		userService.(userVo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/user")
	@ApiOperation(value = "사용자 정보 1건 수정", httpMethod = "PUT", notes = "사용자 정보 1건 수정 API.")
	public ResponseEntity<Object> updateUserInfo(@RequestBody UserVo userVo)
	{
		userService.updateUser(userVo);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	@DeleteMapping(value = "/user")
	@ApiOperation(value = "사용자 정보 1건 삭제", httpMethod = "DELETE", notes = "사용자 정보 1건 삭제 API.")
	public ResponseEntity<Object> deleteUserInfo(Long id)
	{
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}

}
