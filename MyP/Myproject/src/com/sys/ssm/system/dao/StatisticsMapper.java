package com.sys.ssm.system.dao;

import com.sys.ssm.system.entity.Statistics;

public interface StatisticsMapper {
	
	
	public int insert(Statistics statistics);
	
	public Statistics select();
	
	public int update(Statistics statistics);

}
