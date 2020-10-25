package org.demo.cbiz.model;

import java.util.List;

public class SubscriptionPlans {

	private long id;
	private String planName;
	private String planPrice;
	private List<Long> channelId;
	
	public SubscriptionPlans() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SubscriptionPlans(String planName, String planPrice) {
		super();
		this.planName = planName;
		this.planPrice = planPrice;
		//this.channelId = channelId;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanPrice() {
		return planPrice;
	}
	public void setPlanPrice(String planPrice) {
		this.planPrice = planPrice;
	}

	public List<Long> getChannelId() {
		return channelId;
	}

	public void setChannelId(List<Long> channelId) {
		this.channelId = channelId;
	}	
	
}
