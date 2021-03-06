package com.spring.controller;


import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.logging.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.DAO.InsertDAO;
import com.spring.DAO.RegistationDAO;
import com.spring.VO.DoctorVO;
import com.spring.VO.LoginVO;
import com.spring.VO.PatientVO;
import com.spring.VO.RegistrationVO;

@Controller
public class RegistrationController {

	@Autowired	
	private InsertDAO insert;
	@Autowired
	RegistationDAO registration;
	
	@RequestMapping(value="/registration.html" , method=RequestMethod.GET)
	public ModelAndView loadRegistration(HttpSession session) throws Exception
	{	
		List<Object> loginlist=this.registration.getUsername();
		session.setAttribute("loginlist",loginlist);
		
		return new ModelAndView("client/registration","insertUser", new RegistrationVO());
		
	}
	@RequestMapping(value="/register.html" , method=RequestMethod.POST)
	public String registerUser(@ModelAttribute RegistrationVO insertUser, @Param String userName,
			@Param String password,@Param String userType,@Param String gender ,@Param String userprofileImage, HttpServletRequest request) throws Exception
	{	
		LoginVO login = new LoginVO();
		login.setUserType(userType);
		login.setUsername(userName);
		login.setPassword(password);
		login.setUserprofileImage(userprofileImage);
		if(userType.equalsIgnoreCase("patient"))
		{
		login.setRole("ROLE_USER");
		}
		else
		{
			login.setRole("ROLE_DOCTOR");
		}
		login.setEnabled(1);
		insert.insertObject(login);
		insertUser.setLogin(login);
		insertUser.setGender(gender);
		insert.insertObject(insertUser);
		if(userType.equalsIgnoreCase("doctor"))
		{
		DoctorVO doctor=new DoctorVO();
		doctor.setRegistration(insertUser);
		insert.insertObject(doctor);
		}
		else if(userType.equalsIgnoreCase("patient"))
		{
			PatientVO patient =new PatientVO();
			patient.setRegistration(insertUser);
			insert.insertObject(patient);
		}
		String email=request.getParameter("email");
		
		String to=email;
		 Properties props = new Properties();  
		  props.put("mail.smtp.host", "smtp.gmail.com");  
		  props.put("mail.smtp.socketFactory.port", "465");  
		  props.put("mail.smtp.socketFactory.class",  
		            "javax.net.ssl.SSLSocketFactory");  
		  props.put("mail.smtp.auth", "true");  
		  props.put("mail.smtp.port", "465");  
		   
		  Session session = Session.getDefaultInstance(props,  
		   new javax.mail.Authenticator() {  
		   protected PasswordAuthentication getPasswordAuthentication() {  
		   return new PasswordAuthentication("parththakkar02@gmail.com","monster1234");//change accordingly  
		   }  
		  });  
		  
		  try {  
			  String fn=request.getParameter("firstName");
				String ln=request.getParameter("lastName");
			   MimeMessage message = new MimeMessage(session);  
			   message.setFrom(new InternetAddress("parththakkar02@gmail.com"));//change accordingly  
			   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
			   message.setSubject("Account Created");  
			   message.setText("Hello "+fn+" "+ln+","+"\r\n Thank you for registering at My website");  
			     
			   //send message  
			   Transport.send(message);  
			  
			   System.out.println("message sent successfully");  
			   
			  } catch (MessagingException e) {throw new RuntimeException(e);}  
			   
			  
		
		return("redirect:/login.html");
		
	}
	@RequestMapping(value="/xyz.html" , method=RequestMethod.GET)
	public String login(){
		return ("client/login");
	}
	
}
