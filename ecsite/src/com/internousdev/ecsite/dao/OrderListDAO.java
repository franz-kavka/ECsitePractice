package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.OrderListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class OrderListDAO {
	private DBConnector db=new DBConnector();
	private Connection con= db.getConnection();

	public ArrayList<OrderListDTO> getOrderListInfo()throws SQLException{
		ArrayList<OrderListDTO> OrderListList=new ArrayList<OrderListDTO>();
		String sql="SELECT * from user_buy_item_transaction";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				OrderListDTO dto=new OrderListDTO();
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setUserName(rs.getString("user_master_id"));
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
				OrderListList.add(dto);
			}
			if(OrderListList.isEmpty()){
				 OrderListList=null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return OrderListList;

	}
	public int OrderHistoryDelete()throws SQLException{
		String sql="DELETE FROM user_buy_item_transaction";
		PreparedStatement ps;
		int result=0;
		try{
			ps=con.prepareStatement(sql);
			result=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;

	}
	public int OrderHistoryDeleteIt(int id)throws SQLException{
		String sql="DELETE FROM user_buy_item_transaction WHERE id = ?";
		PreparedStatement ps;
		int res=0;
		try{
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			res=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return res;
	}

}
