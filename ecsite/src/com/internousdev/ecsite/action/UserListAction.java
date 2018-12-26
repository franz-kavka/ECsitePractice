package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport implements SessionAware{
	public Map<String,Object>session;
	private UserListDAO dao=new UserListDAO();
	private ArrayList<UserListDTO> UserListList= new ArrayList<UserListDTO>();
	private String message;
	private String deleteFlg;
	private int id;

	public String execute() throws SQLException{
		if(deleteFlg==null){
		UserListList=dao.getUserListInfo();
		}else if(deleteFlg.equals("1")){
			delete();
		}else if(deleteFlg.equals("2")){
			deleteIt();
		}
	String result=SUCCESS;
	return result;
	}

	public void delete() throws SQLException{
		int res =dao.UserHistoryDelete();
		if(res>0){
			UserListList=null;
			setMessage("商品情報を正しく削除しました。");
		}else if(res==0){
			setMessage("商品情報の削除に失敗しました");
		}
	}
	public void deleteIt() throws SQLException{
		int res =dao.UserHistoryDeleteIt(id);
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
	public ArrayList<UserListDTO> getUserListList() {
		return this.UserListList;
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


}
