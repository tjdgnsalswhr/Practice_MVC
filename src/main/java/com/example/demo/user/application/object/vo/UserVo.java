package com.example.demo.user.application.object.vo;

import io.swagger.annotations.ApiModelProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class UserVo {
	
	private Long id; //사용자 id
	
	@ApiModelProperty(example = "이성훈")
	private String name;
	
	@ApiModelProperty(example = "123qwe")
	private String password;
	
	@ApiModelProperty(example = "27")
	private int age;
	
	@ApiModelProperty(example = "경기도 용인시 수지구")
	private String address;
	
	@ApiModelProperty(example = "940320")
	private String birth;
	
	
	@Builder
	public UserVo(Long id, String name, String password, int age, String address, String birth)
	{
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.address = address;
		this.birth = birth;
	}
	

}
