package com.xupt.service;

import java.util.List;

import com.xupt.ams.vo.DeptInfo;

/**
 * @author superYC
 * @date 2017年9月16日 --- 下午1:39:59
 * 部门业务逻辑层接口
 */
public interface DeptService {

	/*
	 * 获取部门列表
	 */
	List<DeptInfo> getDeptList();

}

