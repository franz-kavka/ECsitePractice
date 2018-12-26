package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateCompleteAction extends ActionSupport implements SessionAware{
	private String ItemName;
	private String ItemPrice;
	private String ItemStock;
	public Map<String,Object>session;
	private ItemCreateCompleteDAO ITEMDAO=new ItemCreateCompleteDAO();

	public String execute() throws SQLException{
		ITEMDAO.createItem(session.get("itemName").toString(),
				session.get("itemPrice").toString(),
				session.get("itemStock").toString());
		String result=SUCCESS;
		return result;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String ItemName) {
		this.ItemName = ItemName;
	}

	public String getItemPrice() {
		return ItemPrice;
	}

	public void setItemPrice(String ItemPrice) {
		this.ItemPrice = ItemPrice;
	}

	public String getItemStock() {
		return ItemStock;
	}

	public void setItemStock(String ItemStock) {
		this.ItemStock = ItemStock;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
