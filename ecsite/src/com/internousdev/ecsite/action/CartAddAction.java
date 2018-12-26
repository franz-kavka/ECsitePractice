package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.CartDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAddAction extends ActionSupport implements SessionAware {
	public Map<String,Object> session;
	private int count;
	private String pay;
	private String itemName;
	private int itemPrice;
	private int id;
	private int cnt;
	List<BuyItemDTO> BuyItemDTOList=new ArrayList<BuyItemDTO>();
	List<CartDTO> CartList=new ArrayList<CartDTO>();
	int cartAmount;
	CartDAO Cartdao= new CartDAO();
	CartDTO CartDTO=new CartDTO();
		public String execute() throws SQLException{
			String result="login";
			if(session.containsKey("login_user_id")){

			int totalPrice=count*itemPrice;
			CartDTO = Cartdao.cartAdd(
					id,
					session.get("login_user_id").toString(),
					totalPrice,
					count,
					pay,
					itemName
					);;

			BuyItemDAO Buydao=new BuyItemDAO();
			BuyItemDTOList=Buydao.getBuyItemNextInfo();
			session.put("BuyItemDTOList", BuyItemDTOList);
			cnt=Cartdao.getCartAmount(session.get("login_user_id").toString());
			session.put("cnt", cnt);
			result=SUCCESS;
			}
			return result;
		}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<CartDTO> getCartList() {
		return CartList;
	}

	public void setCartList(List<CartDTO> cartList) {
		CartList = cartList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public int getCount() {
		return count;
	}

	public String getPay() {
		return pay;
	}

	public String getItemName() {
		return itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}






}
