package jsonData.nopcommerce;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentInfoData {
	public static PaymentInfoData getPaymentInfo() {
		return new PaymentInfoData();
	}

	@JsonProperty("visa")
	private String visa;

	@JsonProperty("date")
	private String date;

	@JsonProperty("cvc")
	private String cvc;

	public void setVisa(String visa) {
		this.visa = visa;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}

	@JsonProperty("checkout")
	Checkout checkout;

	static class Checkout {

		@JsonProperty("discount")
		String discount;
	}

	public String getDiscount() {
		return checkout.discount;
	}
}
