package com.sjhello.study.order.domain;

public class Order {
	
	private OrderState orderState;
	private ShippingInfo shippingInfo;

	public void cancel() {
		verifyNotYetShipped();
		this.orderState = OrderState.CANCEL;
	}

	public void changeShipped() {
		verifyNotYetShipped();
		this.orderState = OrderState.SHIPPED;
	}

	public void completePayment() {
		verifyNotYetPayment();
	}

	public void changeShippingInfo(ShippingInfo shippingInfo) {
		verifyNotYetShipped();
		setShippingInfo(shippingInfo);
	}

	private void setShippingInfo(ShippingInfo shippingInfo) {
		if (shippingInfo == null) {
			throw new IllegalArgumentException("no shipping info");
		}
		this.shippingInfo = shippingInfo;
	}

	private void verifyNotYetShipped() {
		if (this.orderState != OrderState.PREPARING && this.orderState != OrderState.PAYMENT_WAITING) {
			throw new IllegalArgumentException("상품이 이미 출고 되었습니다");
		}
	}

	private void verifyNotYetPayment() {
		if (this.orderState == OrderState.PAYMENT_WAITING) {
			throw new IllegalArgumentException("아직 결제 되지 않았습니다");
		}
	}

}
