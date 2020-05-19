package com.lwl.wishlist.service;

import java.util.List;
import java.util.Set;

import com.lwl.wishlist.domain.Wishlist;
import com.lwl.wishlist.domain.WishlistItem;

public interface WishlistService {

	void createWishList(Wishlist wishList);

	Set<String> getWishLists();

	void addItemToWishList(String wishListName, WishlistItem item);
	
	List<WishlistItem> getWishListItems(String wishListName);
	

}
