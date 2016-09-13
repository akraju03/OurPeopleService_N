package com.ourpeople.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.ourpeople.models.UserDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserDao {

	private static final String GET_USER_QUERY = "select id,email,phone,is_verified,password,community_id,name from people where name =? and password= ?";

	public UserDetails userDetails = new UserDetails();

	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://sql6.freesqldatabase.com:3306/sql6134953";

	// Database credentials
	final String USER = "sql6134953";
	final String PASS = "hMnIGYhtnP";

	PreparedStatement statement = null;
	ResultSet resultSet = null;
	Connection connection = null;

	public UserDetails getUserDetails(String name, String password) {
		/*
		 * try { // STEP 2: Register JDBC driver Class.forName(JDBC_DRIVER);
		 * 
		 * connection = DriverManager.getConnection(DB_URL, USER, PASS);
		 * statement = connection.prepareStatement(GET_USER_QUERY);
		 * statement.setString(1, name); statement.setString(2, password);
		 * resultSet = statement.executeQuery();
		 * 
		 * while(resultSet.next()){ userDetails.setId(resultSet.getString(1)); }
		 * 
		 * resultSet.close(); statement.close(); connection.close(); } catch
		 * (SQLException se) { // Handle errors for JDBC se.printStackTrace(); }
		 * catch (Exception e) { // Handle errors for Class.forName
		 * e.printStackTrace(); } finally { } // end try
		 */

		try {

			DbUtils.loadDriver(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);

			QueryRunner qRunner = new QueryRunner();
			@SuppressWarnings({ "rawtypes", "unchecked" })
			List beans = (List) qRunner
					.query(connection,
							"select id,email,phone,is_verified,password,community_id,name from people where name='"
									+ name + "' and password='" + password + "'",
							new BeanListHandler(UserDetails.class));

			if(beans.size() != 0){
				userDetails = (UserDetails) beans.get(0);
			}

		} catch (SQLException e) {
			// handle the exception
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(connection);
		}
		return userDetails;
	}
}
