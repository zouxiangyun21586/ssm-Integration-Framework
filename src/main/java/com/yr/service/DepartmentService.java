package com.yr.service;

import java.util.List;

import com.yr.entity.Department;

public interface DepartmentService {
	
	public List<Department> pageQuery(); // 分页查询
	
	public void insert(Department department) throws Exception;
}
