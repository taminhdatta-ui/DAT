package TaMinhDat;

public class Ticket {
	private String maVe;
	private Seat ghe;
	private double gia;

	public Ticket(String maVe, Seat ghe, double gia) {
		this.maVe = maVe;
		this.ghe = ghe;
		this.gia = gia;
	}

	public String getMaVe() {
		return maVe;
	}

	public double getGia() {
		return gia;
	}

	public void hienThi() {
		System.out.println(
				"Vé: " + maVe + " | Ghế: " + ghe.getSoGhe() + " | Loại: " + ghe.getLoaiGhe() + " | Giá: " + gia + "đ");
	}
}
