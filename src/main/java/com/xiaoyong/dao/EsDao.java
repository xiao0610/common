package com.xiaoyong.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.xiaoyong.domain.SellHouse;

public interface EsDao extends ElasticsearchRepository<SellHouse, Integer>{

}
