package com.sjhello.study.order.domain;

public class Money {

	private int value;

	public Money add(Money money) {
		return new Money(this.value + money.value);
	}

	public Money multiply(int multiplier) {
		return new Money(this.value * multiplier);
	}

	public Money(int money) {
		this.value = money;
	}

	public int getValue() {
		return value;
	}
}
