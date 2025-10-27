package TaMinhDat;

public class Seat {
	private String soGhe;
	private String loaiGhe; // Thường hoặc VIP

	public Seat(String soGhe, String loaiGhe) {
		this.soGhe = soGhe;
		this.loaiGhe = loaiGhe;
	}

	public String getSoGhe() {
		return soGhe;
	}

	public String getLoaiGhe() {
		return loaiGhe;
	}

	public void hienThi() {
		System.out.println("Ghế: " + soGhe + " (" + loaiGhe + ")");
	}
}
