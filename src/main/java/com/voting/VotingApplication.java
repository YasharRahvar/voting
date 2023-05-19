package com.voting;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;


//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication
@EnableCaching

public class VotingApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(VotingApplication.class);

	@Autowired
	private StringRedisTemplate template;


	public static void main(String[] args) {
		SpringApplication.run(VotingApplication.class, args);
	}


	public void run(String... args) {
		ValueOperations<String, String> ops = this.template.opsForValue();
		String key = "testkey";
		if(!this.template.hasKey(key)){
			ops.set(key, "Hello World");
			LOGGER.info("Add a key is done");
		}
		LOGGER.info("Return the value from the cache: {}", ops.get(key));
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
