package com.xiaoyong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import com.xiaoyong.dao.SellHouseMapper;
import com.xiaoyong.domain.SellHouse;
import com.xiaoyong.service.SellHouseService;
@Service
public class SellHouseServiceImpl implements SellHouseService{
	@Autowired
	private SellHouseMapper mapper;
	@Override
	public void add(SellHouse sh) {
		// TODO Auto-generated method stub
		mapper.add(sh);
	}
	@Override
	public PageInfo<SellHouse> getlist(Integer pagenum, Integer pagesize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pagenum, pagesize);
		List<SellHouse> list=mapper.getlist();
		PageInfo<SellHouse> info=new PageInfo<SellHouse>(list);
		return info;
	}
	@Override
	public SellHouse getbyid(Integer id) {
		// TODO Auto-generated method stub
		return mapper.getbyid(id);
	}
	@Override
	public void update(SellHouse sh) {
		// TODO Auto-generated method stub
		mapper.update(sh);
	}

}
