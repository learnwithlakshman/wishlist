package com.lwl.wishlist.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.lwl.wishlist.UserDetailsUtil;
import com.lwl.wishlist.domain.Wishlist;
import com.lwl.wishlist.domain.WishlistItem;
import com.lwl.wishlist.dto.WishListDTO;
import com.lwl.wishlist.dto.WishListItemDTO;
import com.lwl.wishlist.repo.WishListItemRepo;
import com.lwl.wishlist.repo.WishListRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WishListServiceFromDB implements WishListService {

	@Autowired
	private WishListRepo wishListRepo;

	@Autowired
	private WishListItemRepo wishListItemRepo;

	@Override
	public void createWishList(Wishlist wishList) {
		Assert.notNull(wishList, "This can't be null");
		String userName = UserDetailsUtil.getUserName();
		wishList.setUserName(userName);
		wishList = wishListRepo.save(wishList);
		if (wishList != null)
			log.info("New wishlist created with ID {} ", wishList.getId());
		else
			log.info("Something went wrong while add new wishlist to DB");

	}

	@Override
	public List<WishListDTO> getWishLists() {
		String username = UserDetailsUtil.getUserName();
		List<WishListDTO> list = wishListRepo.getAllWishList(username);
		log.info("Total wishlists found for user {} is {} ", username, list != null ? list.size() : 0);
		return list;
	}

	@Override
	public void addItemToWishList(WishlistItem item) {
		Assert.notNull(item, "Wishlist item can't be null");
		item = wishListItemRepo.save(item);
		if (item != null)
			log.info("New wishlist item created with id {} ", item.getWid());
		else
			log.info("Something went wrong while add new wishlist Item to DB");
	}

	@Override
	public List<WishListItemDTO> getWishListItems(int id) {
		Assert.notNull(id, "ID can't be null");
		List<WishListItemDTO> list = wishListItemRepo.getWishListItems(id);
		log.info("Total wishlists items found are : {} ", list != null ? list.size() : 0);
		return list;
	}

	@Override
	public Wishlist getWishList(int id) {
		Assert.notNull(id, "ID can't be null");
		Optional<Wishlist> wishList = wishListRepo.findById(id);
		log.info("Wishlist found with id {} ", id);
		return wishList.get();
	}

	@Override
	public void updateWishList(Wishlist wishList, int id) {
		Assert.notNull(wishList, "This can't be null");
		String userName = UserDetailsUtil.getUserName();
		wishList.setUserName(userName);
		wishList.setId(id);
		wishList = wishListRepo.save(wishList);
		if (wishList != null)
			log.info("Wishlist created with ID {} ", wishList.getId());
		else
			log.info("Something went wrong while updating wishlist to DB");
	}

	@Override
	public WishlistItem getWishListItem(int id) {
		Optional<WishlistItem> wishlistItem = wishListItemRepo.findById(id);
		return wishlistItem.get();
	}

	@Override
	public void updateWishListItem(WishlistItem item, int id) {
		Assert.notNull(item, "Wishlist item can't be null");
		item.setWid(id);
		item = wishListItemRepo.save(item);
		if (item != null)
			log.info("wishlist item updated for id {} ", item.getWid());
		else
			log.info("Something went wrong while updating wishlist Item to DB");
	}

	@Override
	public void deleteWishList(int id) {
		Assert.notNull(id, "ID can't be null");
		wishListRepo.deleteById(id);
		log.info("Wish list deleted successfully with ID {} ",id);
	}

	@Override
	public void deleteWishListItem(int id) {
		Assert.notNull(id, "ID can't be null");
		wishListItemRepo.deleteById(id);
		log.info("Wish list item deleted successfully with ID {} ",id);
	}

}
