package com.huhao.springboot.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huhao.springboot.dao.CategoryDAO;
import com.huhao.springboot.pojo.Category;
import com.huhao.springboot.pojo.PojoPage;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/category")
public class CagtegoryController {

	
	@Autowired
	CategoryDAO categoryDAO;
	
	@ApiOperation(value = "获取用户列表" , notes = "")
	@ApiImplicitParams({
	 @ApiImplicitParam(name = "start", value = "起始页", required = true, dataType = "int",paramType="query"),
	 @ApiImplicitParam(name = "size", value = "大小", required = true, dataType = "int",paramType="query")
	})@RequestMapping(value = "",method = RequestMethod.GET)
	public Page<Category> listCategory(@RequestParam int start,@RequestParam int size){
		start = start<0?0:start;
		Sort sort = new Sort(Sort.Direction.DESC,"id");
		Pageable pageable = new PageRequest(start, size,sort);
		Page<Category> page = categoryDAO.findAll(pageable);
		return page;
	}
	

	@ApiOperation(value="创建用户", notes="根据Category对象创建用户")
    @ApiImplicitParam(name = "category", value = "用户详细实体category", required = true, dataType = "Category")
    @RequestMapping(value="", method=RequestMethod.POST)
    public String postUser(@RequestBody Category category) {
        categoryDAO.save(category);
        return "success";
    }
	
	 @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int" ,paramType="path")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Category getUser(@PathVariable int id) {
        return categoryDAO.findOne(id);
    }
	 
	 
	 @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
    		@ApiImplicitParam(name = "id", value = "用户ID", required = false, dataType = "int",paramType="path"),
            @ApiImplicitParam(name = "category", value = "用户详细实体category", required = true, dataType = "Category")
    })
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser( @RequestBody Category category) {
	 	categoryDAO.save(category);
        return "success";
    }
	 
 
	@ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int",paramType = "path")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable int id) {
        categoryDAO.delete(id);
        return "success";
    }
	
}
