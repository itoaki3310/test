package com.internousdev.ecsite.action;

import java.util.*;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware {
	private String loginUserId;
	private String loginPassword;
	private String userName;
//sessionの定義、キーにString、値にObjectを設定
	public Map<String,Object> session;
	private String errorMessage;


	public String execute(){
		String result =SUCCESS;

//入力欄にすべて入力されていれば、入力内容をSQLに送信
//未入力欄があればエラーメッセージを表示
		//このif文はUserCreateとPassとNameが空白じゃなければ実行されるという意
		if(!(loginUserId.equals(""))
				&& !(loginPassword.equals(""))
				&& !(userName.equals(""))){
//sessionにjspにて入力された情報を格納
					session.put("loginUserId",loginUserId);
					session.put("loginUserPassword",loginPassword);
					session.put("userName",userName);
		}
//空欄があった場合の処理として、エラーメッセージを出してERRORを返す
		//（UserCreatejspに戻される）
		else{
			setErrorMessage("未入力の項目があります。");
			result=ERROR;
		}
			return result;
	}
	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId=loginUserId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
