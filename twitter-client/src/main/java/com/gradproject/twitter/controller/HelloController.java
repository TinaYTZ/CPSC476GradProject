package com.gradproject.twitter.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(HelloController.Base_URI)
public class HelloController {
	public static final String Base_URI="/";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView printWelcome() {
		ModelAndView model = new ModelAndView("hello");
		return model;
	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView("hello");
		model.setViewName("hello");
		model.addObject("name", name);

		return model;

	}
	
}