package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.internousdev.ecsite.dao.UserCreateCompleteDAO;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware {


public Map<String,Object> session;
private UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();
public String execute() throws SQLException{
//createUser(DB Connector)にId,pass,nameをString型で格納
		userCreateCompleteDAO.createUser(
				session.get("loginUserId").toString(),
				session.get("loginUserPassword").toString(),
				session.get("userName").toString());
			String result=SUCCESS;
			return result;
	}
public void setSession(Map<String, Object> session) {
	this.session = session;
}
}