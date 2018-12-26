package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {
	private DBConnector db=new DBConnector();
	private Connection con= db.getConnection();

	public ArrayList<UserListDTO> getUserListInfo()throws SQLException{
		ArrayList<UserListDTO> UserListList=new ArrayList<UserListDTO>();
		String sql="SELECT * from login_user_transaction";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				UserListDTO dto=new UserListDTO();
				dto.setId(rs.getInt("id"));
				dto.setUserId(rs.getString("login_id"));
				dto.setUserPassword(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				dto.setInsertDate(rs.getString("insert_date"));
				UserListList.add(dto);
			}
			if(UserListList.isEmpty()){
				 UserListList=null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return UserListList;

	}
	public int UserHistoryDelete()throws SQLException{
		String sql="DELETE FROM login_user_transaction";
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
	public int UserHistoryDeleteIt(int id)throws SQLException{
		String sql="DELETE FROM login_user_transaction WHERE id = ?";
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
