package com.test;

import com.alibaba.fastjson.JSON;
import com.stock.framework.domain.BusError;
import com.stock.framework.domain.TokenError;

public class TestError {
	
	public static void main(String[] args) {
		
		TokenError error = JSON.parseObject("{\"error_no\":-1,\"error_info\":\"failed\",\"error_code\":1,\"error_extinfo\":\"sort_field_name: 必须输入\"}", TokenError.class);
		System.out.println(error==null);
		BusError buserror = JSON.parseObject("{\"error_no\":-1,\"error_info\":\"failed\",\"error_code\":1,\"error_extinfo\":\"sort_field_name: 必须输入\"}", BusError.class);
		System.out.println(buserror==null);
	}
}
