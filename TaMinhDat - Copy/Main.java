package TaMinhDat;

import java.time.LocalDateTime;

public class Main {
	public static void main(String[] args) {
		// Phim và phòng
		Movie movie = new Movie("Avengers: Endgame", "Hành động", 180, 13);
		CinemaRoom room = new CinemaRoom("P01", "IMAX", 100);
		room.themGhe(new Seat("A1", "VIP"));
		room.themGhe(new Seat("A2", "Thường"));

		// Suất chiếu
		ShowTime showtime = new ShowTime(movie, room, LocalDateTime.of(2025, 10, 27, 19, 30));
		movie.themSuatChieu(showtime);

		// Khách hàng
		Customer customer = new Customer("Nguyễn Văn A", "0909123456", "a@gmail.com", "123456789");

		// Phương thức thanh toán
		Payment payment = new EWalletPayment("Momo", "0909123456");

		// Đặt vé
		Booking booking = new Booking("B001", customer, showtime, payment);
		booking.themVe(new Ticket("V001", new Seat("A1", "VIP"), 120000));
		booking.themVe(new Ticket("V002", new Seat("A2", "Thường"), 90000));

		// Hiển thị thông tin
		movie.hienThiThongTin();
		booking.hienThiVe();

		// Thanh toán
		booking.thanhToan();
	}
}
