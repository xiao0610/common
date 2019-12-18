package com.xiaoyong.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.xiaoyong.domain.SellHouse;

public interface SellHouseService {

	void add(SellHouse sh);

	PageInfo<SellHouse> getlist(Integer pagenum, Integer pagesize);

	SellHouse getbyid(Integer id);

	void update(SellHouse sh);

}
