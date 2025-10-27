package TaMinhDat;

import java.util.ArrayList;

public class Movie {
	private String tenPhim;
	private String theLoai;
	private int thoiLuong; // phút
	private int gioiHanTuoi;
	private ArrayList<ShowTime> danhSachSuatChieu;

	public Movie(String tenPhim, String theLoai, int thoiLuong, int gioiHanTuoi) {
		this.tenPhim = tenPhim;
		this.theLoai = theLoai;
		this.thoiLuong = thoiLuong;
		this.gioiHanTuoi = gioiHanTuoi;
		this.danhSachSuatChieu = new ArrayList<>();
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	public int getThoiLuong() {
		return thoiLuong;
	}

	public void setThoiLuong(int thoiLuong) {
		this.thoiLuong = thoiLuong;
	}

	public int getGioiHanTuoi() {
		return gioiHanTuoi;
	}

	public void setGioiHanTuoi(int gioiHanTuoi) {
		this.gioiHanTuoi = gioiHanTuoi;
	}

	public ArrayList<ShowTime> getDanhSachSuatChieu() {
		return danhSachSuatChieu;
	}

	public void setDanhSachSuatChieu(ArrayList<ShowTime> danhSachSuatChieu) {
		this.danhSachSuatChieu = danhSachSuatChieu;
	}

	public void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}

	public void themSuatChieu(ShowTime s) {
		danhSachSuatChieu.add(s);
	}

	public String getTenPhim() {
		return tenPhim;
	}

	public void hienThiThongTin() {
		System.out.println("Phim: " + tenPhim + " | Thể loại: " + theLoai + " | Thời lượng: " + thoiLuong
				+ "p | Giới hạn tuổi: " + gioiHanTuoi);
	}
}
