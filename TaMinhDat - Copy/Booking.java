package TaMinhDat;

import java.util.HashMap;
import java.util.Map;

public class Booking {
	private String maBooking;
	private Customer khachHang;
	private ShowTime suatChieu;
	private HashMap<String, Ticket> danhSachVe;
	private Payment phuongThucThanhToan;

	public Booking(String maBooking, Customer khachHang, ShowTime suatChieu, Payment ptThanhToan) {
		this.maBooking = maBooking;
		this.khachHang = khachHang;
		this.suatChieu = suatChieu;
		this.phuongThucThanhToan = ptThanhToan;
		this.danhSachVe = new HashMap<>();
	}

	public void themVe(Ticket ve) {
		danhSachVe.put(ve.getMaVe(), ve);
	}

	public void hienThiVe() {
		System.out.println("Danh sách vé trong Booking " + maBooking + ":");
		for (Map.Entry<String, Ticket> entry : danhSachVe.entrySet()) {
			entry.getValue().hienThi();
		}
	}

	public double tinhTongTien() {
		double tong = 0;
		for (Ticket t : danhSachVe.values())
			tong += t.getGia();
		return tong;
	}

	public void thanhToan() {
		double tong = tinhTongTien();
		phuongThucThanhToan.pay(tong);
	}
}
