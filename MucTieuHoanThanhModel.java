package model;

public class MucTieuHoanThanhModel {
	private int id;
	private int maPhieu;
	private String thoiGianHoanThanh;
	private float chieuCaoHoanThanh;
	private float canNangHoanThanh;

	public MucTieuHoanThanhModel(int id, int maPhieu, String thoiGianHoanThanh, float chieuCaoHoanThanh,
			float canNangHoanThanh) {
		this.id = id;
		this.maPhieu = maPhieu;
		this.thoiGianHoanThanh = thoiGianHoanThanh;
		this.chieuCaoHoanThanh = chieuCaoHoanThanh;
		this.canNangHoanThanh = canNangHoanThanh;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaPhieu() {
		return maPhieu;
	}

	public void setMaPhieu(int maPhieu) {
		this.maPhieu = maPhieu;
	}

	public String getThoiGianHoanThanh() {
		return thoiGianHoanThanh;
	}

	public void setThoiGianHoanThanh(String thoiGianHoanThanh) {
		this.thoiGianHoanThanh = thoiGianHoanThanh;
	}

	public float getChieuCaoHoanThanh() {
		return chieuCaoHoanThanh;
	}

	public void setChieuCaoHoanThanh(float chieuCaoHoanThanh) {
		this.chieuCaoHoanThanh = chieuCaoHoanThanh;
	}

	public float getCanNangHoanThanh() {
		return canNangHoanThanh;
	}

	public void setCanNangHoanThanh(float canNangHoanThanh) {
		this.canNangHoanThanh = canNangHoanThanh;
	}

	// Getter và Setter
}
