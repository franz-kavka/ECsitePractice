package com.internousdev.ecsite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware {
	public Map<String,Object> session;
	private int count;
	private String pay;
	private String itemName;
	private int itemPrice;
	private int id;

	public String execute(){
		String result="login";
		if(session.containsKey("login_user_id")){
		result=SUCCESS;
		session.put("count", count);
		session.put("buyItem_price", itemPrice);
		session.put("buyItem_name", itemName);
		int intCount= Integer.parseInt(session.get("count").toString());
		int intPrice=Integer.parseInt(session.get("buyItem_price").toString());
		session.put("total_price", intCount*intPrice);
		session.put("item_transaction_id",id);
		String payment;

		if(pay.equals("1")){
			payment="現金払い";
			session.put("pay", payment);
		}else{
			payment="クレジットカード";
			session.put("pay", payment);
		}
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





}
