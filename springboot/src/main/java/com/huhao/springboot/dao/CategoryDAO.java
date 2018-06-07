package com.huhao.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huhao.springboot.pojo.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer>{
	
	

}
