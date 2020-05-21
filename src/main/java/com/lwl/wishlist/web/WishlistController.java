package com.lwl.wishlist.web;

import java.util.List;

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
import com.lwl.wishlist.dto.WishListDTO;
import com.lwl.wishlist.dto.WishListItemDTO;
import com.lwl.wishlist.service.WishListService;

import lombok.Getter;

@Controller
@RequestMapping("/wl/")
public class WishlistController {

	@Autowired
	private WishListService wishlistService;

	@GetMapping("home")
	public String index(Model model) {
		model.addAttribute("user", UserDetailsUtil.getUserName());
		model.addAttribute("wishlist", new Wishlist());
		List<WishListDTO> wishlists = wishlistService.getWishLists();
		model.addAttribute("wishlists", wishlists);
		return "home";
	}

	@PostMapping("cwl")
	public String createWishList(@ModelAttribute("wishlist") Wishlist wishList) {
		wishlistService.createWishList(wishList);
		return "redirect:/wl/home";
	}

	@GetMapping("wlitems")
	public String getMyWishListitems(@RequestParam("refid") int refid, Model model, HttpServletRequest request) {
		request.getSession().setAttribute("refid", refid);
		Wishlist wishList = wishlistService.getWishList(refid);
		List<WishListItemDTO> list = wishlistService.getWishListItems(refid);
		model.addAttribute("wlitem", new WishlistItem());
		model.addAttribute("wl", wishList);
		model.addAttribute("items", list);
		return "wishlistitems";
	}

	@PostMapping("additem")
	public String addItemToWishList(@ModelAttribute("wlitem") WishlistItem wishListItem, Model model,
			HttpSession session) {
		int refid = Integer.parseInt(session.getAttribute("refid").toString());
		wishListItem.setRefid(refid);
		Wishlist wishList = wishlistService.getWishList(refid);
		wishlistService.addItemToWishList(wishListItem);
		List<WishListItemDTO> list = wishlistService.getWishListItems(refid);
		model.addAttribute("wlitem", new WishlistItem());
		model.addAttribute("wl", wishList);
		model.addAttribute("items", list);
		;
		return "wishlistitems";
	}

	@GetMapping("edit")
	public String updateWishList(@RequestParam("id") int id, Model model, HttpServletRequest request) {
		request.getSession().setAttribute("id", id);
		Wishlist wishList = wishlistService.getWishList(id);
		model.addAttribute("updatewishlist", wishList);
		return "updatewishlist";
	}

	@PostMapping("updatewl")
	public String updateWishList(@ModelAttribute("updatewishlist") Wishlist wishList, HttpSession session) {
		int id = Integer.parseInt(session.getAttribute("id").toString());
		wishlistService.updateWishList(wishList, id);
		return "redirect:/wl/home";
	}

	@GetMapping("edititem")
	public String updateWishListItem(@RequestParam("wid") int id, Model model, HttpServletRequest request) {
		request.getSession().setAttribute("id", id);
		WishlistItem wishListItem = wishlistService.getWishListItem(id);
		model.addAttribute("wlitem", wishListItem);
		return "updatewishlistitem";
	}

	@PostMapping("updateitem")
	public String updateWishListItem(@ModelAttribute("wlitem") WishlistItem wishListItem, Model model,
			HttpSession session) {
		int id = Integer.parseInt(session.getAttribute("id").toString());
		wishlistService.updateWishListItem(wishListItem, id);
		return "redirect:/wl/home";
	}

	@GetMapping("delete")
	public String deleteWishList(@RequestParam("id") int id) {
		wishlistService.deleteWishList(id);
		return "redirect:/wl/home";
	}
	
	@GetMapping("deleteitem")
	public String deleteWishListItem(@RequestParam("wid") int id) {
		wishlistService.deleteWishListItem(id);
		return "redirect:/wl/home";
	}

}
