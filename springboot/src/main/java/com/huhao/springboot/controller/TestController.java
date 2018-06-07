package com.huhao.springboot.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.huhao.springboot.dao.CategoryDAO;
import com.huhao.springboot.pojo.Category;

@Controller
public class TestController {

	@Autowired 
	CategoryDAO categoryDao;
	
	@RequestMapping("/hi")
	public String hello(Model model) throws Exception{
		model.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
//		 if(true){
//	            throw new Exception("some exception");
//	        }
		return "hello";
	}
	
	
	@RequestMapping("/list")
	public String getList(Model m)throws Exception{
		List<Category> categories = categoryDao.findAll();
		m.addAttribute("cs", categories);
		return "testDao/listCategory";
	}
	
	@RequestMapping("/add")
	public String add(Model m,Category category)throws Exception{
		categoryDao.save(category);
		return "redirect:listC";
	}
	
	@RequestMapping("/delete")
	public String delete(Model m,Category category)throws Exception{
		categoryDao.delete(category);
		return "redirect:listC";
	}
	
	@RequestMapping("/update")
	public String update(Model m,Category category)throws Exception{
		categoryDao.save(category);
		return "redirect:listC";
	}
	
	@RequestMapping("/editCategory")
	public String editCategory(int id,Model m)throws Exception{
		Category c = categoryDao.getOne(id);
		m.addAttribute("c",c);
		return "redirect:listC";
	}
	
	@RequestMapping("/listC")
	public String listC(Model m,
			@RequestParam(value="start",defaultValue = "0") int start,
			@RequestParam(value="size",defaultValue = "5") int size
			)throws Exception{
		start = start<0?0:start;
		Sort sort = new Sort(Sort.Direction.DESC,"id");
		Pageable pageable = new  PageRequest(start,size,sort);
		Page<Category> page = categoryDao.findAll(pageable);
		m.addAttribute("page",page);
		return "testDao/listC";
	}
	
	
}
