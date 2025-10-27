package TaMinhDat;

import java.time.LocalDateTime;

public class ShowTime {
	private Movie phim;
	private CinemaRoom phong;
	private LocalDateTime thoiGianChieu;

	public ShowTime(Movie phim, CinemaRoom phong, LocalDateTime thoiGianChieu) {
		this.phim = phim;
		this.phong = phong;
		this.thoiGianChieu = thoiGianChieu;
	}

	// Getter & Setter
	public Movie getPhim() {
		return phim;
	}

	public void setPhim(Movie phim) {
		this.phim = phim;
	}

	public CinemaRoom getPhong() {
		return phong;
	}

	public void setPhong(CinemaRoom phong) {
		this.phong = phong;
	}

	public LocalDateTime getThoiGianChieu() {
		return thoiGianChieu;
	}

	public void setThoiGianChieu(LocalDateTime thoiGianChieu) {
		this.thoiGianChieu = thoiGianChieu;
	}

	// Hiển thị thông tin suất chiếu
	public void hienThiThongTin() {
		System.out.println("Phim: " + phim.getTenPhim());
		System.out.println("Thể loại: " + phim.getTheLoai());
		System.out.println("Phòng chiếu: " + phong.getMaPhong() + " (" + phong.getLoaiPhong() + ")");
		System.out.println("Thời gian chiếu: " + thoiGianChieu);
	}
}
