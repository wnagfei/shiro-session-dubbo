package com.utils;

import java.util.Calendar;

import com.opensymphony.xwork2.ActionContext;

public class BaseTools {
	
	public static void success(String message, String waitSecond, String jumpURL) {
		if(waitSecond == null ){
			waitSecond = "2";
		}
		ActionContext context = ActionContext.getContext();
		context.put("issuccess", "1");
		context.put("message", message);
		context.put("waitSecond", waitSecond);
		context.put("jumpURL", jumpURL);
	}
	public static void error(String message, String waitSecond, String jumpURL) {
		if(waitSecond == null ){
			waitSecond = "3";
		}
		ActionContext context = ActionContext.getContext();
		context.put("issuccess", "0");
		context.put("message", message);
		context.put("waitSecond", waitSecond);
		context.put("jumpURL", jumpURL);
	}
	

}
