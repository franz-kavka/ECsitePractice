package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.CartDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyAction extends ActionSupport implements SessionAware {
	public Map<String,Object> session;
	List<BuyItemDTO> BuyItemDTOList=new ArrayList<BuyItemDTO>();
	int cnt=0;

	public String execute() {
			BuyItemDAO dao=new BuyItemDAO();
			BuyItemDTOList=dao.getBuyItemNextInfo();
			session.put("BuyItemDTOList", BuyItemDTOList);
			CartDAO Cartdao = new CartDAO();
			if(session.containsKey("login_user_id")){
				try {
					cnt=Cartdao.getCartAmount(session.get("login_user_id").toString());
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				session.put("cnt", cnt);
			}
			String result=SUCCESS;

		return result;
	}
		@Override
		public void setSession(Map<String, Object> session){
			this.session=session;
		}

		public Map<String, Object> getSession(){
			return this.session;
	}

}
