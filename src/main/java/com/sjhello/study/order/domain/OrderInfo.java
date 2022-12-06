package com.sjhello.study.order.domain;

public class OrderInfo {

	private Product product;
	private Money price;
	private int quantity;
	private Money amount;

	public OrderInfo(Product product, Money price, int quantity) {
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
