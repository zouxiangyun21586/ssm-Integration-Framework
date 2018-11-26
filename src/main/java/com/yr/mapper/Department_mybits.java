package com.yr.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yr.entity.Department;

/**
 * mybatis接口
 * 
 * @author zxy
 * 2018年11月3日 上午10:39:47
 *
 */
@Repository
public interface Department_mybits {
	
	public List<Department> pageQuery(); // 分页查询
	
	public void insert(Department department);
}
