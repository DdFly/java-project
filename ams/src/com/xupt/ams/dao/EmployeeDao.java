package com.xupt.ams.dao;

import java.util.List;
import java.util.Map;

import com.xupt.ams.vo.EmployeeInfo;

/**
 * @author superYC
 * @date 2017年9月16日 --- 下午1:41:44
 * 员工数据库访问层接口
 */
public interface EmployeeDao {

	/*
	 * 根据员工编号，查找用户信息
	 */
	EmployeeInfo getEmpInfoById(Integer empId);

	/*
	 * 获取所有员工的信息
	 */
	List<EmployeeInfo> getEmployeeList();

	/*
	 * 获取每页的人员个数
	 */
	List<EmployeeInfo> getCurrentEmps(Map<String, Object> condition);

	/*
	 * 获取员工条数
	 */
	int getPageCount();

	/*
	 * 添加员工
	 */
	int addEmpInfo(EmployeeInfo empInfo);

	/*
	 * 根据员工编号，删除员工信息
	 */
	void deleteEmpInfoById(Integer empId);

	/*
	 * 更新用户信息
	 */
	void updateEmpInfoByEmpId(EmployeeInfo empInfo);

}

