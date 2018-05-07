package com.xupt.service;

import java.util.List;

import com.xupt.ams.vo.EmployeeInfo;

/**
 * @author superYC
 * @date 2017��9��16�� --- ����1:41:44
 * Ա��ҵ���߼���ӿ�
 */
public interface EmployeeService {

	/*
	 * ����Ա����ţ������û���Ϣ
	 */
	EmployeeInfo getEmpInfoById(Integer emp_id);

	/*
	 * ��ȡ����Ա������Ϣ
	 */
	List<EmployeeInfo> getEmployeeList();

	/*
	 * ��ȡһҳ����Ա����Ϣ
	 */
	List<EmployeeInfo> getCurrentEmps(int pageNum);
	
	/*
	 * ��ȡ��Ա����ҳ��
	 */
	Integer getPageCount();

	/*
	 * ���Ա��
	 */
	boolean addEmpInfo(EmployeeInfo empInfo);

	/*
	 * ����Ա����ţ�ɾ��Ա��
	 */
	void deleteEmpInfoById(Integer empId);

	/*
	 * �����û���Ϣ
	 */
	boolean updateEmpInfoByEmpId(EmployeeInfo empInfo);

}

