package com.example.demo.common.config;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonBean {
	@Bean
	public ModelMapper modelMapper()
	{
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
			.setPropertyCondition(Conditions.isNotNull())
			//null일 경우 복사하지 않도록 설정
			.setFieldMatchingEnabled(true)
			//setter 없이 맵핑 되도록 설정
			.setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
			//setter 없이 맵핑 되도록 설정
			.setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}

}
