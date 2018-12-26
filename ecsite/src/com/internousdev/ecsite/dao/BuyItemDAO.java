package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {
	private DBConnector db=new DBConnector();
	private Connection con=db.getConnection();
	private BuyItemDTO dto=new BuyItemDTO();
	List<BuyItemDTO> BuyItemDTOList=new ArrayList<BuyItemDTO>();




	public List<BuyItemDTO> getBuyItemNextInfo(){
		String sql="select id, item_name, item_price from item_info_transaction";
		try{
			PreparedStatement ps= con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				BuyItemDTO dto=new BuyItemDTO();
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				BuyItemDTOList.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return BuyItemDTOList;
	}

	public BuyItemDTO getBuyItemDTO(){
		return dto;
	}

}
