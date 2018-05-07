package com.xupt.ams.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.xupt.ams.dao.DeptDao;
import com.xupt.ams.vo.DeptInfo;
import com.xupt.service.DeptService;

/**
 * @author superYC
 * @date 2017年9月19日 --- 下午3:29:36
 *
 */
public class DeptServiceList implements DeptService {
	
	@Resource
	private DeptDao deptDao;

	@Override
	public List<DeptInfo> getDeptList() {
		return deptDao.getDeptList();
	}

}

