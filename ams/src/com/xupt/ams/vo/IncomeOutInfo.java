package com.xupt.ams.vo;

/**
 * @author superYC
 * @date 2017年9月16日 --- 下午1:18:38 收入支出实体类
 */
public class IncomeOutInfo {

	private Integer inout_id;
	private String inout_date;
	private String inout_desc;
	private Integer emp_id;		//会计人员信息
	private Integer payment_id;	//支付编号
	private Integer inout_type_id;	//收支类型编号
	private Integer pass_flag;	//通过标志

	public Integer getInout_id() {
		return inout_id;
	}

	public void setInout_id(Integer inout_id) {
		this.inout_id = inout_id;
	}

	public String getInout_date() {
		return inout_date;
	}

	public void setInout_date(String inout_date) {
		this.inout_date = inout_date;
	}

	public String getInout_desc() {
		return inout_desc;
	}

	public void setInout_desc(String inout_desc) {
		this.inout_desc = inout_desc;
	}

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	public Integer getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(Integer payment_id) {
		this.payment_id = payment_id;
	}

	public Integer getInout_type_id() {
		return inout_type_id;
	}

	public void setInout_type_id(Integer inout_type_id) {
		this.inout_type_id = inout_type_id;
	}

	public Integer getPass_flag() {
		return pass_flag;
	}

	public void setPass_flag(Integer pass_flag) {
		this.pass_flag = pass_flag;
	}

}
