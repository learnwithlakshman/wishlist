package com.lwl.wishlist;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lwl.wishlist.domain.Wishlist;
import com.lwl.wishlist.repo.WishListRepo;

@SpringBootTest
class WishlistApplicationTests {
	
	@Autowired
	private WishListRepo wishListRepo;

	@Test
	void contextLoads() {
		
	}

}
