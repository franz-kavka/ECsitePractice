package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartDAO;
import com.internousdev.ecsite.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware{
	public Map<String,Object>session;
	private CartDAO dao=new CartDAO();
	private ArrayList<CartDTO> CartList= new ArrayList<CartDTO>();
	private String message;
	private String deleteFlg;
	private int id;
	private int total=0;

	public String execute() throws SQLException{
		if(deleteFlg==null){
		setCartList(dao.getCartListInfo(session.get("login_user_id").toString()));
		session.put("CartList", CartList);
		if(CartList !=null){
			 CartList.forEach(dto -> {
					int price;
		            price=dto.getTotalPrice();
		            total=total+price;
		        });
			session.put("total", total);
			}
		}else if(deleteFlg.equals("1")){
			delete();
		}else if(deleteFlg.equals("2")){
			deleteIt();
		}
		String result=SUCCESS;
		return result;
	}
	public void delete() throws SQLException{
		int res =dao.ItemHistoryDelete(session.get("login_user_id").toString());
		if(res>0){
			CartList=null;
			setMessage("商品情報を正しく削除しました。");
		}else if(res==0){
			setMessage("商品情報の削除に失敗しました");
		}
	}
	public void deleteIt() throws SQLException{
		int res =dao.ItemHistoryDeleteIt(id);
		if(res>0){
			setMessage("商品情報を正しく削除しました。");
		}else if(res==0){
			setMessage("商品情報の削除に失敗しました");
		}
}
	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<CartDTO> getCartList() {
		return CartList;
	}

	public void setCartList(ArrayList<CartDTO> cartList) {
		CartList = cartList;
	}


}
