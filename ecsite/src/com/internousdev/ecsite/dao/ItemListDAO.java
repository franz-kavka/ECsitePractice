package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO {
	private DBConnector db=new DBConnector();
	private Connection con= db.getConnection();

	public ArrayList<ItemListDTO> getItemListUserInfo()throws SQLException{
		ArrayList<ItemListDTO> ItemListList=new ArrayList<ItemListDTO>();
		String sql="SELECT * from item_info_transaction";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				ItemListDTO dto=new ItemListDTO();
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItemStock(rs.getString("item_stock"));
				dto.setDate(rs.getString("insert_date"));
				ItemListList.add(dto);
			}
			if(ItemListList.isEmpty()){
				 ItemListList=null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return ItemListList;

	}
	public int ItemHistoryDelete()throws SQLException{
		String sql="DELETE FROM item_info_transaction";
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

	public int ItemHistoryDeleteIt(int id)throws SQLException{
		String sql="DELETE FROM item_info_transaction WHERE id = ?";
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
