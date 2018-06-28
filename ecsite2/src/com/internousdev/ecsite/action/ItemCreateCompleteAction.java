package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.internousdev.ecsite.dao.ItemCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateCompleteAction extends ActionSupport implements SessionAware {

public Map<String,Object> session;
private ItemCreateCompleteDAO itemCreateCompleteDAO = new ItemCreateCompleteDAO();
public String execute() throws SQLException{
//createUserにId,pass,nameをString型で格納
	itemCreateCompleteDAO.createItem(
			session.get("IName").toString(),
			session.get("IPrice").toString(),
			session.get("IStock").toString(),
			session.get("ICategory").toString());
			String result=SUCCESS;
			return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}