package com.sjhello.study.order.domain;

import java.util.Objects;

import com.sjhello.study.common.Address;

public class Member {

	private Long id;
	private Address address;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Member member = (Member)o;
		return Objects.equals(id, member.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
