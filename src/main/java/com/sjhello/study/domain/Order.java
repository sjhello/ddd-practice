package com.sjhello.study.domain;

public class Order {

	private OrderState orderState;
	private ShippingInfo shippingInfo;

	public void cancel() {
		verifyNotYetShipped();
		this.orderState = OrderState.CANCEL;
	}

	public void changeShippingInfo(ShippingInfo shippingInfo) {
		verifyNotYetShipped();
		this.shippingInfo = shippingInfo;
	}

	private void verifyNotYetShipped() {
		if (this.orderState != OrderState.PREPARING && this.orderState != OrderState.PAYMENT_WAITING) {
			throw new IllegalArgumentException("상품이 이미 출고 되었습니다");
		}
	}

}
