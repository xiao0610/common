package com.xiaoyong.kafka;

import java.util.Date;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.listener.MessageListener;

import com.alibaba.fastjson.JSON;
import com.xiaoyong.common.utils.DateUtil;
import com.xiaoyong.dao.EsDao;
import com.xiaoyong.domain.PerfRecord;
import com.xiaoyong.domain.SellHouse;
import com.xiaoyong.service.SellHouseService;
import com.xiaoyong.service.impl.RedisSellHouseServiceImpl;

public class MsgListener implements MessageListener<String, String> {
	@Autowired
	private RedisSellHouseServiceImpl redis;
	@Autowired
	private SellHouseService houseService;
	@Autowired
	private EsDao dao;

	@Override
	public void onMessage(ConsumerRecord<String, String> data) {
		// TODO Auto-generated method stub
		String key = data.value();
		if(key.startsWith("审核")) {
			key=key.substring(2, key.length());
			SellHouse sh = JSON.parseObject(key,SellHouse.class);
			dao.save(sh);
		}else {
			PerfRecord pr = new PerfRecord();
			Date startTime = new Date();
			pr.setStartTime(startTime);
			String jsonstring = redis.getString(key);
			SellHouse sh = JSON.parseObject(jsonstring, SellHouse.class);
			System.out.println(sh);
			pr.setId(sh.getId());
			houseService.add(sh);
			Date endTime = new Date();
			pr.setEndTime(endTime);
			System.out.println(startTime+"---"+endTime);
			redis.del(key);
		}
	}

}
