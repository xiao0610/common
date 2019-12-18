package com.xiaoyong.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xiaoyong.domain.SellHouse;

public interface SellHouseMapper {

	void add(SellHouse sh);

	List<SellHouse> getlist();

	SellHouse getbyid(@Param("id")Integer id);

	void update(SellHouse sh);

}
