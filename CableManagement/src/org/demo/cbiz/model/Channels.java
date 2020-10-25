package org.demo.cbiz.model;

public class Channels {
	
	private long id;
	private String channelName;
	private String channelType;
	private String channelLanguage;
	private String channelPrice;
	
	public Channels() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Channels(String channelName, String channelType, String channelLanguage, String channelPrice) {
		super();
		this.channelName = channelName;
		this.channelType = channelType;
		this.channelLanguage = channelLanguage;
		this.channelPrice = channelPrice;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public String getChannelType() {
		return channelType;
	}
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
	public String getChannelLanguage() {
		return channelLanguage;
	}
	public void setChannelLanguage(String channelLanguage) {
		this.channelLanguage = channelLanguage;
	}
	public String getChannelPrice() {
		return channelPrice;
	}
	public void setChannelPrice(String channelPrice) {
		this.channelPrice = channelPrice;
	}

}
