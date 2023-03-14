package com.firstApp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	
	@GetMapping("/about")
	public String about(Model model)
	{
		System.out.println("Inside about handler !");
		
		model.addAttribute("name","Deepak Kumar");
		model.addAttribute("date",new Date().toLocaleString());
		
		return "about";  //returning page name i.e- about.html
	}
	
	
	@GetMapping("/loop")
	public String iterate(Model model) {

		List<String> list = List.of("Ram", "Shyam", "Rajat", "Swat");

		model.addAttribute("listOfElements", list);

		return "iterate";
	}
	
	
}
