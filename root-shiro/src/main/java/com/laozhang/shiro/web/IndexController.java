package com.laozhang.shiro.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping(value={"", "/", "index"})
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("unauthor")
	public String unauthor() {
		return "unauthor.jsp";
	}
	
	@RequestMapping("reports")
	public String reports() {
		return "reports.jsp";
	}
}
