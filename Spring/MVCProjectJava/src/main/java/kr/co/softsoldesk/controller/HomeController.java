package kr.co.softsoldesk.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.softsoldesk.beans.UserBean;

@Controller
public class HomeController {

/*
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;
*/
	
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		//System.out.println(loginUserBean);
		System.out.println(request.getServletContext().getRealPath("/"));
		return "redirect:/main";
	}
	
	
	
}
