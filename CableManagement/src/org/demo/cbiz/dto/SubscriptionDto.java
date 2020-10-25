package org.demo.cbiz.dto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.demo.cbiz.model.Subscribers;
import org.demo.cbiz.utility.DbUtil;

public class SubscriptionDto {

	List<Subscribers> subList = null;
	Subscribers subscriber = null;

	public List<Subscribers> getSubscriptions() {

		Connection conn = DbUtil.getConnection();

		try {
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("Select * from subscribers");

			if (rs != null) {
				subList = new ArrayList<>();
			}

			while (rs.next()) {
				subscriber = new Subscribers();

				subscriber.setId(rs.getLong(1));
				subscriber.setFirstName(rs.getString(2));
				subscriber.setLastName(rs.getString(3));
				subscriber.setEmail(rs.getString(4));
				// subscriber.setPassword(rs.getString(5));
				subscriber.setActivatedOn(rs.getDate(6));
				subscriber.setDeactivatedOn(rs.getDate(7));
				subscriber.setActive((rs.getInt(8) == 1 ? true : false));
				subscriber.setUserType(rs.getString(9));

				subList.add(subscriber);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return subList;

	}

	public void addSubscriber(Subscribers subscriber) {

		Connection conn = DbUtil.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement("insert into subscribers(first_name,last_name,email,password,activated_on,deactivated_on,is_active,user_type)"
					+ " values(?,?,?,?,?,?,?,?) ");

			st.setString(1, subscriber.getFirstName());
			st.setString(2, subscriber.getLastName());
			st.setString(3, subscriber.getEmail());
			st.setString(4, subscriber.getPassword());
			if (subscriber.isActive()) {
				st.setDate(5, new Date(System.currentTimeMillis()));
			} else {
				st.setDate(5, null);
			}
			st.setDate(6, null);
			st.setBoolean(7, subscriber.isActive());
			st.setString(8, subscriber.getUserType());
			
			st.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Subscribers openEditSubscriber(long subscriberId) {
		
		Subscribers subscriber = new Subscribers();
		
		Connection conn = DbUtil.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement("select * from subscribers where id = ?");
			st.setLong(1, subscriberId);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				subscriber.setId(rs.getLong(1));
				subscriber.setFirstName(rs.getString(2));
				subscriber.setLastName(rs.getString(3));
				subscriber.setEmail(rs.getString(4));
				// subscriber.setPassword(rs.getString(5));
				subscriber.setActivatedOn(rs.getDate(6));
				subscriber.setDeactivatedOn(rs.getDate(7));
				subscriber.setActive((rs.getInt(8) == 1 ? true : false));
				subscriber.setUserType(rs.getString(9));
			}
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return subscriber;
	}
	
	public void editSubscriber(Subscribers subscriber) {

		Connection conn = DbUtil.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement("update subscribers set "
					+ "first_name=?, "
					+ "last_name=?, "
					+ "email=?, "
					+ "activated_on=?, "
					+ "deactivated_on=?, "
					+ "is_active=?, "
					+ "user_type=? "
					+ "where id = ?");

			st.setString(1, subscriber.getFirstName());
			st.setString(2, subscriber.getLastName());
			st.setString(3, subscriber.getEmail());
			
			
			if (subscriber.isActive()) {
				st.setDate(4, new Date(System.currentTimeMillis()));
				st.setDate(5, null);
				
			} else {
				st.setDate(4, null);
				st.setDate(5, new Date(System.currentTimeMillis()));
			}
			
			st.setBoolean(6, subscriber.isActive());
			st.setString(7, subscriber.getUserType());
			st.setLong(8, subscriber.getId());
			
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteSubscriber(Subscribers subscriber) {

		Connection conn = DbUtil.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement("delete from subscribers where id = ?");

			st.setLong(1, subscriber.getId());
			
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
