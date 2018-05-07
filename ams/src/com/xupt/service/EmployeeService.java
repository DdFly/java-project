package com.xupt.service;

import java.util.List;

import com.xupt.ams.vo.EmployeeInfo;

/**
 * @author superYC
 * @date 2017年9月16日 --- 下午1:41:44
 * 员工业务逻辑层接口
 */
public interface EmployeeService {

	/*
	 * 根据员工编号，查找用户信息
	 */
	EmployeeInfo getEmpInfoById(Integer emp_id);

	/*
	 * 获取所有员工的信息
	 */
	List<EmployeeInfo> getEmployeeList();

	/*
	 * 获取一页中人员的信息
	 */
	List<EmployeeInfo> getCurrentEmps(int pageNum);
	
	/*
	 * 获取人员的总页数
	 */
	Integer getPageCount();

	/*
	 * 添加员工
	 */
	boolean addEmpInfo(EmployeeInfo empInfo);

	/*
	 * 根据员工编号，删除员工
	 */
	void deleteEmpInfoById(Integer empId);

	/*
	 * 更新用户信息
	 */
	boolean updateEmpInfoByEmpId(EmployeeInfo empInfo);

}

