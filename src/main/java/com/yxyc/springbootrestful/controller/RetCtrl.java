package com.yxyc.springbootrestful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RetCtrl {
	@RequestMapping("/hello")
	public String toInd(){

		System.out.println("request enter into ...");
		return "index";
	}
}
