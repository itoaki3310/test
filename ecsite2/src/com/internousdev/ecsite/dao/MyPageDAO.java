package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class MyPageDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public ArrayList<MyPageDTO> getMyPageUserInfo
	//ユーザーの識別と買ったアイテムの識別(今回は商品が1つのため本来不要)のためにこの2つを引いてきている
	(String item_transaction_id, String user_master_id) throws SQLException {
	ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();
	//tableの左外部結合をしてubitとiitを作成し、まとめている
	String sql ="SELECT ubit.id, iit.item_name, ubit.total_price, ubit.total_count,ubit.pay, ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id = iit.id WHERE ubit.item_transaction_id = ? AND ubit.user_master_id = ? ORDER BY insert_date DESC";

	try {
		//SQLを実行するためのインターフェース（実装のないクラス）
		//？を用いたSQL分を実行するためのもの
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, item_transaction_id);
		ps.setString(2, user_master_id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {

			//取得したものをDTOに格納し、そのDTOをArrayListに格納
		MyPageDTO dto = new MyPageDTO();
		dto.setId(rs.getString("id"));
		dto.setItemName(rs.getString("item_name"));
		dto.setTotalPrice(rs.getString("total_price"));
		dto.setTotalCount(rs.getString("total_count"));
		dto.setPayment(rs.getString("pay"));
		dto.setInsert_date(rs.getString("insert_date"));
		myPageDTO.add(dto);//ArrayListにdtoというのを追加
	}
	} catch(Exception e) {

		e.printStackTrace();
		} finally {
		connection.close();
		}
		return myPageDTO;
		}
//↓DBから購入履歴を削除するメソッド
		public int buyItemHistoryDelete
		(String item_transaction_id, String user_master_id) throws SQLException {
			String sql ="DELETE FROM user_buy_item_transaction WHERE item_transaction_id = ? AND user_master_id = ?";
			//実質sqlを代入
			PreparedStatement preparedStatement;
			int result =0;
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, item_transaction_id);
				preparedStatement.setString(2, user_master_id);
				result = preparedStatement.executeUpdate();
			} catch (Exception e) {
					e.printStackTrace();
			} finally {
					connection.close();
			}
				return result;
		}
}