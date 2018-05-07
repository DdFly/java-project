package com.xupt.ams.dao;

import java.util.List;
import java.util.Map;

import com.xupt.ams.vo.EmployeeInfo;

/**
 * @author superYC
 * @date 2017��9��16�� --- ����1:41:44
 * Ա�����ݿ���ʲ�ӿ�
 */
public interface EmployeeDao {

	/*
	 * ����Ա����ţ������û���Ϣ
	 */
	EmployeeInfo getEmpInfoById(Integer empId);

	/*
	 * ��ȡ����Ա������Ϣ
	 */
	List<EmployeeInfo> getEmployeeList();

	/*
	 * ��ȡÿҳ����Ա����
	 */
	List<EmployeeInfo> getCurrentEmps(Map<String, Object> condition);

	/*
	 * ��ȡԱ������
	 */
	int getPageCount();

	/*
	 * ���Ա��
	 */
	int addEmpInfo(EmployeeInfo empInfo);

	/*
	 * ����Ա����ţ�ɾ��Ա����Ϣ
	 */
	void deleteEmpInfoById(Integer empId);

	/*
	 * �����û���Ϣ
	 */
	void updateEmpInfoByEmpId(EmployeeInfo empInfo);

}

