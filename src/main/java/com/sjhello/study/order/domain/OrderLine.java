package com.sjhello.study.order.domain;

import com.sjhello.study.common.Money;

public class OrderLine {

	private Product product;
	private Money price;
	private int quantity;
	private Money amount;

	public OrderLine(Product product, Money price, int quantity) {
		this.product = product;
		this.price = price;
		this.quantity = quantity;
		this.amount = calculateAmount();
	}

	private Money calculateAmount() {
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
