package com.huhao.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huhao.springboot.dao.CategoryDAO;
import com.huhao.springboot.pojo.Category;

@RestController
@RequestMapping("/testJSON")
public class TestJson {
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@GetMapping("/category")
    public List<Category> listCategory(@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<Category> page =categoryDAO.findAll(pageable);
        return page.getContent();
    }
     
    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable("id") int id) throws Exception {
        Category c= categoryDAO.getOne(id);
        System.out.println(c);
        return c;
    }
    @PutMapping("/category")
    public void addCategory(@RequestBody Category category) throws Exception {
        System.out.println("springboot接受到浏览器以JSON格式提交的数据："+category);
    }

}
