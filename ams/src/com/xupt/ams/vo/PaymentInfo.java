package com.xupt.ams.vo;

/**
 * @author superYC
 * @date 2017年9月16日 --- 下午1:20:57
 * 支付实体类
 */
public class PaymentInfo {

	private Integer payment_id;
	private String payment_name;

	public Integer getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(Integer payment_id) {
		this.payment_id = payment_id;
	}

	public String getPayment_name() {
		return payment_name;
	}

	public void setPayment_name(String payment_name) {
		this.payment_name = payment_name;
	}

}
