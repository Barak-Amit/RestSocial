package com.baraka.social.controller;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baraka.social.dataservice.UserDataService;

@Controller
public class WebController {

	private UserDataService dataService;
	private MessageSource messageSource;

	public WebController(UserDataService dataService, MessageSource messageSource) {
		super();
		this.dataService = dataService;
		this.messageSource=messageSource;
	}

	@RequestMapping(value = "/index")
	public ModelAndView index() {
		return new ModelAndView("/index", "name", "Rahul");
	}
}
