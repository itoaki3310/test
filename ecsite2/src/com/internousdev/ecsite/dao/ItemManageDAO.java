package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.dto.ItemManageDTO;

public class ItemManageDAO {
	private DBConnector dbconnector=new DBConnector();
	private Connection connection=dbconnector.getConnection();

	String sql="SELECT id, item_name,item_price, item_stock, item_category FROM item_info_transaction";

	public ArrayList<ItemManageDTO> getItemManagerInfo() throws SQLException{
		ArrayList<ItemManageDTO> itemManageDTO=new ArrayList<ItemManageDTO>();

	try {
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			ItemManageDTO DTO =new ItemManageDTO();
			DTO.setId(rs.getString("id"));
			DTO.setItemName(rs.getString("item_name"));
			DTO.setItemPrice(rs.getString("item_price"));
			DTO.setItemStock(rs.getString("item_stock"));
			DTO.setItemCategory(rs.getString("item_category"));
			itemManageDTO.add(DTO);
		}
	}catch(Exception e){
		e.printStackTrace();
	} finally {
	connection.close();
	}
	return itemManageDTO;
}
	public int deleteAllItem() throws SQLException{
		String sql="DELETE FROM item_info_transaction";
		PreparedStatement ps;
		int result=0;
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
//DTOに選択されたデータを詰め込む
public ItemManageDTO ItemInfo(String Id) throws SQLException{
	DBConnector dbConnector = new DBConnector();
	Connection connection = dbConnector.getConnection();
	ItemManageDTO DTO =new ItemManageDTO();
	String sql="select * from item_info_transaction where id=? ";
	try {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(0, Id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			DTO.setId(resultSet.getString("id"));
			DTO.setItemName(resultSet.getString("item_name"));
			DTO.setItemPrice(resultSet.getString("item_price"));
			DTO.setItemStock(resultSet.getString("item_stock"));
			DTO.setItemCategory(resultSet.getString("item_category"));
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return DTO;
	}
}
