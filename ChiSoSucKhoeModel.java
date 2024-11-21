package model;

public class ChiSoSucKhoeModel {
	private int maPhieu;
	private int userID; // Không cần nhập userID từ UI
	private String ngay;
	private String tinhTrangCoThe;
	private String gioiTinh;
	private float chieuCao;
	private float canNang;
	private String huyetAp;
	private int nhipTim;
	private float luongDuongMau;
	private float nhietDoCoThe;

	public ChiSoSucKhoeModel() {

	}

	public ChiSoSucKhoeModel(int maPhieu, int userID, String ngay, String tinhTrangCoThe, String gioiTinh,
			float chieuCao, float canNang, String huyetAp, int nhipTim, float luongDuongMau, float nhietDoCoThe) {

		this.maPhieu = maPhieu;
		this.userID = userID;

		this.ngay = ngay;
		this.tinhTrangCoThe = tinhTrangCoThe;
		this.gioiTinh = gioiTinh;
		this.chieuCao = chieuCao;
		this.canNang = canNang;
		this.huyetAp = huyetAp;
		this.nhipTim = nhipTim;
		this.luongDuongMau = luongDuongMau;
		this.nhietDoCoThe = nhietDoCoThe;
	}

	public int getMaPhieu() {
		return maPhieu;
	}

	public void setMaPhieu(int maPhieu) {
		this.maPhieu = maPhieu;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getNgay() {
		return ngay;
	}

	public void setNgay(String ngay) {
		this.ngay = ngay;
	}

	public String getTinhTrangCoThe() {
		return tinhTrangCoThe;
	}

	public void setTinhTrangCoThe(String tinhTrangCoThe) {
		this.tinhTrangCoThe = tinhTrangCoThe;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public float getChieuCao() {
		return chieuCao;
	}

	public void setChieuCao(float chieuCao) {
		this.chieuCao = chieuCao;
	}

	public float getCanNang() {
		return canNang;
	}

	public void setCanNang(float canNang) {
		this.canNang = canNang;
	}

	public String getHuyetAp() {
		return huyetAp;
	}

	public void setHuyetAp(String huyetAp) {
		this.huyetAp = huyetAp;
	}

	public int getNhipTim() {
		return nhipTim;
	}

	public void setNhipTim(int nhipTim) {
		this.nhipTim = nhipTim;
	}

	public float getLuongDuongMau() {
		return luongDuongMau;
	}

	public void setLuongDuongMau(float luongDuongMau) {
		this.luongDuongMau = luongDuongMau;
	}

	public float getNhietDoCoThe() {
		return nhietDoCoThe;
	}

	public void setNhietDoCoThe(float nhietDoCoThe) {
		this.nhietDoCoThe = nhietDoCoThe;
	}

}
