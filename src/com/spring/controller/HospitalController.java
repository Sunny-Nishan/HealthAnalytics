package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.DAO.CountryDAO;
import com.spring.DAO.HospitalDAO;
import com.spring.VO.HospitalVO;

@Controller
public class HospitalController {
	
	@Autowired
	CountryDAO country;
	@Autowired
	HospitalDAO hospital;
	
 	
	@RequestMapping(value="/viewHospital.html" , method=RequestMethod.GET)
	public String loadHospital()
	{
		return("admin/viewHospital");
		
	}

	@RequestMapping(value="/addHospital.html" , method=RequestMethod.GET)
	public ModelAndView addHospital(HttpSession session) throws Exception
	{
		List<Object> list = this.country.getCountry();
		session.setAttribute("list",list);
		return new ModelAndView("admin/addHospital","insertHospital",new HospitalVO());
		
	}
	
	@RequestMapping(value="/insertHospital.html" , method=RequestMethod.POST)
	public ModelAndView insertHospital(@ModelAttribute HospitalVO insertHospital)
	{
		try {
			this.hospital.insertHospital(insertHospital);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/addHospital.html");
		
	}
}
