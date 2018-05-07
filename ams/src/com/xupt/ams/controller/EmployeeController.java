package com.xupt.ams.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xupt.ams.common.Utils;
import com.xupt.ams.vo.DeptInfo;
import com.xupt.ams.vo.EmployeeInfo;
import com.xupt.service.DeptService;
import com.xupt.service.EmployeeService;

/**
 * @author superYC
 * @date 2017年9月16日 --- 下午12:36:51
 *
 */
@Controller
@RequestMapping(path = "/employee")
public class EmployeeController {

	@Resource
	private EmployeeService employeeService;
	@Resource
	private DeptService deptService;

	/*
	 * 根据员工编号，查找用户信息
	 */
	@RequestMapping(path = "/getEmpInfo/{empId}")
	public EmployeeInfo getEmpInfoById(@PathVariable Integer empId) {
		EmployeeInfo empInfo = null;
		if (empId != null) {
			empInfo = employeeService.getEmpInfoById(empId);
		}
		System.out.println(empInfo);
		return empInfo;
	}

	/*
	 * 获取所有员工的信息
	 */
	@RequestMapping(path = "/getEmpList")
	public String getEmployeeList(ModelMap model) {
		List<EmployeeInfo> empList = employeeService.getEmployeeList();
		//获取员工的总页数
		Integer pageCount = this.employeeService.getPageCount();
		if(pageCount != null){
			model.put("pageCount", pageCount);
		}
		return "empList";
	}
	
	/*
	 * 预添加员工信息
	 */
	@RequestMapping("/preAddEmpInfo")
	public String preAddEmpInfo(ModelMap model){
		List<DeptInfo> deptList = deptService.getDeptList();
		if(deptList != null){
			model.put("deptList",deptList);
		}
		return "addEmp";
	}
	
	/*
	 * 添加员工
	 */
	@RequestMapping(path="/addEmpInfo")
	public String addEmpInfo(HttpServletRequest request,EmployeeInfo empInfo){
		//获取员工的职位信息
		String position = Utils.getParameter(request, "position", String.class);
		if(empInfo != null){
			if(position.equals("管理员")){
				empInfo.setEmp_type(1);
			}else if(position.equals("审计员")){
				empInfo.setEmp_type(2);
			}else if(position.equals("会计员")){
				empInfo.setEmp_type(3);
			}else{	//其他员工
				empInfo.setEmp_type(4);
			}
		}
		boolean result = employeeService.addEmpInfo(empInfo);
		return "redirect:/empployee/getEmpList";
	}
	
	/*
	 * 根据员工编号，删除员工
	 */
	@RequestMapping("/deleteEmpInfo/{emp_id}")
	public String deleteEmpInfoById(@PathVariable Integer empId){
		if(empId != null){
			employeeService.deleteEmpInfoById(empId);
		}
		return "redirect:/empployee/getEmpList";
	}
	
	/*
	 * 预更新员工信息
	 */
	@RequestMapping(path="/preUpdateEmpInfo/{emp_id}")
	public String preUpdateEmpInfo(@PathVariable Integer emp_id,ModelMap model){
		EmployeeInfo empInfo = this.employeeService.getEmpInfoById(emp_id);
		if(empInfo != null){
			model.put("empInfo", empInfo);
		}
		return "home/people";
	}
	
	/*
	 * 更新用户信息
	 */
	@RequestMapping(path="/updateEmpInfo")
	public String updateEmpInfo(HttpServletRequest request,EmployeeInfo empInfo){
		
		boolean result = this.employeeService.updateEmpInfoByEmpId(empInfo);
		if(result){
			return "redirect:/employee/getEmployees";
		}else{
			return "employee/failure";
		}
	}

	/*
	 * 员工分页(上下分页)
	 */
	@RequestMapping(path = "/employeePagging")
	public String employeePagging(HttpServletRequest request, ModelMap model) {
		// 获取用户所选翻页类型、当前页数参数
		String dir = Utils.getParameter(request, "dir", String.class);
		Integer currentPage = Utils.getParameter(request, "currentPage", Integer.class);

		int pageNum = 1; // 定义一个当前的页码数
		int pageCount = (int) request.getSession().getAttribute("pageCount");
		if (currentPage != null) {
			pageNum = currentPage;
			if (dir.equals("pre")) {
				pageNum--;
			} else if (dir.equals("next")) {
				pageNum++;
			}
			// 边界判断
			if (pageNum < 1) {
				pageNum = 1;
			}
			if (pageNum > pageCount) {
				pageNum = pageCount;
			}
		}
		// 调用业务逻辑层方法
		List<EmployeeInfo> employeeList = this.employeeService.getCurrentEmps(pageNum);
		// 将数据放入数据模型中
		model.put("employeeList", employeeList);
		model.put("currentPage", pageNum);
		model.put("pageCount", pageCount);
		return "home/getEmployees";
	}
}
