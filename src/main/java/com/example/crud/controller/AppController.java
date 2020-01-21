package com.example.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	@RequestMapping(value = "/**/{[path:[^\\.]*}")
	public String redirectUi() {
		return "forward:index.html";
	}
}
