package TaMinhDat;

public class Customer extends Person {
	private String email;
	private String soCCCD;

	public Customer(String ten, String sdt, String email, String soCCCD) {
		super(ten, sdt);
		this.email = email;
		this.soCCCD = soCCCD;
	}

	@Override
	public void hienThiThongTin() {
		System.out
				.println("Khách hàng: " + ten + " | SDT: " + soDienThoai + " | Email: " + email + " | CCCD: " + soCCCD);
	}

	// Getter
	public String getEmail() {
		return email;
	}

	public String getSoCCCD() {
		return soCCCD;
	}
}
