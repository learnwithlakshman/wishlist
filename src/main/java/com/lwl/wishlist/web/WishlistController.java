package com.lwl.wishlist.web;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lwl.wishlist.UserDetailsUtil;
import com.lwl.wishlist.domain.Wishlist;
import com.lwl.wishlist.domain.WishlistItem;
import com.lwl.wishlist.service.WishlistService;

@Controller
@RequestMapping("/wl/")
public class WishlistController {

	@Autowired
	private WishlistService wishlistService;

	@GetMapping("home")
	public String index(Model model) {
		model.addAttribute("user", UserDetailsUtil.getUserName());
		model.addAttribute("wishlist", new Wishlist());
		Set<String> wishlists = wishlistService.getWishLists();
		model.addAttribute("wishlists", wishlists);
		return "home";
	}

	@PostMapping("cwl")
	public String createWishList(@ModelAttribute("wishlist") Wishlist wishList) {
		System.out.println(wishList.getName());
		wishlistService.createWishList(wishList);
		return "redirect:/wl/home";
	}

	@GetMapping("wlitems")
	public String getMyWishListitems(@RequestParam("wl") String wishListName,Model model,HttpServletRequest request) {
		request.getSession().setAttribute("wlname", wishListName);
		List<WishlistItem> list = wishlistService.getWishListItems(wishListName);
		model.addAttribute("wlitem", new WishlistItem());
		model.addAttribute("wlname", wishListName);
		model.addAttribute("items", list);
		return "wishlistitems";
	}

	@PostMapping("additem")
	public String addItemToWishList(@ModelAttribute("wlitem") WishlistItem wishListItem, Model model,
			HttpSession session) {
		String wishListName = session.getAttribute("wlname").toString();
		wishlistService.addItemToWishList(wishListName, wishListItem);		
		List<WishlistItem> list = wishlistService.getWishListItems(wishListName);
		model.addAttribute("wlitem", new WishlistItem());
		model.addAttribute("wlname", wishListName);
		model.addAttribute("items", list);
		return "wishlistitems";
	}
}
