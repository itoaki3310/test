package com.internousdev.ecsite.action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{
	private int stock;
	private String pay;
	//sessionにキー型String、value型Objectを設定
	public Map <String,Object> session;
	private String result;

	public String execute(){
		result =SUCCESS;

		session.put("stock",stock);
		//parseIntでstockとpriceの文字列をint型に変換
		//これでsessionにstockとpriceを入れることができ、何個買ったら何円になるかの計算が可能になる
		int intStock =Integer.parseInt(session.get("stock").toString());
		int intPrice=Integer.parseInt(session.get("buyItem_price").toString());
		//何個買ったら何円になるかの計算
		session.put("buyItem_price",intStock * intPrice);

		String payment;
		//チェックの選択にvalue1と2をつけているため、数字での判別が可能
		if(pay.equals("1")){
			payment="現金";
			session.put("pay",payment);
		}else{
			payment = "クレカ";
			session.put("pay", payment);
		}
			return result;
		}
		public int getStock() {
			return stock;
		}
		public void setStock(int stock) {
			this.stock = stock;
		}
		public String getPay() {
			return pay;
		}
		public void setPay(String pay) {
			this.pay = pay;
		}
		public Map<String, Object> getSession() {
			return session;
		}
		public void setSession(Map<String, Object> session) {
			this.session = session;
		}
}
