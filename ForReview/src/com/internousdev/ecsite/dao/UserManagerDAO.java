package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;


public class UserManagerDAO {

	public LoginDTO getUserManager(){
		DBConnector dbConnector=new DBConnector();
		Connection connection =dbConnector.getConnection();//getConnection→con=null
		LoginDTO userManageDTO=new LoginDTO();
		String sql="SELECT id,login_id,login_pass FROM login_user_transaction";

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			//resultSetでnextは次の要素があればtrueを返す
			if(resultSet.next()){
				userManageDTO.setLoginId(resultSet.getString("id"));
				userManageDTO.setUserName(resultSet.getString("login_id"));
				userManageDTO.setLoginPassword(resultSet.getString("login_pass"));
			}
//決まり文句
		}catch(Exception e){
			e.printStackTrace();
		}
//BuyItemDTOにidとitem_name、item_priceを返すことでjspに商品情報を載せている
			return userManageDTO;
			}

}
