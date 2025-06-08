package kr.co.softsoldesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.co.softsoldesk.service.UserService;

@RestController
public class RestApiController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user/isUserIdAvailable/{user_id}")
	public boolean isUserIdAvailable(@PathVariable String user_id) {
		
		boolean chk = userService.isUserIdAvailable(user_id);
		
		return chk;
	}
	
}
