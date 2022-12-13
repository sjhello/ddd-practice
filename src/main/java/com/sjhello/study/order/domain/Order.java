package com.sjhello.study.order.domain;

import java.util.List;

import com.sjhello.study.common.Money;

public class Order {

	private OrderNo orderNo;
	private OrderState orderState;
	private ShippingInfo shippingInfo;
	private List<OrderLine> orderLines;
	private Money totalAmounts;

	public Order(OrderNo orderNo, OrderState orderState, ShippingInfo shippingInfo, List<OrderLine> orderLines,
		Money totalAmounts) {
		this.orderNo = orderNo;
		this.orderState = orderState;
		this.shippingInfo = shippingInfo;
		setOrderLines(orderLines);
		calculateAllAmounts();
	}


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

	private void setOrderLines(List<OrderLine> orderLines) {
		if (orderLines == null || orderLines.isEmpty()) {
			throw new IllegalArgumentException("주문 정보가 비어있습니다");
		}
		this.orderLines = orderLines;
	}

	private void calculateAllAmounts() {
		this.totalAmounts = new Money(orderLines.stream().mapToInt(x -> x.getAmount().getValue()).sum());
	}

}
