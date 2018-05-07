package com.xupt.ams.common;

import javax.servlet.http.HttpServletRequest;

/**
 * @author superYC
 * @date 2017��9��19�� --- ����10:44:10
 * ������
 */
public class Utils {

	/*
	 * ���ͷ���(��ȡ�ͻ���ע��Ĳ�����Ϣ)
	 */
	public static <T> T getParameter(HttpServletRequest request,String paraName,Class<T> toClass){
		T result = null;
		String value = request.getParameter(paraName);
		if(value != null && value.length() > 0){
			//�ַ�����String��Number�����඼��һ������String���͵Ĳ���
			try{
				result = toClass.getDeclaredConstructor(String.class).newInstance(value);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}
}

