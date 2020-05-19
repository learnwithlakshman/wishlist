package com.lwl.wishlist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

	@GetMapping("/")
	public String redirect() {
		return "redirect:wl/home";
	}

}
