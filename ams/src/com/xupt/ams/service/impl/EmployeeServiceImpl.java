package com.xupt.ams.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xupt.ams.common.Constants;
import com.xupt.ams.dao.EmployeeDao;
import com.xupt.ams.vo.EmployeeInfo;
import com.xupt.service.EmployeeService;

/**
 * @author superYC
 * @date 2017年9月19日 --- 上午9:35:46
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Resource
	private EmployeeDao employeeDao;

	@Override
	public EmployeeInfo getEmpInfoById(Integer empId) {
		return employeeDao.getEmpInfoById(empId);
	}

	@Override
	public List<EmployeeInfo> getEmployeeList() {
		return employeeDao.getEmployeeList();
	}

	@Override
	public List<EmployeeInfo> getCurrentEmps(int pageNum) {
		List<EmployeeInfo> empList = null;
		Map<String, Object> condition = new HashMap<String, Object>();
		try {
			// 设置起始编号，以及每页的数量
			condition.put("startRownum", (pageNum - 1) * Constants.PAGE_EMPLOYEE_NUM);
			condition.put("pageEmpNum", Constants.PAGE_EMPLOYEE_NUM);

			empList = this.employeeDao.getCurrentEmps(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
	}

	@Override
	public Integer getPageCount() {
		int recordCount = 0;
		try {
			recordCount = this.employeeDao.getPageCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (recordCount + (Constants.PAGE_EMPLOYEE_NUM - 1)) / Constants.PAGE_EMPLOYEE_NUM;
	}

	@Override
	public boolean addEmpInfo(EmployeeInfo empInfo) {
		int count = 0;
		if (empInfo != null) {
			count = employeeDao.addEmpInfo(empInfo);
		}
		return (count > 0 ? true : false);
	}

	@Override
	public void deleteEmpInfoById(Integer empId) {
		if (empId != null) {
			employeeDao.deleteEmpInfoById(empId);
		}
	}

	@Override
	public boolean updateEmpInfoByEmpId(EmployeeInfo empInfo) {
		boolean result = true;
		try {
			this.employeeDao.updateEmpInfoByEmpId(empInfo);
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

}
