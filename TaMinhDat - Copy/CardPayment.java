package TaMinhDat;

public class CardPayment implements Payment {
	private String soThe;
	private String tenChuThe;

	public CardPayment(String soThe, String tenChuThe) {
		this.soThe = soThe;
		this.tenChuThe = tenChuThe;
	}

	@Override
	public void pay(double amount) {
		System.out.println("Thanh toán " + amount + "đ bằng thẻ (" + "Số thẻ: " + soThe + ", Chủ thẻ: " + tenChuThe
				+ ") thành công.");
	}

	// Getter
	public String getSoThe() {
		return soThe;
	}

	public String getTenChuThe() {
		return tenChuThe;
	}
}
