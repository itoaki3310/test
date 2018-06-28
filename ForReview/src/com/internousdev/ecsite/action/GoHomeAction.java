package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class GoHomeAction extends ActionSupport implements SessionAware{
//ログイン情報を保持したまま移動するためにsessionの定義
	public Map<String,Object>session;
//jspにてボタンを押すをSUCCESSが送信され、Struts.xmlにて処理される
	public String execute (){
		return SUCCESS;
	}

	public Map<String,Object>getSession(){
		return this.session;
	}
	public void setSession(Map<String,Object>session){
		this.session=session;
	}



}
