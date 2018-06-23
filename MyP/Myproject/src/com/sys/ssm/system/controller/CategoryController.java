package com.sys.ssm.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sys.ssm.system.entity.Category;
import com.sys.ssm.system.service.CategoryService;

@Controller
@RequestMapping("")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("listCategory")
	public ModelAndView listCategory() {
		ModelAndView mv = new ModelAndView();
		List<Category> cs = categoryService.list();
		mv.addObject("cs",cs);
		mv.setViewName("listCategory");
		return mv;
	}
	
}
