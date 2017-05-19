package com.laozhang.shiro.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login() {
		return "login.jsp";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(HttpServletRequest request, RedirectAttributes rediect) {
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		
		UsernamePasswordToken upt = new UsernamePasswordToken(account, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(upt);
		} catch (Exception e) {
			rediect.addFlashAttribute("errorText", "您的账号或密码输入错误!");
			return "redirect:/login";
		}
		return "redirect:/index";
	}
	
}
