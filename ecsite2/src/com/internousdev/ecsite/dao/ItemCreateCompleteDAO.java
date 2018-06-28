package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.internousdev.ecsite.util.DBConnector;

public class ItemCreateCompleteDAO {
		//打ち込まれた情報をSQLに反映するためのSQL文
		private String sql = "INSERT INTO item_info_transaction (item_name, item_price, item_stock, item_category) VALUES(?, ?, ?, ?)";

		public void createItem(String IName , String IPrice , String IStock, String ICategory)throws SQLException{
			 DBConnector dbconnector =new DBConnector();
			 // Connection は特定のDBとの接続を表現しているこいつ使えばDBに接続できるよ適菜やーつ
			 Connection connection=dbconnector.getConnection();

			try{
				//PreparedStatementはSQL文を実行するための文章
				//（）内にsqlが入っているためpreparedStatementに情報を格納すればsqlの対応する場所I（DとかPassとか）に反映される
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
	//Id,pass,nameを格納、4に日時を格納
				preparedStatement.setString(1,IName);
				preparedStatement.setString(2,IPrice);
				preparedStatement.setString(3,IStock);
				preparedStatement.setString(4,ICategory);
				preparedStatement.execute();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				//DBとの接続を切断
				connection.close();
			}
		}
	}
