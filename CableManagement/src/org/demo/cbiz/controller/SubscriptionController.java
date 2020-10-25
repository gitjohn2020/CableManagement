package org.demo.cbiz.controller;

import java.util.Map;

import org.demo.cbiz.dto.SubscriptionDto;
import org.demo.cbiz.model.AdminUser;
import org.demo.cbiz.model.Subscribers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cbiz")
public class SubscriptionController {
	
	@Autowired
	private SubscriptionDto subDto;
	
	@Value("#{userTypes}") 
	private Map<String, String> userTypes;
	
	
	@RequestMapping("/newsubscribers")
	public String newSubscribers(Model subscriber) { 
		
		subscriber.addAttribute("subscriber", new Subscribers());
		subscriber.addAttribute("adminDtl", new AdminUser());
		subscriber.addAttribute("userTypes", userTypes);
		
		return "add-subscribers";
		
	}
	
	@RequestMapping("/addsubscriber")
	public String addSubscribers(@ModelAttribute("subscriber") Subscribers subscriberData, Model subscriberModel) {
		
		subDto.addSubscriber(subscriberData);
		
		subscriberModel.addAttribute("subscribers", subDto.getSubscriptions());
		subscriberModel.addAttribute("adminDtl", new AdminUser());
		
		return "admin-home";
		
	}
	
	@RequestMapping("/openeditsubscriber")
	public String openEditSubscriber(@ModelAttribute("subscriber") Subscribers subscriberData, Model subscriber) {

		subscriber.addAttribute("subscriber", subDto.openEditSubscriber(subscriberData.getId()));
		subscriber.addAttribute("adminDtl", new AdminUser());
		subscriber.addAttribute("userTypes", userTypes);
		
		return "edit-subscribers";
		
	}
	
	@RequestMapping("/editsubscriber")
	public String editSubscribers(@ModelAttribute("subscriber") Subscribers subscriberData, Model subscriberModel) {
		
		subDto.editSubscriber(subscriberData);
		
		subscriberModel.addAttribute("subscribers", subDto.getSubscriptions());
		subscriberModel.addAttribute("adminDtl", new AdminUser());
		
		return "admin-home";
		
	}
	
	@RequestMapping("/deletesubscriber")
	public String deleteSubscribers(@ModelAttribute("subscriber") Subscribers subscriberData, Model subscriberModel) {
		
		subDto.deleteSubscriber(subscriberData);
		
		subscriberModel.addAttribute("subscribers", subDto.getSubscriptions());
		subscriberModel.addAttribute("adminDtl", new AdminUser());
		
		return "admin-home";
		
	}

}
