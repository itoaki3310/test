package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;

public class MyPageAction extends ActionSupport implements SessionAware{
	//購入履歴を引き継ぐためにsessionの定義
	public Map<String,Object>session;
	private MyPageDAO myPageDAO=new MyPageDAO();
//MyPageDTOをmyPageListにインスタンス
	private ArrayList<MyPageDTO>myPageList=new ArrayList<MyPageDTO>();
	private String deleteFlg;
	private String message;
	public String execute() throws SQLException {
//もしsession.containsKey("id")ではなかったらreturn ERRORになる
//containsKeyは指定したキーが存在すればtrueを返す
//つまり、idがsessionに存在しなければERRORとなるようにしている
	if (!session.containsKey("id")) {
		return ERROR;
	}

	if(deleteFlg == null) {
		//sessionからString形式でidを取得し、item_transaction_idに格納
		String item_transaction_id = session.get("id").toString();
		String user_master_id = session.get("login_user_id").toString();
		//ArrayListのmyPageListにmyPageDAO.getMyPageUserInfoを格納
		//myPageDAO.getMyPageUserInfoはマッピングされているためリスト形式でマッピングを管理できる
		myPageList = myPageDAO.getMyPageUserInfo(item_transaction_id, user_master_id);
	}
//myPage.jspでボタンが押されるとdeleteFlgが１になる、つまりelse ifが適応される
	else if(deleteFlg.equals("1")) {
		//内容の削除
		delete();
	}
	String result = SUCCESS;
		return result;
	}
	//else ifのdelete()の内容
public void delete() throws SQLException {
//各idを持ってきて
	String item_transaction_id = session.get("id").toString();
	String user_master_id = session.get("login_user_id").toString();
//各idをresに代入
		int res = myPageDAO.buyItemHistoryDelete(item_transaction_id, user_master_id);
//削除ボタンが押された場合valueは1になるためifが適応
		if(res > 0) {
//myPageList（各id）にnullを代入し、メッセージの表示
		myPageList = null;
		setMessage("商品情報を正しく削除しました。");
		} else if(res == 0) {
		setMessage("商品情報の削除に失敗しました");
		}
		}
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public ArrayList<MyPageDTO> getMyPageList() {
		return this.myPageList;
	}
	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
