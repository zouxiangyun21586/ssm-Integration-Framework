package com.yr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yr.entity.Department;
import com.yr.mapper.Department_mybits;
import com.yr.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	public Department_mybits department_mybits;
	
	@Override
	public List<Department> pageQuery() {
		List<Department> listDepartment = department_mybits.pageQuery();
		return listDepartment;
	}

	@Transactional
	@Override
	public void insert(Department department) throws Exception{
		department_mybits.insert(department);
		int i = 1 / 0;
		department_mybits.insert(department);
	}

}
