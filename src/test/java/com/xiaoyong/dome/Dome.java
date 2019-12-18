package com.xiaoyong.dome;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.xiaoyong.common.utils.StreamUtil;
import com.xiaoyong.dao.EsDao;
import com.xiaoyong.dao.SellHouseMapper;
import com.xiaoyong.domain.SellHouse;
import com.xiaoyong.service.impl.RedisSellHouseServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class Dome {
	@Autowired
	private EsDao dao;
	@Autowired
	private SellHouseMapper sellHouseMapper;
//	@Autowired
//	private RedisSellHouseServiceImpl redis;
//	@Autowired
//	private KafkaTemplate<String, String> kafkaTemplate;
//	@Autowired
//	private SellHouseMapper mapper;
//	@Autowired
//	private RedisTemplate redisTemplate;
//	
//
//
//	@Test
//	public void add() {
//		String string = redis.getString("id24");
//		SellHouse sh = JSON.parseObject(string, SellHouse.class);
//		System.out.println(sh);
//		mapper.add(sh);
//
//	}
//
//	@Test
//	public void addtxt() throws Exception {
//		File file = new File("C:\\Users\\肖咏\\Desktop\\大数据系-11月-专高2-《高性能架构》-第4周月考（技能）-B卷-卖房.txt");
//		
//		List<String> list = StreamUtil.readLine(new FileInputStream(file));
//		for (String str : list) {
//			String[] s = str.split("	");
//			if (!(s[0].equals("编号"))) {
//				SellHouse sh = new SellHouse();
//				sh.setId(Integer.parseInt(s[0]));
//				sh.setKeywords(s[1]);
//				sh.setDescription(s[2]);
//				sh.setProvider(s[3]);
//				sh.setTitle(s[4]);
//				sh.setHouseType(s[5]);
//				sh.setArea(s[6]);
//				sh.setToward(s[7]);
//				sh.setStory(s[8]);
//				sh.setAddress(s[9]);
//				sh.setSellPrice(s[10]);
//				sh.setUnitPrice(s[11]);
//				sh.setPublishTime(s[12]);
//				sh.setRmk(s[13]);
//				sh.setCheckStatus(s[14]);
//				String jsonString = JSON.toJSONString(sh);
//				redis.addJSON("id" + sh.getId(), jsonString);
//				kafkaTemplate.send("1706d", "id" + sh.getId());
//			}
//		}
//	}
	@Test
	public void esadd() {
		List<SellHouse> list = sellHouseMapper.getlist();
		for (SellHouse sh : list) {
			if(sh.getCheckStatus().equals("审核通过")) {
				dao.save(sh);
			}
		}
	}

}
