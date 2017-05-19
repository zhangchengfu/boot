package com.laozhang.hello.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.laozhang.hello.service.UserService;

@Controller
public class IndexController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value={"","/"})
	public String index() {
		return "index.jsp";
	}
	
	@ResponseBody
	@RequestMapping("finduser")
	public String findUser() {
		return JSON.toJSONString(userService.findAll());
	}
	
	@ResponseBody
	@RequestMapping("user/{id}")
	public String findById(@PathVariable int id) {
		return JSON.toJSONString(userService.findOne(id));
	}
}
