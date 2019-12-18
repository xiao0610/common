package com.xiaoyong.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
@Service
public class RedisSellHouseServiceImpl {
	@Autowired
	private RedisTemplate redis;
	public void addJSON(String key, String jsonString) {
		// TODO Auto-generated method stub
		redis.opsForValue().set(key, jsonString);
	}
	public String getString(String key) {
		// TODO Auto-generated method stub
		return (String) redis.opsForValue().get(key);
	}
	public void del(String key) {
		// TODO Auto-generated method stub
		redis.delete(key);
	}
	
}
