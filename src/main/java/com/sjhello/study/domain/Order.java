package com.sjhello.study.domain;

public class Order {

	private OrderState orderState;
	private ShippingInfo shippingInfo;

	public void changeShippingInfo(ShippingInfo shippingInfo) {
		if(!isChangeable()) {
			throw new IllegalArgumentException("배송지 정보를 변경 할 수 없습니다");
		}
		this.shippingInfo = shippingInfo;
	}

	private boolean isChangeable() {
		return this.orderState == OrderState.PREPARING
			|| this.orderState == OrderState.PAYMENT_WAITING;
	}

}
