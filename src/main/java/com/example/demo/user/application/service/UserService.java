package com.example.demo.user.application.service;

import java.util.Random;
import java.util.List;


import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.common.exception.BizException;
import com.example.demo.user.application.object.vo.UserVo;
import com.example.demo.user.core.domain.entity.User;
import com.example.demo.user.core.port_infra.persistent.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
//Request에 대해 어떤 처리를 할까
@Slf4j
@RequiredArgsConstructor

public class UserService {
	
	private final UserRepository userRepository;
	private final ModelMapper modelMapper;
	
	public List<User> getAllUser()
	{
		return userRepository.findAll();
	}
	
	public User getOneUser(Long id)
	{
		Optional<User> optionalUser = userRepository.findById(id);
		if(optionalUser.isPresent())
		{
			return optionalUser.get();
		}
		else
		{
			return null;
		}
	}
	
	public void insertUser(UserVo userVo)
	{

		User user = modelMapper.map(userVo, User.class);
		log.debug(user.toString());
		userRepository.save(user);
	}
	
	public void updateUser(UserVo userVo)
	{
		Optional<User> optionalUser = userRepository.findById(userVo.getId());
		if(!optionalUser.isPresent())
		{
			throw new BizException("0000","no user");
		}
		User targetUser = optionalUser.get();
		targetUser.update(userVo);
		userRepository.save(targetUser);
	}
	
	public void deleteUser(Long id)
	{
		Optional<User> optionalUser = userRepository.findById(id);
		if(!optionalUser.isPresent())
		{
			throw new BizException("0000","no user");
		}
		userRepository.delete(optionalUser.get());
	}

}
