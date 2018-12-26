package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class MyPageDAO {
	private DBConnector db=new DBConnector();
	private Connection con= db.getConnection();

	public ArrayList<MyPageDTO> getMyPageUserInfo(String item_transaction_id,String user_master_id)throws SQLException{
		ArrayList<MyPageDTO> myPageDTO=new ArrayList<MyPageDTO>();
		String sql="SELECT * from user_buy_item_transaction WHERE user_master_id = ?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user_master_id);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				MyPageDTO dto=new MyPageDTO();
				dto.setId(rs.getString("id"));;
				dto.setItemName(rs.getString("item_name"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setPayment(rs.getString("pay"));
				dto.setInsert_date(rs.getString("insert_date"));
				if(Integer.parseInt(rs.getString("pay"))==1){
					dto.setPayPay("現金払い");
					}
					else if(Integer.parseInt(rs.getString("pay"))==2){
						dto.setPayPay("クレジットカード");
					}
					else{
						dto.setPayPay("fuck");
					}
				myPageDTO.add(dto);
			}
			if(myPageDTO.isEmpty()){
				 myPageDTO=null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return myPageDTO;

	}
	public int buyItemHistoryDelete(String item_transaction_id,String user_master_id)throws SQLException{
		String sql="DELETE FROM user_buy_item_transaction WHERE user_master_id = ?";
		PreparedStatement ps;
		int result=0;
		try{
			ps=con.prepareStatement(sql);
			ps.setString(1, user_master_id);
			result=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;

	}
	public int buyItemHistoryDeleteIt(String id,String user_master_id)throws SQLException{
		String sql="DELETE FROM user_buy_item_transaction WHERE id = ?";
		PreparedStatement ps;
		int res=0;
		try{
			ps=con.prepareStatement(sql);
			int i = Integer.parseInt(id);
			ps.setInt(1, i);
			res=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return res;

	}

}
