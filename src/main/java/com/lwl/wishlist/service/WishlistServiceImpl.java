package com.lwl.wishlist.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.lwl.wishlist.UserDetailsUtil;
import com.lwl.wishlist.domain.Status;
import com.lwl.wishlist.domain.Wishlist;
import com.lwl.wishlist.domain.WishlistItem;

@Service
public class WishlistServiceImpl implements WishlistService {

	private Map<String, Map<String, List<WishlistItem>>> map = new HashMap<String, Map<String, List<WishlistItem>>>();

	private String userName;

	@Override
	public void createWishList(Wishlist wishList) {
		userName = UserDetailsUtil.getUserName();
		Map<String, List<WishlistItem>> userMap = map.get(userName);
		List<WishlistItem> list = new ArrayList<>();
		WishlistItem wlt = new WishlistItem(101, "Buy OnePlus", "--", "OnePlus 9T", Status.PENDING);
		list.add(wlt);
		if (userMap != null) {
			userMap.put(wishList.getName(), list);
		} else {
			Map<String, List<WishlistItem>> newWishList = new HashMap<>();
			newWishList.put(wishList.getName(), list);
			map.put(userName, newWishList);
		}
	}

	@Override
	public Set<String> getWishLists() {
		userName = UserDetailsUtil.getUserName();
		Map<String, List<WishlistItem>> userMap = map.get(userName);
		if (userMap != null) {
			return userMap.keySet();
		}
		return null;
	}

	@Override
	public void addItemToWishList(String wishListName, WishlistItem item) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<WishlistItem> getWishListItems(String wishListName) {
		// TODO Auto-generated method stub
		return null;
	}
}
