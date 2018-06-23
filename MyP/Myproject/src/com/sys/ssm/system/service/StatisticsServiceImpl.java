package com.sys.ssm.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sys.ssm.system.dao.StatisticsMapper;
import com.sys.ssm.system.entity.Statistics;

@Service
@Transactional(readOnly = false)
public class StatisticsServiceImpl implements StatisticsService {
	
	@Autowired
	StatisticsMapper statisticsMapper;

	@Override
	public Statistics queryAndInsert() {
		// TODO Auto-generated method stub
		Statistics statistics= statisticsMapper.select();
		int vitor  = statistics.getVisitors()+1;
		statistics.setVisitors(vitor);
		statisticsMapper.update(statistics);
		return statistics;
	}

}
