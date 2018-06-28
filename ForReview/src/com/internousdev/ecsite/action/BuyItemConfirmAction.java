package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import java.sql.SQLException;
import java.util.Map;
//sessionawareをimplementsすることでsessionを使用可能にしている
public class BuyItemConfirmAction extends ActionSupport implements SessionAware {
//sessionの定義
	public Map<String, Object> session;
	//実行メソッドを作り、例外をSQLException に投げてる
	public String execute() throws SQLException {
	BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();

		buyItemCompleteDAO.buyItemeinfo(
//sessionから()内のものをString型で取り出してる
			session.get("id").toString(),
			session.get("login_user_id").toString(),
			session.get("buyItem_price").toString(),
			session.get("stock").toString(),
			session.get("pay").toString()
			);
	String result = SUCCESS;
		return result;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
