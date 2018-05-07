package com.xupt.ams.vo;

/**
 * @author superYC
 * @date 2017年9月16日 --- 下午1:22:56
 * 收支类型实体类
 */
public class PaymentTypeInfo {

	private Integer inout_type_id;
	private String inout_type_name;
	private Integer inout_flag;

	public Integer getInout_type_id() {
		return inout_type_id;
	}

	public void setInout_type_id(Integer inout_type_id) {
		this.inout_type_id = inout_type_id;
	}

	public String getInout_type_name() {
		return inout_type_name;
	}

	public void setInout_type_name(String inout_type_name) {
		this.inout_type_name = inout_type_name;
	}

	public Integer getInout_flag() {
		return inout_flag;
	}

	public void setInout_flag(Integer inout_flag) {
		this.inout_flag = inout_flag;
	}

}
