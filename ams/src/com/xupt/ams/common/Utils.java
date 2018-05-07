package com.xupt.ams.common;

import javax.servlet.http.HttpServletRequest;

/**
 * @author superYC
 * @date 2017年9月19日 --- 上午10:44:10
 * 工具类
 */
public class Utils {

	/*
	 * 泛型方法(获取客户端注册的参数信息)
	 */
	public static <T> T getParameter(HttpServletRequest request,String paraName,Class<T> toClass){
		T result = null;
		String value = request.getParameter(paraName);
		if(value != null && value.length() > 0){
			//字符串类String，Number的子类都有一个接受String类型的参数
			try{
				result = toClass.getDeclaredConstructor(String.class).newInstance(value);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}
}

