package com.internousdev.ecsite.action;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport{
	public Map<String,Object>session;

	public String execute(){
		return SUCCESS;
	}


}
