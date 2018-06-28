package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import com.internousdev.ecsite.dto.ItemManageDTO;
import com.internousdev.ecsite.dao.ItemManageDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemManageAction extends ActionSupport {
	private ItemManageDAO itemManageDAO =new ItemManageDAO();
	private ArrayList<ItemManageDTO> imList=new ArrayList<ItemManageDTO>();
	private String message;
	private String deleteAllItem;

	public String execute() throws SQLException{
		if(deleteAllItem==null){
			imList=itemManageDAO.getItemManagerInfo();
		}else if(deleteAllItem.equals("1")){
			delete();
		}

		String result = SUCCESS;
		return result;
	}

	public void delete() throws SQLException {
		int res = itemManageDAO.deleteAllItem();
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
	public String getDeleteAllItem() {
		return this.deleteAllItem;
	}
	public void setDeleteAllItem(String deleteAllItem) {
		this.deleteAllItem = deleteAllItem;
}
}
