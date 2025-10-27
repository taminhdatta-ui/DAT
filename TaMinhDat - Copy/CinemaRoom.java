package TaMinhDat;

import java.util.ArrayList;

public class CinemaRoom {
	private String maPhong;
	private String loaiPhong; // 2D, 3D, IMAX
	private int soLuongGhe;
	private ArrayList<Seat> danhSachGhe;

	public CinemaRoom(String maPhong, String loaiPhong, int soLuongGhe) {
		this.maPhong = maPhong;
		this.loaiPhong = loaiPhong;
		this.soLuongGhe = soLuongGhe;
		this.danhSachGhe = new ArrayList<>();
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public int getSoLuongGhe() {
		return soLuongGhe;
	}

	public void setSoLuongGhe(int soLuongGhe) {
		this.soLuongGhe = soLuongGhe;
	}

	public ArrayList<Seat> getDanhSachGhe() {
		return danhSachGhe;
	}

	public void setDanhSachGhe(ArrayList<Seat> danhSachGhe) {
		this.danhSachGhe = danhSachGhe;
	}

	public void themGhe(Seat s) {
		danhSachGhe.add(s);
	}

	public void hienThiThongTin() {
		System.out.println("Phòng: " + maPhong + " | Loại: " + loaiPhong + " | Số ghế: " + soLuongGhe);
	}
}
