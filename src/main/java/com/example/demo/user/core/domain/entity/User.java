package com.example.demo.user.core.domain.entity;

import lombok.AccessLevel;
import javax.persistence.*;
import com.example.demo.user.application.object.vo.UserVo;
import lombok.*;

@Table(name = "users")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String password;
	private String name;
	private int age;
	private String address;
	private String birth;
	
	
	@Builder
	User(UserVo userVo, int tmpStock)
	{
		this.name = userVo.getName();
		this.age = userVo.getAge();
		this.address = userVo.getAddress();
		this.birth = userVo.getBirth();
	}
	
	public void update(UserVo userVo)
	{
		this.name = userVo.getName();
		this.age = userVo.getAge();
		this.address = userVo.getAddress();
		this.birth = userVo.getBirth();
	}
	
}
