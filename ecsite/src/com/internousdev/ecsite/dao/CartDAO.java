package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.CartDTO;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;
public class CartDAO {

private DBConnector dbConnector = new DBConnector();
private Connection con = dbConnector.getConnection();
private DateUtil dateUtil = new DateUtil();

private String sql = "INSERT INTO cart_list (item_name, total_price, total_count, user_master_id, pay, insert_date) VALUES(?, ?, ?, ?, ?, ?)";
CartDTO dto=new CartDTO();
int cnt=0;

public CartDTO cartAdd(int item_name, String user_master_id, int total_price, int total_count, String pay,String itemName) throws SQLException {
try {
	Connection con = dbConnector.getConnection();
	PreparedStatement preparedStatement = con.prepareStatement(sql);
	preparedStatement.setString(1, itemName);
	preparedStatement.setInt(2, total_price);
	preparedStatement.setInt(3, total_count);
	preparedStatement.setString(4, user_master_id);
	preparedStatement.setString(5, pay);
	preparedStatement.setString(6, dateUtil.getDate());
	preparedStatement.execute();
	dto.setTotalCount(total_count);
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		con.close();
	}
	return dto;
	}

	public ArrayList<CartDTO> getCartListInfo(String user_master_id)throws SQLException{
		ArrayList<CartDTO> CartList=new ArrayList<CartDTO>();
		String sql="SELECT * from cart_list WHERE user_master_id =?";
		try{
			Connection con = dbConnector.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1 , user_master_id);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				CartDTO dto=new CartDTO();
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setTotalPrice(rs.getInt("total_price"));
				dto.setTotalCount(rs.getInt("total_count"));
				dto.setUserName(rs.getString("user_master_id"));
				dto.setTotalCount(rs.getInt("total_count"));
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
				CartList.add(dto);
			}
			if(CartList.isEmpty()){
				 CartList=null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return CartList;
	}

	public int ItemHistoryDelete(String user_master_id)throws SQLException{
		Connection con = dbConnector.getConnection();
		String sql="DELETE FROM cart_list WHERE user_master_id =?";
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

	public int ItemHistoryDeleteIt(int id)throws SQLException{
		Connection con = dbConnector.getConnection();
		String sql="DELETE FROM cart_list WHERE id = ? ";
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
	public int getCartAmount(String user_master_id)throws SQLException{
		Connection con = dbConnector.getConnection();
		String sql="select SUM(total_count) as cnt from cart_list WHERE user_master_id =?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user_master_id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				cnt=rs.getInt("cnt");
			}

		}catch(Exception e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();{
	}
}
		return cnt;
	}
}