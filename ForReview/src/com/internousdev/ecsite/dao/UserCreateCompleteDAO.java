package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class UserCreateCompleteDAO {
//DateUtilは商品を購入した日時を送ってくれるクラス
	private DateUtil dateUtil=new DateUtil();
	//打ち込まれた情報をSQLに反映するためのSQL文
	private String sql = "INSERT INTO login_user_transaction (login_id, login_pass, user_name,insert_date) VALUES(?, ? ,?, ?)";

	public void createUser(String loginUserId ,String loginUserPassword,String userName)throws SQLException{
		 DBConnector dbconnector =new DBConnector();
		 // Connection は特定のDBとの接続を表現しているこいつ使えばDBに接続できるよ適菜やーつ
		 Connection connection=dbconnector.getConnection();

		try{
			//PreparedStatementはSQL文を実行するための文章
			//（）内にsqlが入っているためpreparedStatementに情報を格納すればsqlの対応する場所I（DとかPassとか）に反映される
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
//Id,pass,nameを格納、4に日時を格納
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginUserPassword);
			preparedStatement.setString(3, userName);
			preparedStatement.setString(4, dateUtil.getDate());
			preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//DBとの接続を切断
			connection.close();
		}
	}
}
