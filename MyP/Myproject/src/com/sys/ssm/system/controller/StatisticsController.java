package com.sys.ssm.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sys.ssm.system.entity.Statistics;
import com.sys.ssm.system.service.StatisticsService;

@Controller
@RequestMapping(value="")
public class StatisticsController {
	
	@Autowired
	StatisticsService statisticsService;
	
	
	@RequestMapping(value="Visitor")
	public ModelAndView queryVisitors(){
		Statistics statistics = statisticsService.queryAndInsert();
		ModelAndView moeAndView = new ModelAndView();
		moeAndView.addObject("visitors", statistics.getVisitors());
		moeAndView.setViewName("ssm/ssm_login");
		return moeAndView;
	}
	

}
