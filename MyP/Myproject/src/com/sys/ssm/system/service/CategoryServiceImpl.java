package com.sys.ssm.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sys.ssm.system.dao.CategoryMapper;
import com.sys.ssm.system.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryMapper CategoryMapper;

	@Override
	public List<Category> list() {
		List<Category> categories = CategoryMapper.list();
		return categories;
	}

}
