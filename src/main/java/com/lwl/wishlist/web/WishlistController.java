package com.lwl.wishlist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wl/")
public class WishlistController {
	
		@GetMapping("home")
		public String index(Model model) {
			model.addAttribute("user", "Rajesh");
			model.addAttribute("names","Lakshman,Rajesh,Mahesh,Suresh".split(","));
			return "home";
		}
}
