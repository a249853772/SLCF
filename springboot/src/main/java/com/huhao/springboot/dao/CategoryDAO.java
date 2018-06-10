package com.huhao.springboot.dao;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.huhao.springboot.pojo.Category;

@CacheConfig(cacheNames = "categorys")
public interface CategoryDAO extends JpaRepository<Category, Integer>{
	
	
	@Cacheable
	Category findByName(String name);

}
