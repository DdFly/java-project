package com.xupt.ams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xupt.ams.vo.DeptInfo;
import com.xupt.service.DeptService;

/**
 * @author superYC
 * @date 2017年9月16日 --- 下午12:37:42
 *
 */
@Controller
@RequestMapping("/dept")
public class DeptController {
	
	@Autowired
	private DeptService deptService;

	public List<DeptInfo> getDeptList(){
		List<DeptInfo> deptList = deptService.getDeptList();
		return deptList;
	}
}

