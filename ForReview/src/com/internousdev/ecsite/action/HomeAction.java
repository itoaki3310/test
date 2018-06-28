package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;

public class HomeAction extends ActionSupport implements SessionAware {

	//sessionは暗黙オブジェクトのためインスタンス化不要
	public Map<String, Object> session;
	//実行メソッドの作成
	public String execute() {
		//struts.xmlでresultがloginならlogin.jspに飛ぶようにするため
		String result = "login";

//以下はlogin状態からlogoutする際の文章
//sessionメソッドのcontainsKey(java.util.Mapから継承)にidがはいってたら｛｝内を処理
//containsKeyは()内のキーが存在すればtrueを返すという意
		if (session.containsKey("id")) {
//buyItemDAOの作成
	BuyItemDAO buyItemDAO = new BuyItemDAO();
//buyitem.jspに商品データを持っていくためにHomeActionで商品データを読み込んでる
	BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();

//session.putでsessionに値を入力するという意味
//sessionの0にidを2にbuyItemDTOを、3にgetId()を入れてる
	session.put("id", buyItemDTO.getId());
	session.put("buyItem_name", buyItemDTO.getItemName());
	session.put("buyItem_price", buyItemDTO.getItemPrice());
//SUCCESSをexecuteに返す
	result = SUCCESS;
	}
//resultを返すSUCCESSならログアウトの文字が出るのと商品購入履歴が持ち越される
//loginならログインjspにいく
		return result;
	}
//セッターの設定sessionに値を挿入できるようにする
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
//ゲッターの設定、sessionを取り出してきていじれるようにする
	public Map<String, Object> getSession() {
		return this.session;
	}
}
