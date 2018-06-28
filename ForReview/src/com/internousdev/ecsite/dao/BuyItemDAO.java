package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

	public class BuyItemDAO {
		public BuyItemDTO getBuyItemInfo(){
			DBConnector dbConnector=new DBConnector();
			Connection connection =dbConnector.getConnection();//getConnection→con=null
			BuyItemDTO buyItemDTO=new BuyItemDTO();
//item_info_transactionのid,item_name,item_priceを選択しsqlに代入してる
			String sql="SELECT id,item_name,item_price FROM item_info_transaction";
//例外処理
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			//resultSetでnextは次の要素があればtrueを返す
			if(resultSet.next()){
				buyItemDTO.setId(resultSet.getInt("id"));
				buyItemDTO.setItemName(resultSet.getString("item_name"));
				buyItemDTO.setItemPrice(resultSet.getString("item_price"));
			}
//決まり文句
		}catch(Exception e){
			e.printStackTrace();
		}
//BuyItemDTOにidとitem_name、item_priceを返すことでjspに商品情報を載せている
			return buyItemDTO;
		}
	}