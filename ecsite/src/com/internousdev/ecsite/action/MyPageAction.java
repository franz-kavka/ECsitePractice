package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{
	public Map<String,Object>session;
	private MyPageDAO dao=new MyPageDAO();
	private ArrayList<MyPageDTO> myPageList= new ArrayList<MyPageDTO>();
	private String deleteFlg;
	private String message;
	private String confirm;
	private String id;
	private int total=0;

	public String execute() throws SQLException{
		if(!session.containsKey("id")){
			return ERROR;
		}
		if(deleteFlg==null){
			String item_transaction_id=session.get("id").toString();
			String user_master_id=session.get("login_user_id").toString();
			myPageList=dao.getMyPageUserInfo(item_transaction_id, user_master_id);
			if(myPageList !=null){
			 myPageList.forEach(dto -> {
					int price;
		            price=Integer.parseInt(dto.getTotalPrice());
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
		String item_transaction_id=session.get("id").toString();
		String user_master_id=session.get("login_user_id").toString();

		int res =dao.buyItemHistoryDelete(item_transaction_id, user_master_id);
		if(res>0){
			myPageList=null;
			setMessage("商品情報を正しく削除しました。");
		}else if(res==0){
			setMessage("商品情報の削除に失敗しました");
		}
	}

	public void deleteIt() throws SQLException{
		String user_master_id=session.get("login_user_id").toString();
		int res =dao.buyItemHistoryDeleteIt(id, user_master_id);
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
	public ArrayList<MyPageDTO> getMyPageList() {
		return this.myPageList;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}



}
