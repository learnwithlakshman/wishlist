package com.lwl.wishlist.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lwl.wishlist.UserDetailsUtil;

@Service
public class WishlistService {

	
	private Map<String,Map<String,List<String>>> map = new HashMap<String, Map<String,List<String>>>();
	
	public void addWishlist(String wlName) {
			String username = UserDetailsUtil.getUserName();
			System.out.println("User name :"+username);
	}
	public void getWishlist() {
		String username = UserDetailsUtil.getUserName();
		System.out.println("User name :"+username);
	}
}
