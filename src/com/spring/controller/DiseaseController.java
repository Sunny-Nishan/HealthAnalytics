package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DiseaseController {

	@RequestMapping(value="/viewDisease.html" , method=RequestMethod.GET)
	public String loadDisease()
	{
		return("admin/viewDisease");
		
	}

	@RequestMapping(value="/addDisease.html" , method=RequestMethod.GET)
	public String addDisease()
	{
		return("admin/addDisease");
		
	}
}