package org.demo.cbiz.controller;

import java.util.Map;

import org.demo.cbiz.dto.ChannelDto;
import org.demo.cbiz.model.AdminUser;
import org.demo.cbiz.model.Channels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cbiz")
public class ChannelController {
	
	@Autowired
	private ChannelDto chDto;
	
	@Value("#{userTypes}") 
	private Map<String, String> userTypes;
	
	
	@RequestMapping("/newchannels")
	public String newChannels(Model channel) {
		
		channel.addAttribute("channel", new Channels());
		channel.addAttribute("adminDtl", new AdminUser());
		channel.addAttribute("userTypes", userTypes);
		
		return "add-channels";
		
	}
	
	@RequestMapping("/addchannel")
	public String addChannels(@ModelAttribute("channel") Channels channelData, Model channelModel) {
		
		chDto.addChannel(channelData);
		
		channelModel.addAttribute("channels", chDto.getChannels());
		channelModel.addAttribute("adminDtl", new AdminUser());
		
		return "view-channels";
		
	}
	
	@RequestMapping("/openeditchannel")
	public String openEditChannel(@ModelAttribute("channel") Channels channelData, Model channel) {
		System.out.println("ID=====> "+channelData.getId());
		channel.addAttribute("channel", chDto.openEditChannel(channelData.getId()));
		channel.addAttribute("adminDtl", new AdminUser());
		channel.addAttribute("userTypes", userTypes);
		
		return "edit-channels";
		
	}
	
	@RequestMapping("/editchannel")
	public String editChannels(@ModelAttribute("channel") Channels channelData, Model channelModel) {
		
		chDto.editChannel(channelData);
		
		channelModel.addAttribute("channels", chDto.getChannels());
		channelModel.addAttribute("adminDtl", new AdminUser());
		
		return "view-channels";
		
	}
	
	@RequestMapping("/deletechannel")
	public String deleteChannels(@ModelAttribute("channel") Channels channelData, Model channelModel) {
		
		chDto.deleteChannel(channelData);
		
		channelModel.addAttribute("channels", chDto.getChannels());
		channelModel.addAttribute("adminDtl", new AdminUser());
		
		return "view-channels";
		
	}

}
