package com.lwl.wishlist.service;

import java.util.List;

import com.lwl.wishlist.domain.Wishlist;
import com.lwl.wishlist.domain.WishlistItem;
import com.lwl.wishlist.dto.WishListDTO;
import com.lwl.wishlist.dto.WishListItemDTO;

public interface WishListService {

	void createWishList(Wishlist wishList);

	Wishlist getWishList(int id);

	void updateWishList(Wishlist wishList, int id);

	List<WishListDTO> getWishLists();

	void deleteWishList(int id);

	void addItemToWishList(WishlistItem item);

	WishlistItem getWishListItem(int id);

	List<WishListItemDTO> getWishListItems(int id);

	void updateWishListItem(WishlistItem item, int id);

	void deleteWishListItem(int id);

}
