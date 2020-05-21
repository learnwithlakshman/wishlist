package com.lwl.wishlist.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.lwl.wishlist.domain.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishListItemDTO {
	
	private int id;
	private String name;
	private String link;
	private String description;

	@Enumerated(EnumType.STRING)
	private Status status;

}
