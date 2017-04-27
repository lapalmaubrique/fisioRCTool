package com.fisiorctool.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (logout != null) {
			model.addObject("msg", "Has sido desconectado");
		}
		model.setViewName("login");

		return model;
	}
	
	@RequestMapping(value = "/login_error", method = RequestMethod.POST)
	public ModelAndView login_error(HttpServletRequest request) {
		String error = (String) request.getAttribute("error");
		ModelAndView model = new ModelAndView();
		model.addObject("error", error);
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value = "/activeUser/{token}", method = RequestMethod.GET)
	public ModelAndView activeUser(@PathVariable String token) {

		ModelAndView model = new ModelAndView();
		if (token != null) {
			model.addObject("token", token);
		}
		model.setViewName("activeUser");

		return model;
	}
	
}
