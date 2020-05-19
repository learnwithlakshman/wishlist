package com.lwl.wishlist.web;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lwl.wishlist.UserDetailsUtil;
import com.lwl.wishlist.domain.Wishlist;
import com.lwl.wishlist.service.WishlistService;

@Controller
@RequestMapping("/wl/")
public class WishlistController {

	@Autowired
	private WishlistService wishlistService;

	@GetMapping("home")
	public String index(Model model) {
		model.addAttribute("user", UserDetailsUtil.getUserName());
		Set<String> wishlists = wishlistService.getWishLists();
		model.addAttribute("wishlists", wishlists);
		return "home";
	}

	@PostMapping("cwl")
	public String createWishList(@RequestBody Wishlist wishList, Model model) {
		
		return "redirect:wl/home";
	}
	@GetMapping("wliteams")
	public String getMyWishListitems() {
		return "wishlistitems";
	}
}
