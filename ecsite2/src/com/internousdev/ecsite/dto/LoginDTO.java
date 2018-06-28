package com.internousdev.ecsite.dto;

public class LoginDTO {
	private String insert_date;
	private String loginId;
	private String loginPassword;
	private String userName;
	private boolean loginFlg=false;
	private String UserManager;

	public String getLoginId(){
		return loginId;
	}
	public void setLoginId(String loginId){
		this.loginId=loginId;
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
	public boolean getLoginFlg() {
		return loginFlg;
	}
	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
		}
	public String getUserManager(){
		return UserManager;
	}
	public void setUserManager(String UserManager){
		this.UserManager=UserManager;
	}
	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}

}