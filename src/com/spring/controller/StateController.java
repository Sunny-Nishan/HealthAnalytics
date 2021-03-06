package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.jboss.logging.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.DAO.CountryDAO;
import com.spring.DAO.StateDAO;
import com.spring.VO.CountryVO;
import com.spring.VO.StateVO;

@Controller
@RequestMapping("/admin")
public class StateController {

	@Autowired
	StateDAO state;

	@Autowired
	CountryDAO country;

	@RequestMapping(value = "/viewState.html", method = RequestMethod.GET)
	public String loadState(HttpSession session) {
		try {
			List<Object> stateList = this.state.getAllState();
			session.setAttribute("list", stateList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ("admin/viewState");

	}

	@RequestMapping(value = "/deleteState.html", method = RequestMethod.GET)
	public String deleteState(@RequestParam("id") int id) {
			
		try {
			
			state.deleteState(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ("redirect:/admin/viewState.html");
	}

	@RequestMapping(value = "/addState.html", method = RequestMethod.GET)
	public ModelAndView addState(HttpSession session) {
		try {
			List<Object> ls = this.country.getCountry();
			session.setAttribute("list", ls);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("admin/addState", "insertState", new StateVO());

	}
	
	@RequestMapping(value = "/editState.html", method = RequestMethod.GET)
	public ModelAndView editState(@RequestParam("id") int id, HttpSession session) {
		try {
			List<Object> ls = state.editState(id);
			session.setAttribute("list",ls);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("admin/editState", "updateState", new StateVO());
	}
	

	@RequestMapping(value = "/insertState.html", method = RequestMethod.POST)
	public ModelAndView insertState(@ModelAttribute StateVO insertState) {
		try {
			this.state.insertState(insertState);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/admin/addState.html");

	}
	@RequestMapping(value = "/updateState.html", method = RequestMethod.POST)
	public ModelAndView updateState(@ModelAttribute StateVO updateState) {
		try {
			this.state.insertState(updateState);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/viewState.html");

	}
	@RequestMapping(value="/getStateUsingAjax.html", method=RequestMethod.GET)
	public String getStateUsingAjax(@RequestParam("countryId") int countryId, HttpSession session){
		try {
			List<Object> list = state.getStateAjax(countryId);
			session.setAttribute("list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ("admin/getStateUsingAjax");
		
		
	}
	@RequestMapping(value="/searchStateDataUsingAjax.html", method=RequestMethod.POST)
	public String searchStateUsingAjax(@RequestParam("keywords") String keywords,HttpSession session){

	
		try {
			List list = state.searchStateAjax(keywords);
			session.setAttribute("list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return ("admin/searchStateDataUsingAjax");
	}
	@RequestMapping(value="/verifyStateExist.html", method=RequestMethod.GET)

	public String verifyStateUsingAjax(@Param String keywords,HttpSession session,Model model) throws Exception{
		
		
			List list = state.searchStateAjax(keywords);
			if(list.isEmpty())
			{
			model.addAttribute("flag",0);	
			
			}
			else{
				model.addAttribute("flag", 1);
			}

				return ("admin/verifyStateUsingAjax");
				}
				
	
	@RequestMapping(value="/deleteStateisActive.html" , method=RequestMethod.GET)
	public String updateisActive(@Param int id, HttpSession session) throws Exception
	{
		this.state.updateIsactive(id);
		/*List<Object> ls = this.country.getCountry();
		session.setAttribute("list",ls);*/
		return("redirect:/admin/viewState.html");
		
	}

	}


	
	

