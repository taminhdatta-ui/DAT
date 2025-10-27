package TaMinhDat;

public class EWalletPayment implements Payment {
	private String tenVi;
	private String soDienThoaiLienKet;

	public EWalletPayment(String tenVi, String soDienThoaiLienKet) {
		this.tenVi = tenVi;
		this.soDienThoaiLienKet = soDienThoaiLienKet;
	}

	@Override
	public void pay(double amount) {
		System.out.println("Thanh toán " + amount + "đ qua ví điện tử " + tenVi + " (SĐT liên kết: "
				+ soDienThoaiLienKet + ") thành công.");
	}

	// Getter
	public String getTenVi() {
		return tenVi;
	}

	public String getSoDienThoaiLienKet() {
		return soDienThoaiLienKet;
	}
}
