package com.lwl.wishlist.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class WishlistItem {

	private int id;
	private String name;
	private String link;
	private String description;
	private Status status;
}
