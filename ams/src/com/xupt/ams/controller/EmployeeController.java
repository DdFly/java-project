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
 * @date 2017��9��16�� --- ����12:36:51
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
	 * ����Ա����ţ������û���Ϣ
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
	 * ��ȡ����Ա������Ϣ
	 */
	@RequestMapping(path = "/getEmpList")
	public String getEmployeeList(ModelMap model) {
		List<EmployeeInfo> empList = employeeService.getEmployeeList();
		//��ȡԱ������ҳ��
		Integer pageCount = this.employeeService.getPageCount();
		if(pageCount != null){
			model.put("pageCount", pageCount);
		}
		return "empList";
	}
	
	/*
	 * Ԥ���Ա����Ϣ
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
	 * ���Ա��
	 */
	@RequestMapping(path="/addEmpInfo")
	public String addEmpInfo(HttpServletRequest request,EmployeeInfo empInfo){
		//��ȡԱ����ְλ��Ϣ
		String position = Utils.getParameter(request, "position", String.class);
		if(empInfo != null){
			if(position.equals("����Ա")){
				empInfo.setEmp_type(1);
			}else if(position.equals("���Ա")){
				empInfo.setEmp_type(2);
			}else if(position.equals("���Ա")){
				empInfo.setEmp_type(3);
			}else{	//����Ա��
				empInfo.setEmp_type(4);
			}
		}
		boolean result = employeeService.addEmpInfo(empInfo);
		return "redirect:/empployee/getEmpList";
	}
	
	/*
	 * ����Ա����ţ�ɾ��Ա��
	 */
	@RequestMapping("/deleteEmpInfo/{emp_id}")
	public String deleteEmpInfoById(@PathVariable Integer empId){
		if(empId != null){
			employeeService.deleteEmpInfoById(empId);
		}
		return "redirect:/empployee/getEmpList";
	}
	
	/*
	 * Ԥ����Ա����Ϣ
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
	 * �����û���Ϣ
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
	 * Ա����ҳ(���·�ҳ)
	 */
	@RequestMapping(path = "/employeePagging")
	public String employeePagging(HttpServletRequest request, ModelMap model) {
		// ��ȡ�û���ѡ��ҳ���͡���ǰҳ������
		String dir = Utils.getParameter(request, "dir", String.class);
		Integer currentPage = Utils.getParameter(request, "currentPage", Integer.class);

		int pageNum = 1; // ����һ����ǰ��ҳ����
		int pageCount = (int) request.getSession().getAttribute("pageCount");
		if (currentPage != null) {
			pageNum = currentPage;
			if (dir.equals("pre")) {
				pageNum--;
			} else if (dir.equals("next")) {
				pageNum++;
			}
			// �߽��ж�
			if (pageNum < 1) {
				pageNum = 1;
			}
			if (pageNum > pageCount) {
				pageNum = pageCount;
			}
		}
		// ����ҵ���߼��㷽��
		List<EmployeeInfo> employeeList = this.employeeService.getCurrentEmps(pageNum);
		// �����ݷ�������ģ����
		model.put("employeeList", employeeList);
		model.put("currentPage", pageNum);
		model.put("pageCount", pageCount);
		return "home/getEmployees";
	}
}
