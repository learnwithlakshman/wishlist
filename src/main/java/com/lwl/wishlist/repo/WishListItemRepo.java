package com.lwl.wishlist.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lwl.wishlist.domain.WishlistItem;
import com.lwl.wishlist.dto.WishListItemDTO;

public interface WishListItemRepo extends JpaRepository<WishlistItem, Integer> {
	
	
	@Query("SELECT new com.lwl.wishlist.dto.WishListItemDTO(wli.wid,wli.name,wli.link,wli.description,wli.status) from WishlistItem wli inner join Wishlist wl on wl.id = wli.refid where wli.refid = ?1")
	List<WishListItemDTO> getWishListItems(int refid);
	
}
