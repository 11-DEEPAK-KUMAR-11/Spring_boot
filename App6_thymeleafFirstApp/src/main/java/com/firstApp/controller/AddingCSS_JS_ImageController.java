package com.firstApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddingCSS_JS_ImageController {

	@GetMapping("/cssJS")
	public String addCSSJSImage()
	{
		return "CSS_JS_Image";
	}
}
