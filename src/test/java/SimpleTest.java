import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SimpleTest {

	@Test
	void changeTest() {
		Money money = new Money(12);
		OrderLine orderLine = new OrderLine(money);

		money.setPrice(13);

		assertThat(orderLine.getOrderPrice().getPrice()).isEqualTo(12);
	}

}

class OrderLine {
	private Money orderPrice;

	public OrderLine(Money orderPrice) {
		// this.orderPrice = orderPrice;
		this.orderPrice = new Money(orderPrice.getPrice());
	}

	public Money getOrderPrice() {
		return orderPrice;
	}
}

class Money {
	private int price;

	public Money(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
