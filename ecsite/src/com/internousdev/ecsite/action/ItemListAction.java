package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport implements SessionAware{
	public Map<String,Object>session;
	private ItemListDAO dao=new ItemListDAO();
	private ArrayList<ItemListDTO> itemListList= new ArrayList<ItemListDTO>();
	private String message;
	private String deleteFlg;
	private int id;

	public String execute() throws SQLException{
		if(deleteFlg==null){
		itemListList=dao.getItemListUserInfo();
		}else if(deleteFlg.equals("1")){
			delete();
		}else if(deleteFlg.equals("2")){
			deleteIt();
		}
		String result=SUCCESS;
		return result;
	}

	public void delete() throws SQLException{
		int res =dao.ItemHistoryDelete();
		if(res>0){
			itemListList=null;
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
	public ArrayList<ItemListDTO> getItemListList() {
		return this.itemListList;
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
