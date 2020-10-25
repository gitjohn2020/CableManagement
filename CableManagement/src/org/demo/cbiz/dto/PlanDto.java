package org.demo.cbiz.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.demo.cbiz.model.SubscriptionPlans;
import org.demo.cbiz.utility.DbUtil;

public class PlanDto {

	List<SubscriptionPlans> subList = null;
	SubscriptionPlans plan = null;

	public List<SubscriptionPlans> getPlans() {

		Connection conn = DbUtil.getConnection();

		try {
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("Select * from subscription_plans");

			if (rs != null) {
				subList = new ArrayList<>();
			}

			while (rs.next()) {
				plan = new SubscriptionPlans();
				plan.setId(rs.getLong(1));
				plan.setPlanName(rs.getString(2));
				plan.setPlanPrice(rs.getString(3));
				subList.add(plan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return subList;

	}

	public void addPlan(SubscriptionPlans plan) {

		Connection conn = DbUtil.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement("insert into subscription_plans(plan_name, plan_price)"
					+ " values(?,?) ");

			st.setString(1, plan.getPlanName());
			st.setString(2, plan.getPlanPrice());
			st.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	 public SubscriptionPlans openEditPlan(long planId) {
	  
		 SubscriptionPlans plan = new SubscriptionPlans();
	  
	  Connection conn = DbUtil.getConnection();
	  
	  try { PreparedStatement st =
	  conn.prepareStatement("select * from channels where id = ?"); 
	 // st.setLong(1,channelId); 
	  
	 // ResultSet rs = st.executeQuery(); 
	 // while(rs.next()) {
	//  channel.setId(rs.getLong(1)); channel.setChannelName(rs.getString(2));
	//  channel.setChannelType(rs.getString(3));
	//  channel.setChannelLanguage(rs.getString(4));
	//  channel.setChannelPrice(rs.getString(5)); }
	  
	  } catch(SQLException e) { e.printStackTrace(); }
	  
	  return plan; 
	  }
	  
	  public void editChannel(SubscriptionPlans channel) {
	  
	  Connection conn = DbUtil.getConnection();
	  
	  try { PreparedStatement st = conn.prepareStatement("update channels set " +
	  "channel_name=?, " + "channel_type=?, " + "channel_language=?, " +
	  "channel_price=?" + "where id = ?");
	  
	//  st.setString(1, channel.getChannelName()); 
	 // st.setString(2,channel.getChannelType());
	//  st.setString(3, channel.getChannelLanguage());
	//  st.setString(4, channel.getChannelPrice()); 
	//  st.setLong(5, channel.getId());	  
	//  st.executeUpdate();
	  
	  } catch (SQLException e)
	  { 
		  e.printStackTrace();
	  } 
	  }
	 
	  public void deleteChannel(SubscriptionPlans channel) {
	  
	 Connection conn = DbUtil.getConnection();
	 
	  try { 
		  PreparedStatement st = conn.prepareStatement("delete from channels where id = ?");
	  
	      st.setLong(1, channel.getId());
	  
	      st.executeUpdate();
	  
	  } catch (SQLException e) { e.printStackTrace(); }
	  
	  }
	 
}
