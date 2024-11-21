package model;

public class MucTieuModel {
	private int id;
	private int thoiGian;
	private float chieuCaoMongMuon;
	private float canNangMongMuon;

	public MucTieuModel(int id, int thoiGian, float chieuCaoMongMuon, float canNangMongMuon) {
		this.id = id;
		this.thoiGian = thoiGian;
		this.chieuCaoMongMuon = chieuCaoMongMuon;
		this.canNangMongMuon = canNangMongMuon;
	}

	// Getter và Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(int thoiGian) {
		this.thoiGian = thoiGian;
	}

	public float getChieuCaoMongMuon() {
		return chieuCaoMongMuon;
	}

	public void setChieuCaoMongMuon(float chieuCaoMongMuon) {
		this.chieuCaoMongMuon = chieuCaoMongMuon;
	}

	public float getCanNangMongMuon() {
		return canNangMongMuon;
	}

	public void setCanNangMongMuon(float canNangMongMuon) {
		this.canNangMongMuon = canNangMongMuon;
	}
}
