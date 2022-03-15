package com.jjh.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/test")
public class TestController {
	@RequestMapping("/invoke")
	@ResponseBody
	public String test() {
		return "invoke";
	}
}
