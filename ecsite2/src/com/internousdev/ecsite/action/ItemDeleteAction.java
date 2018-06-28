package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.internousdev.ecsite.dto.*;
import com.internousdev.ecsite.dao.*;

public class ItemDeleteAction extends ActionSupport implements SessionAware{
	private String itemName;
	private String itemPrice;
	private String itemStock;
	private String itemCategory;
	private Map<String, Object> session;
	private String Id;
	ArrayList<ItemManageDTO> itemManageDTO=new ArrayList<ItemManageDTO>();
	ItemManageDAO itemManageDAO=new ItemManageDAO();

public String execute() {
	String result =SUCCESS;

//	itemManageDTO =itemManageDAO.ItemInfo(Id);
	session.put("id",Id);
	session.put("item_name",itemName);
	session.put("item_price",itemPrice);
	session.put("item_stock",itemStock);
	session.put("item_category",itemCategory);

return result;
}

public Map<String, Object> getSession() {
	return session;
}
public void setSession(Map<String, Object> session) {
	this.session = session;
}
public String getId() {
	return Id;
}
public void setId(String Id) {
	this.Id = Id;
}
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}
public String getItemCategory() {
	return itemCategory;
}
public void setItemCategory(String itemCategory) {
	this.itemCategory = itemCategory;
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

}