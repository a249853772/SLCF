package com.sys.ssm.system.dao;

import java.util.List;

import com.sys.ssm.system.entity.Category;

public interface CategoryMapper {
	
	 public void add(Category category); 
     
	    public void delete(int id); 
	        
	    public Category get(int id); 
	      
	    public void update(Category category);  
	        
	    public List<Category> list();
	     
	    public int count(); 

}
