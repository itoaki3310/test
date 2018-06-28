package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import com.internousdev.ecsite.dto.UserManagerDTO;
import com.opensymphony.xwork2.ActionSupport;
import com.internousdev.ecsite.dao.UserManagerDAO;

public class UserManageAction extends ActionSupport  {

	private String message;
	private String deleteDate;
	private UserManagerDAO userManagerDAO = new UserManagerDAO();
	private ArrayList<UserManagerDTO> userManagerDTOlist = new ArrayList<UserManagerDTO>();

	public String execute () throws SQLException{
			if(deleteDate==null){
				userManagerDTOlist = userManagerDAO.getUserManageInfo();
			}else if(deleteDate.equals("1")){
			 delete();
			 }
		 String result = SUCCESS;
		// return result;は文頭のメソッドに戻ってしまうため文末に置かないとエラーが起こるかも
			return result;
	}

		public void delete() throws SQLException {
			int res = userManagerDAO.usersDelete();
			if(res>0){
				setMessage("削除完了");
			}else if(res==0){
				setMessage("削除できませんでした");
			}
	}

	public ArrayList<UserManagerDTO> getUserManagerDTOlist() {
		return userManagerDTOlist;
	}

	public void setUserManagerDTOlist(ArrayList<UserManagerDTO> userManagerDTOlist) {
		this.userManagerDTOlist = userManagerDTOlist;
	}
	public String getDeleteDate() {
		return this.deleteDate;
	}
	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}
	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}