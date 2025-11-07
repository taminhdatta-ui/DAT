package BT_Tuan_9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager implements IQuanLySach {
	private static List<Book> Manage;
	private Scanner sc = new Scanner(System.in);

	public BookManager() {
		this.Manage = new ArrayList<>();
	}

	public static boolean isDuplicateID(String ma) {
		for (Book b : Manage) {
			if (b.getBook_ID().equalsIgnoreCase(ma)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void addBook(Book book) {
		this.Manage.add(book);
	}

	@Override
	public void Add() {
		Book book = null;

		System.out.println("\n Chọn loại sách cần thêm:");
		System.out.println("1. Textbook");
		System.out.println("2. Novel");
		System.out.println("0. Hủy thao tác");

		while (true) {
			try {
				System.out.print(" Nhập lựa chọn của bạn: ");
				String input = sc.nextLine().trim();

				// Cho phép thoát
				if (input.equals("0")) {
					System.out.println("⬅ Đã hủy thao tác thêm sách.");
					return;
				}

				int choice = Integer.parseInt(input);

				if (choice == 1) {
					book = new Textbook();
					book.nhap();
					break;
				} else if (choice == 2) {
					book = new Novel();
					book.nhap();
					break;
				} else {
					System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại (1, 2 hoặc 0 để hủy).");
				}

			} catch (NumberFormatException e) {
				System.out.println("Lỗi: Vui lòng nhập số nguyên (1, 2 hoặc 0 để hủy)!");
			}
		}

		Manage.add(book);
	}

	@Override
	public void Display() {
		if (Manage.isEmpty()) {
			System.out.println("Danh sách trống!");
			return;
		}

		final int MAX_ATTEMPT = 3;

		while (true) {
			// Hiển thị danh sách mã + tiêu đề
			System.out.println("\nDANH SÁCH SÁCH HIỆN CÓ:");
			System.out.printf("%-10s %-40s%n", "MÃ SÁCH", "TIÊU ĐỀ");
			System.out.println("--------------------------------------------------------------");
			for (Book b : Manage) {
				String shortTitle = b.getTitle().length() > 40 ? b.getTitle().substring(0, 37) + "..." : b.getTitle();
				System.out.printf("%-10s %-40s%n", b.getBook_ID(), shortTitle);
			}

			int attempt = 0;

			while (attempt < MAX_ATTEMPT) {
				System.out.print("\nNhập mã sách để xem chi tiết (nhập 'all' để xem tất cả, 0 để quay lại menu): ");
				String input = sc.nextLine().trim();

				// Quay lại menu
				if (input.equals("0")) {
					System.out.println("⬅ Quay lại menu chính...");
					return;
				}

				// Xem tất cả
				if (input.equalsIgnoreCase("all")) {
					printTableHeader();
					for (Book b : Manage) {
						printTableRow(b);
					}
					System.out.println("\nĐã hiển thị tất cả sách!");
					// Quay lại vòng nhập mã, không hỏi thêm
					continue;
				}

				// Tìm theo mã sách
				boolean found = false;
				for (Book b : Manage) {
					if (b.getBook_ID().equalsIgnoreCase(input)) {
						printTableHeader();
						printTableRow(b);
						System.out.println("\nĐã hiển thị chi tiết sách có mã: " + input);
						found = true;
						break;
					}
				}

				if (found) {
					// Sau khi xem chi tiết, quay lại ngay dòng nhập
					continue;
				} else {
					attempt++;
					if (attempt < MAX_ATTEMPT) {
						System.out.println("Không tìm thấy sách có mã: " + input + " (" + attempt + "/3 lần)");
						System.out.println("⏎ Mời nhập lại...");
					} else {
						System.out.println("Nhập sai quá 3 lần! Tự động quay lại menu chính...");
						return;
					}
				}
			}
		}
	}

	private void printTableHeader() {
		System.out.printf("%-10s %-35s %-18s %-6s %-8s %-10s%n", "MÃ SÁCH", "TIÊU ĐỀ", "TÁC GIẢ", "NĂM", "S.LG",
				"GIÁ BÁN");
		System.out.println(
				"-----------------------------------------------------------------------------------------------");
	}

	private void printTableRow(Book b) {
		String title = b.getTitle().length() > 35 ? b.getTitle().substring(0, 32) + "..." : b.getTitle();
		String author = b.getAuthor().length() > 18 ? b.getAuthor().substring(0, 15) + "..." : b.getAuthor();

		System.out.printf("%-10s %-35s %-18s %-6d %-8d %-10.2f%n", b.getBook_ID(), title, author, b.getPub_year(),
				b.getQuantity(), b.tinhGiaBan());
	}

	@Override
	public void Delete() {
		if (Manage.isEmpty()) {
			System.out.println("Danh sách trống! Không có sách để xóa.");
			return;
		}

		// Hiển thị danh sách mã và tiêu đề sách
		System.out.println("\n📖 DANH SÁCH SÁCH HIỆN CÓ:");
		System.out.printf("%-10s %-40s%n", "MÃ SÁCH", "TIÊU ĐỀ");
		System.out.println("--------------------------------------------------------------");
		for (Book b : Manage) {
			String shortTitle = b.getTitle().length() > 40 ? b.getTitle().substring(0, 37) + "..." : b.getTitle();
			System.out.printf("%-10s %-40s%n", b.getBook_ID(), shortTitle);
		}

		// Cho phép nhập lại nếu nhập sai
		while (true) {
			System.out.print("\nNhập mã sách cần xóa (0 để hủy): ");
			String ma = sc.nextLine().trim();

			// Cho phép quay lại
			if (ma.equals("0")) {
				System.out.println("⬅ Đã hủy thao tác xóa.");
				return;
			}

			boolean found = false;

			// Duyệt danh sách tìm mã cần xóa
			for (int i = 0; i < Manage.size(); i++) {
				Book b = Manage.get(i);
				if (b.getBook_ID().equalsIgnoreCase(ma)) {
					System.out.printf("❗ Xác nhận xóa sách: [%s] - \"%s\" (y/n): ", b.getBook_ID(), b.getTitle());
					String confirm = sc.nextLine().trim().toLowerCase();

					if (confirm.equals("y")) {
						Manage.remove(i);
						System.out.println("Đã xóa thành công sách có ID: " + ma);
					} else {
						System.out.println("Hủy xóa.");
					}
					found = true;
					break;
				}
			}

			if (found)
				break; // Đã xóa hoặc hủy thì dừng
			else
				System.out.println("Không tìm thấy sách có mã '" + ma + "'. Vui lòng nhập lại!");
		}
	}

	@Override
	public void Update() {
		if (Manage.isEmpty()) {
			System.out.println("Danh sách trống!");
			return;
		}

		System.out.print("Nhập mã sách cần cập nhật: ");
		String ma = sc.nextLine();
		boolean found = false;
		for (Book b : Manage) {
			if (b.getBook_ID().equalsIgnoreCase(ma)) {
				System.out.println("Nhập lại thông tin chung:");
				b.nhap(); // gọi lại hàm nhập có sẵn

				if (b instanceof Textbook) {
					System.out.print("Nhập môn học mới: ");
					((Textbook) b).SetmonHoc(sc.nextLine());
					System.out.print("Nhập cấp độ mới: ");
					((Textbook) b).SetcapDo(sc.nextLine());
				} else if (b instanceof Novel) {
					System.out.print("Nhập thể loại mới: ");
					((Novel) b).SettheLoai(sc.nextLine());
					System.out.print("Là sách series (true/false): ");
					((Novel) b).SetlaSachSeries(sc.nextBoolean());
					sc.nextLine();
				}

				System.out.println("Cập nhật thành công!");
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("Không tìm thấy sách có ID: " + ma);
		}
	}

	@Override
	public void Search() {
		if (Manage.isEmpty()) {
			System.out.println("Danh sách trống!");
			return;
		}

		System.out.print("Nhập mã sách cần tìm: ");
		String ma = sc.nextLine();
		boolean found = false;

		for (Book b : Manage) {
			if (b.getBook_ID().equalsIgnoreCase(ma)) {
				System.out.println("Tìm thấy sách:");
				System.out.println(b);
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("Không tìm thấy sách có ID: " + ma);
		}
	}

	public void muonSach() {
		System.out.print("Nhập mã sách cần mượn: ");
		String ma = sc.nextLine();
		boolean found = false;

		for (Book b : Manage) {
			if (b.getBook_ID().equalsIgnoreCase(ma)) {
				System.out.print("Nhập tên người mượn: ");
				String nguoiMuon = sc.nextLine();
				System.out.print("Nhập số ngày mượn: ");
				int soNgay = sc.nextInt();
				sc.nextLine();
				b.muonSach(nguoiMuon, soNgay);
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("Không tìm thấy sách có ID: " + ma);
		}
	}

	@Override
	public void Start() {
		int choice;
		do {
			System.out.println("\n===== MENU QUẢN LÝ SÁCH =====");
			System.out.println("1. Thêm sách");
			System.out.println("2. Hiển thị");
			System.out.println("3. Xóa sách");
			System.out.println("4. Cập nhật");
			System.out.println("5. Tìm kiếm");
			System.out.println("6. Mượn sách");
			System.out.println("0. Thoát");
			System.out.print("Nhập lựa chọn: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				Add();
				break;
			case 2:
				Display();
				break;
			case 3:
				Delete();
				break;
			case 4:
				Update();
				break;
			case 5:
				Search();
				break;
			case 6:
				muonSach();
				break;
			case 0:
				System.out.println("Thoát chương trình!");
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ!");
			}
		} while (choice != 0);
	}
}
