package org.demo.cbiz.model;

import java.util.List;

public class SubscriptionPlansDetail {

	private long id;
	private long planId;
	//private Integer channelId;
	private List<Long> channelId;
	
	public SubscriptionPlansDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SubscriptionPlansDetail(long planId, List<Long> channelId) {
		super();
		this.planId = planId;		
		this.channelId = channelId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPlanId() {
		return planId;
	}

	public void setPlanId(long planId) {
		this.planId = planId;
	}

	public List<Long> getChannelId() {
		return channelId;
	}

	public void setChannelId(List<Long> channelId) {
		this.channelId = channelId;
	}

}
