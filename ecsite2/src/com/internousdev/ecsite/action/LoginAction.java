package com.internousdev.ecsite.action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String loginPassword;
	public String result;
	public Map<String,Object>session;
	public static final String ROOT = "root";

	public String execute(){
		LoginDAO loginDAO = new LoginDAO();
		LoginDTO loginDTO = new LoginDTO();
		BuyItemDAO buyItemDAO = new BuyItemDAO();

		result =ERROR;
//loginUserId,loginPasswordがながれてきてloginDAOのgetLoginUserInfoに移動
		loginDTO=loginDAO.getLoginUserInfo(loginUserId,loginPassword);
//sessionにString型のloginUserキー、loginDTO型の値(IDとPass)が入る
		session.put("loginUser",loginDTO);

//LoginDAOにてLoginFlgはtrueに変換されてる
//loginDTOの中のsessionの中のloginUserの中のLoginFlgがtrueなら実行
				if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
	//ERRORがSUCCESSに変換される
			result=SUCCESS;
			BuyItemDTO buyItemDTO=buyItemDAO.getBuyItemInfo();
//session.get("login_user_id")と入れるとloginDTOクラスのgetloginIdが呼び出される。
//
			session.put("login_user_id",loginDTO.getLoginId());
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());

			//idとpassがmanagerならmanager画面へ飛ぶ
			 if(session.get("login_user_id").equals("manager")){
					result="manager";
				}}
		return result;
	}

	//以下コンストラクタ文
	//LoginUserIdを持ってきてloginUserIdを返してる
	public String getLoginUserId() {
		return loginUserId;
	}
	//LoginUserIdをいじれるようにしてloginUserIdで反応するようにしている
	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public void setSession(Map<String,Object>session){
		this.session=session;
	}

}
