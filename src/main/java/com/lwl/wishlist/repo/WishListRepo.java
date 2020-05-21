package com.lwl.wishlist.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lwl.wishlist.domain.Wishlist;
import com.lwl.wishlist.dto.WishListDTO;

public interface WishListRepo extends JpaRepository<Wishlist, Integer> {

	@Query("SELECT new com.lwl.wishlist.dto.WishListDTO(wl.id,wl.name,wl.description) from Wishlist wl where wl.userName = ?1")
	List<WishListDTO> getAllWishList(String username);

}
