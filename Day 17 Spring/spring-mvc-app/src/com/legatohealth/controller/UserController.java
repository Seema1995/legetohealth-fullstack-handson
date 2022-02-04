package com.legatohealth.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.legatohealth.beans.User;
import com.legatohealth.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	//1
	@RequestMapping(value="/store", method = RequestMethod.POST)
	public ModelAndView save(@RequestParam("n1")String name,
			@RequestParam("n2")String password,
			@RequestParam("n3") int age) {
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		user.setAge(age);
		service.storeUser(user);
		
		ModelAndView mav = new ModelAndView("store","msg","Stored successfully");
		return mav;
	}
	
	
	//2
	@RequestMapping(value ="/showAllUsers", method=RequestMethod.GET)
	public ModelAndView showUsers() {
		List<User> users = service.fetchAllUsers();
		//m.addAttribute("users", users)
		return new ModelAndView("displayAllUsers","users",users);
	}
	
	@RequestMapping(value ="/showUserId")
	public ModelAndView showUser() {
		return new ModelAndView("displayUserIdForm");
	}
	
	//3
	@RequestMapping(value="/showByUserID" , method=RequestMethod.POST)
	public ModelAndView showUsersById(@RequestParam("n1") int id) {
		User users = service.fetchUser(id);
		//m.addAttribute("users", users)
		return new ModelAndView("displayUser","user",users);
	}
	
	@RequestMapping(value ="/deleteById")
	public ModelAndView deleteUser() {
		return new ModelAndView("deleteByIdForm");
	}
	
	//3
	@RequestMapping(value="/deleteByUserID" , method=RequestMethod.POST)
	public ModelAndView deleteByUserId(@RequestParam("n1") int id) {
		service.deleteUser(id);
		//m.addAttribute("users", users)
		return new ModelAndView("displayDeletedUser","msg","Deleted successfully");
	}
	
	
	@RequestMapping(value="/time", method = RequestMethod.GET)
	public ModelAndView getTime() {
		LocalDateTime datetime = LocalDateTime.now();
		ModelAndView mav = new ModelAndView("welcome","date",datetime);
		return mav;
	}
}
