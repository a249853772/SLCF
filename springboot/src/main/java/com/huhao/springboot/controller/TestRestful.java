package com.huhao.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.huhao.springboot.dao.CategoryDAO;
import com.huhao.springboot.pojo.Category;

@Controller
public class TestRestful {
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@GetMapping("/category")
	public String list(Model model,
			@RequestParam(value="start",defaultValue="0") int start,
			@RequestParam(value="size",defaultValue="5") int size
			)throws Exception{
		start = start<0?0:start;
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		Pageable pageable = new PageRequest(start, size, sort);
		Page<Category> page = categoryDAO.findAll(pageable);
		model.addAttribute("page", page);
		return "testDao/listCategoryRestful";
	}
	
	@PutMapping("/category")
	public String add(Category c) throws Exception{
		categoryDAO.save(c);
		return "redirect:/category";
	}
	
	@DeleteMapping("/category")
	public String delete(Category c) throws Exception{
		categoryDAO.delete(c);
		return "redirect:/category";
	}
	
	@PostMapping("/category/{id}")
	public String update(Category c) throws Exception{
		categoryDAO.save(c);
		return "redirect:/category";
	}
	
	@GetMapping("/category/{id}")
	public String getone(@PathVariable(value="id") int id,Model model) throws Exception{
		Category category = categoryDAO.getOne(id);
		model.addAttribute("c", category);
		return "testDao/editCategory";
	}

	@RequestMapping("/testJSON/test")
	public String getTestJson(){
		return "testDao/testJson";
	}
}
