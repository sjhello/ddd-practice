package com.sjhello.study.order.domain;

import com.sjhello.study.common.Address;

public class ShippingInfo {

	private Receiver receiver;
	private Address address;

	public ShippingInfo(Receiver receiver, Address address) {
		this.receiver = receiver;
		this.address = address;
	}

	public Receiver getReceiver() {
		return receiver;
	}

	public Address getAddress() {
		return address;
	}
}
