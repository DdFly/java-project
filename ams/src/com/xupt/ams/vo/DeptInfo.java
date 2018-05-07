package com.xupt.ams.vo;

/**
 * @author superYC
 * @date 2017年9月16日 --- 下午1:17:31 部门实体类
 */
public class DeptInfo {

	private Integer dept_id;
	private String dept_name;
	private String dept_desc;
	private String dept_location;

	public Integer getDept_id() {
		return dept_id;
	}

	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getDept_desc() {
		return dept_desc;
	}

	public void setDept_desc(String dept_desc) {
		this.dept_desc = dept_desc;
	}

	public String getDept_location() {
		return dept_location;
	}

	public void setDept_location(String dept_location) {
		this.dept_location = dept_location;
	}

}
