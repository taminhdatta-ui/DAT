package TaMinhDat;

public abstract class Person {
	protected String ten;
	protected String soDienThoai;

	public Person(String ten, String soDienThoai) {
		this.ten = ten;
		this.soDienThoai = soDienThoai;
	}

	public abstract void hienThiThongTin();
}
