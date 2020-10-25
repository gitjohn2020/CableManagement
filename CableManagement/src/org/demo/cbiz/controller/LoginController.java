package org.demo.cbiz.controller;

import org.demo.cbiz.dto.SubscriptionDto;
import org.demo.cbiz.model.AdminUser;
import org.demo.cbiz.model.Subscribers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cbiz")
public class LoginController {
	
	@Autowired
	private SubscriptionDto subDto;
	
	@RequestMapping("/login")
	public String showSubscriberDetails(Model subscriberModel) {
		
		subscriberModel.addAttribute("subscribers", subDto.getSubscriptions());
		subscriberModel.addAttribute("adminDtl", new AdminUser());
		subscriberModel.addAttribute("subscriber", new Subscribers());
		
		return "admin-home";
		
	}
	
}
