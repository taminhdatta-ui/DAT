package TaMinhDat;

public class Staff extends Person {
	private String chucVu;
	private double luong;

	public Staff(String ten, String sdt, String chucVu, double luong) {
		super(ten, sdt);
		this.chucVu = chucVu;
		this.luong = luong;
	}

	@Override
	public void hienThiThongTin() {
		System.out.println(
				"Nhân viên: " + ten + " | SDT: " + soDienThoai + " | Chức vụ: " + chucVu + " | Lương: " + luong + "đ");
	}

	// Getter
	public String getChucVu() {
		return chucVu;
	}

	public double getLuong() {
		return luong;
	}
}
