package com.yr.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yr.entity.Department;
import com.yr.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	public DepartmentService departmentService;

	@RequestMapping(value = "/jsp", method = RequestMethod.GET)
	public String queryTest() {
		return "query";
	}

	@ResponseBody
	@RequestMapping(value = "/department", method = RequestMethod.GET)
	public List<Department> query() {
		return departmentService.pageQuery();
	}
	
	@RequestMapping(value = "/department", method = RequestMethod.POST)
	public String insert(Map<String,Object> map) {
		try {
			Department department = new Department();
			department.setName("菜鸟部");
			departmentService.insert(department);
			return "query";
		} catch (Exception e) {
			map.put("error", e.getMessage());
			return "query";
		}
	}
	
}
