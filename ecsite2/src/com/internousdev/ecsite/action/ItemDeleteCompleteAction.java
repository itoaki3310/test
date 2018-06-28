package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.ItemDeleteCompleteDAO;
import com.internousdev.ecsite.dto.ItemManageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDeleteCompleteAction extends ActionSupport {
	private ItemDeleteCompleteDAO itemDeleteCompleteDAO =new ItemDeleteCompleteDAO();
	private ArrayList<ItemManageDTO> imList=new ArrayList<ItemManageDTO>();
	private String message;
	private String deleteOneItem;

	public String execute() throws SQLException{
		if(deleteOneItem==null){
			setMessage("error");
		}else if(deleteOneItem.equals("1")){
			delete();
		}

		String result = SUCCESS;
		return result;
	}
	public void delete() throws SQLException {
		int res = itemDeleteCompleteDAO.deleteOneItem();
		if(res>0){
			setMessage("削除完了");
		}else if(res==0){
			setMessage("削除できませんでした");
		}
	}
	public ArrayList<ItemManageDTO> getImList() {
		return imList;
	}

	public void setImList(ArrayList<ItemManageDTO> imList) {
		this.imList = imList;
	}
	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDeleteOneItem() {
		return this.deleteOneItem;
	}
	public void setDeleteOneItem(String deleteOneItem) {
		this.deleteOneItem = deleteOneItem;
}
}
