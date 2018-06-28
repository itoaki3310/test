package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.*;

public class UserCreateAction extends ActionSupport{
	public String execute(){
//executeにSUCCESSを返してstrutsに反映しUserCreate画面に移行
		return SUCCESS;
	}
}
