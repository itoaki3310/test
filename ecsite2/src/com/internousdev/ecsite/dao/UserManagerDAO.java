package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.internousdev.ecsite.dto.UserManagerDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserManagerDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public ArrayList<UserManagerDTO> getUserManageInfo() throws SQLException {
	ArrayList<UserManagerDTO> userManagerDTO = new ArrayList<UserManagerDTO>();

	String sql ="SELECT  login_id, login_pass, user_name,insert_date FROM login_user_transaction ORDER BY login_id DESC ";
	//insert_date DESCは降順の並び替え昇順はASC

	try{
		PreparedStatement ps= connection.prepareStatement(sql);
		//executeQueryはデータを取得する文章
		ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			UserManagerDTO DTO=new UserManagerDTO();
			DTO.setLoginId(rs.getString("login_id"));
			DTO.setLoginPassword(rs.getString("login_pass"));
			DTO.setUserName(rs.getString("user_name"));
			DTO.setInsertdate(rs.getString("insert_date"));
			userManagerDTO.add(DTO);
		}

}catch(Exception e) {
	e.printStackTrace();
	} finally {
	connection.close();
	}
	return userManagerDTO;
	}
//データ削除の文章
	//データは上で引いてきているため、削除の文のみでOK
	public  int usersDelete()throws SQLException{
		String sql="DELETE FROM login_user_transaction";
		PreparedStatement ps;
		//executeUpdateで行数が返ってくるためint
		int result =0;
		try{
			ps=connection.prepareStatement(sql);
//executeUpdateは削除、追加、変更の文、実行するとデータベースからは処理された行数が帰ってくる
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			} finally {
			connection.close();
			}
		return result;
}
}