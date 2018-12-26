package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;
public class BuyItemCompleteDAO {

private DBConnector dbConnector = new DBConnector();
private Connection connection = dbConnector.getConnection();
private DateUtil dateUtil = new DateUtil();
private String sql = "INSERT INTO user_buy_item_transaction SELECT * FROM cart_list";
private String sqlUpd = "UPDATE cart_list SET insert_date = ?";
private String sqlDlt ="DELETE FROM cart_list";

public void buyItemInfo() throws SQLException {
	try {
		Connection connection = dbConnector.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sqlUpd);
		preparedStatement.setString(1, dateUtil.getDate());
		preparedStatement.executeUpdate();
		} catch(Exception e) {
		e.printStackTrace();
		} finally {
		connection.close();

		}
	try {
		Connection connection = dbConnector.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.execute();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	try {
		Connection connection = dbConnector.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sqlDlt);
		preparedStatement.executeUpdate();
		} catch(Exception e) {
		e.printStackTrace();
		} finally {
		connection.close();

		}
	}
}
