package com.xiaoyong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.xiaoyong.dao.EsDao;
import com.xiaoyong.domain.SellHouse;
import com.xiaoyong.service.SellHouseService;
import com.xiaoyong.utiles.ESUtils;

@Controller
public class SellHouseController {
	@Autowired
	private SellHouseService service;
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	@RequestMapping("list")
	public String list(Model m, @RequestParam(defaultValue = "1") Integer pagenum,
			@RequestParam(defaultValue = "5") Integer pagesize, String name) {
		PageInfo<SellHouse> info = null;
		if (name!=null && name!="") {
			AggregatedPage<?> selectObjects = ESUtils.selectObjects(elasticsearchTemplate, SellHouse.class, pagenum,
					pagesize, new String[] { "keywords" }, name);
			List<?> list = selectObjects.getContent();
			Integer p = (int) selectObjects.getTotalElements();
			Integer pages =(p-1)/pagesize+1;
			m.addAttribute("list", list);
			m.addAttribute("pages",pages);
		} else {
			info = service.getlist(pagenum, pagesize);
			m.addAttribute("list", info.getList());
			int pages = info.getPages();
			m.addAttribute("pages", pages);
		}
		m.addAttribute("name", name);
		m.addAttribute("pagenum", pagenum);
		return "list";
	}
	@RequestMapping("toupdate")
	public String toupdate(Model m,Integer id) {
		SellHouse sh=service.getbyid(id);
		System.out.println(sh);
		m.addAttribute("obj", sh);
		return "update";
	}
	@PostMapping("update")
	public String update(SellHouse sh) {
		service.update(sh);
		if(sh.getCheckStatus().equals("审核通过")) {
			String jsonString = JSON.toJSONString(sh);
			kafkaTemplate.send("1706d","审核"+jsonString);
		}
		return "redirect:/list";
	}
}
