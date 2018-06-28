package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class ItemDeleteCompleteDAO {
	private DBConnector dbconnector = new DBConnector();
	private Connection connection=dbconnector.getConnection();

	public int deleteOneItem() throws SQLException{
		String sql="delete from item_info_transaction weher id=? ";
		PreparedStatement ps;
		int result=0;
		try{
			ps=connection.prepareStatement(sql);
				result = ps.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
				} finally {
				connection.close();
				}
			return result;
	}
}
