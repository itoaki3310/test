package com.internousdev.ecsite.action;

import java.util.*;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateConfirmAction extends ActionSupport implements SessionAware {
	private String itemName;
	private String itemPrice;
	private String itemStock;
	private String itemCategory;
//	private String itemcategory;
//sessionの定義、キーにString、値にObjectを設定
	public Map<String,Object> session;
	private String errorMessage;


	public String execute(){
		String result =SUCCESS;

//入力欄にすべて入力されていれば、入力内容をSQLに送信
//未入力欄があればエラーメッセージを表示
		//このif文はUserCreateとPassとNameが空白じゃなければ実行されるという意
		if(!(itemName.equals("") && itemPrice.equals("") && itemStock.equals("") && itemCategory.equals(""))){
//sessionにjspにて入力された情報を格納
	//キーはcreatecompleteのメソッドの引数に対応値は宣言文に対応
					session.put("IName",itemName);
					session.put("IPrice",itemPrice);
					session.put("IStock",itemStock);
					session.put("ICategory",itemCategory);
		}
//空欄があった場合の処理として、エラーメッセージを出してERRORを返す
		//（UserCreatejspに戻される）
		else{
			setErrorMessage("未入力の項目があります。");
			result=ERROR;
		}
			return result;
	}
	public String getItemName(){
		return itemName;
	}
	public void setItemName(String itemName){
		this.itemName=itemName;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemStock() {
		return itemStock;
	}
	public void setItemStock(String itemStock) {
		this.itemStock = itemStock;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getItemCategory() {
		return itemCategory;
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
