package com.example.first.helloController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping("/api/user")
	public String UserAccess() {
		return "Hello user! you are authenticated";
	}
	
	@GetMapping("/api/admin")
	public String adminAccess() {
		return "Hello Admin! You are authenticated";
	}

}
