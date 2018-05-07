package com.xupt.ams.vo;

/**
 * @author superYC
 * @date 2017年9月16日 --- 下午12:48:20 员工的实体类
 */
public class EmployeeInfo {

	private Integer emp_id;
	private String emp_name;
	private Integer dept_id;
	private String emp_gender;
	private Integer emp_type;

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public Integer getDept_id() {
		return dept_id;
	}

	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}

	public String getEmp_gender() {
		return emp_gender;
	}

	public void setEmp_gender(String emp_gender) {
		this.emp_gender = emp_gender;
	}

	public Integer getEmp_type() {
		return emp_type;
	}

	public void setEmp_type(Integer emp_type) {
		this.emp_type = emp_type;
	}

}
