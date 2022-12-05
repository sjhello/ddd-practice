package com.sjhello.study.order.domain;

import java.util.List;

public class OrderInfo {

	private Product product;
	private Money price;
	private int quantity;
	private Money amount;

	private Money caculateAmount() {
		return price.multiply(quantity);
	}

	public Product getProduct() {
		return product;
	}

	public Money getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public Money getAmount() {
		return amount;
	}
}
