package com.uncodigo.springboot.error.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@GetMapping("/")
	public String index(Model model) {
		
		
//		Integer valor = 100/0;
		Integer valor = Integer.parseInt("10_");
		
		return "index";
	}

}
