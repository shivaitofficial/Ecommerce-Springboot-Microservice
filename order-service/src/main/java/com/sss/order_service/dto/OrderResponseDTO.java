package com.sss.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO {
	
	private Long orderId;  // Order table 
	private Long productId; // Product table 
	private int quantity; // Product quantity 
	private double totalprice; // Find 
	
	// product details
	
	private String productName;
	private double productPrice;
	

}
