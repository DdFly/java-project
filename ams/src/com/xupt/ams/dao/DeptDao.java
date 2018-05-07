package com.xupt.ams.dao;

import java.util.List;

import com.xupt.ams.vo.DeptInfo;

/**
 * @author superYC
 * @date 2017年9月16日 --- 下午1:39:59
 * 部门数据库访问层接口
 */
public interface DeptDao {

	/*
	 * 获取部门列表
	 */
	List<DeptInfo> getDeptList();

}

