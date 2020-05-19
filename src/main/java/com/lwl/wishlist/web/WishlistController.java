package com.lwl.wishlist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lwl.wishlist.UserDetailsUtil;
import com.lwl.wishlist.service.WishlistService;

@Controller
@RequestMapping("/wl/")
public class WishlistController {
		
		@Autowired
		private WishlistService wishlistService;
		
		@GetMapping("home")
		public String index(Model model) {
			model.addAttribute("user", UserDetailsUtil.getUserName());
			wishlistService.getWishlist();
			model.addAttribute("names","Lakshman,Rajesh,Mahesh,Suresh".split(","));
			return "home";
		}
}
