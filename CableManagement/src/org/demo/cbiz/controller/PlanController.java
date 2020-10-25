package org.demo.cbiz.controller;

import java.util.Map;

import org.demo.cbiz.dto.ChannelDto;
import org.demo.cbiz.dto.PlanDto;
import org.demo.cbiz.model.AdminUser;
import org.demo.cbiz.model.SubscriptionPlans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cbiz")
public class PlanController {

	@Autowired
	private PlanDto plDto;
	
	@Autowired
	private ChannelDto chDto;

	@Value("#{userTypes}")
	private Map<String, String> userTypes;

	@RequestMapping("/newplans")
	public String newPlans(Model plan) {

		plan.addAttribute("plan", new SubscriptionPlans());
		plan.addAttribute("adminDtl", new AdminUser());
		plan.addAttribute("userTypes", userTypes);
		return "add-plan";

	}
	
	
	  @RequestMapping("/viewplan") public String viewPlans(@ModelAttribute("plan") SubscriptionPlans planData,Model planModel) { planModel.addAttribute("plans",
	  plDto.getPlans()); //planModel.addAttribute("adminDtl", new AdminUser());
	  return "view-plan";
	  
	  }
	 

	@RequestMapping("/addplan")
	public String addPlans(@ModelAttribute("plan") SubscriptionPlans planData, Model planModel) {

		plDto.addPlan(planData);
		planModel.addAttribute("plans", plDto.getPlans());
		planModel.addAttribute("channels", chDto.getChannels());
		planModel.addAttribute("adminDtl", new AdminUser());
		return "view-plan";

	}

	
	  @RequestMapping("/openeditplan") 
	  public String openEditChannel(@ModelAttribute("plan") SubscriptionPlans planData, Model channel) 
	  { 
	   System.out.println("ID=====> "+planData.getId());
	  // planData.addAttribute("plan", plDto.openEditChannel(channelData.getId()));
	  // planData.addAttribute("adminDtl", new AdminUser());
	  // planData.addAttribute("userTypes", userTypes);
	  
	  return "edit-plan";
	  
	  }
	  
	  @RequestMapping("/editplan") 
	  public String editChannels(@ModelAttribute("channel") SubscriptionPlans planData, Model channelModel) 
	  {
	  
	  //plDto.editChannel(channelData);
	  
	 // channelModel.addAttribute("channels", plDto.getChannels());
	  //channelModel.addAttribute("adminDtl", new AdminUser());
	  
	  return "view-plan";
	  
	  }
	  
	  @RequestMapping("/deleteplan") public String deleteChannels(@ModelAttribute("channel") SubscriptionPlans planData, Model
	  channelModel) 
	  {
	  
	 // plDto.deleteChannel(channelData);
	  
	//  channelModel.addAttribute("channels", chDto.getChannels());
	//  channelModel.addAttribute("adminDtl", new AdminUser());
	  
	  return "view-plan";
	  
	  }	 

}
