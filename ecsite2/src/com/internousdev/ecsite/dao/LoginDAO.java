package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;

public class LoginDAO {

	private DBConnector dbConnector =new DBConnector();
	private Connection connection=dbConnector .getConnection();
	private LoginDTO loginDTO=new LoginDTO();

//LoginActionからloginUserId,loginPasswordがながれてきて
//StringのloginUserId・passの中に入り、 getLoginUserInfoが入力データを持つ
	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword){
//sqlに受けつけたデータがあるかをチェック
//login_user_transactionを選択
		String sql = "SELECT * FROM login_user_transaction where login_id = ? AND login_pass =?";
		try {
//上のsql文の？にIDとPassが入る
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginPassword);
			ResultSet resultSet = preparedStatement.executeQuery();
//DBを順にすべて読み込む
			if(resultSet.next()) {
			loginDTO.setLoginId(resultSet.getString("login_id"));
			loginDTO.setLoginPassword(resultSet.getString("login_pass"));
			loginDTO.setUserName(resultSet.getString("user_name"));
//DBにIDとPassが入っていればLoginDTOにてfalseに設定されていた
//LoginFlgがtrueに変換される
//LoginActionに戻る
		if(!(resultSet.getString("login_id").equals(null))) {
			loginDTO.setLoginFlg(true);
			}
		}
			//例外時に実行される分
		} catch(Exception e) {
			e.printStackTrace();
		}
			return loginDTO;
		}
		public LoginDTO getLoginDTO() {
			return loginDTO;
		}
}
