package org.demo.cbiz.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.demo.cbiz.model.Channels;
import org.demo.cbiz.utility.DbUtil;

public class ChannelDto {

	List<Channels> subList = null;
	Channels channel = null;

	public List<Channels> getChannels() {

		Connection conn = DbUtil.getConnection();

		try {
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("Select * from channels");

			if (rs != null) {
				subList = new ArrayList<>();
			}

			while (rs.next()) {
				channel = new Channels();
				channel.setId(rs.getLong(1));
				channel.setChannelName(rs.getString(2));
				channel.setChannelType(rs.getString(3));
				channel.setChannelLanguage(rs.getString(4));
				channel.setChannelPrice(rs.getString(5));
				subList.add(channel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return subList;

	}

	public void addChannel(Channels channel) {

		Connection conn = DbUtil.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement("insert into Channels(channel_name, channel_type, channel_language, channel_price)"
					+ " values(?,?,?,?) ");

			st.setString(1, channel.getChannelName());
			st.setString(2, channel.getChannelType());
			st.setString(3, channel.getChannelLanguage());
			st.setString(4, channel.getChannelPrice());	
			st.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Channels openEditChannel(long channelId) {
		
		Channels channel = new Channels();
		
		Connection conn = DbUtil.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement("select * from channels where id = ?");
			st.setLong(1, channelId);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				channel.setId(rs.getLong(1));
				channel.setChannelName(rs.getString(2));
				channel.setChannelType(rs.getString(3));
				channel.setChannelLanguage(rs.getString(4));				
				channel.setChannelPrice(rs.getString(5));
			}
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return channel;
	}
	
	public void editChannel(Channels channel) {

		Connection conn = DbUtil.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement("update channels set "
					+ "channel_name=?, "
					+ "channel_type=?, "
					+ "channel_language=?, "
					+ "channel_price=?"
					+ "where id = ?");

			st.setString(1, channel.getChannelName());
			st.setString(2, channel.getChannelType());
			st.setString(3, channel.getChannelLanguage());
			st.setString(4, channel.getChannelPrice());
			st.setLong(5, channel.getId());
			
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteChannel(Channels channel) {

		Connection conn = DbUtil.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement("delete from channels where id = ?");

			st.setLong(1, channel.getId());
			
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
