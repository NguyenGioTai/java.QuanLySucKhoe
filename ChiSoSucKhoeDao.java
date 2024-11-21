package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.ChiSoSucKhoeModel;

public class ChiSoSucKhoeDao {
	private Connection conn;

	// Phương thức thực hiện kết nối CSDL
	public Connection connectSQL() {
		try {
			String userName = "sa";
			String password = "123";
			String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLySucKhoe;encrypt=true;trustServerCertificate=true;";

			// Nạp driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Kết nối CSDL
			conn = java.sql.DriverManager.getConnection(url, userName, password);
			// JOptionPane.showMessageDialog(null, "Kết nối CSDL thành công", "Thông báo",
			// JOptionPane.INFORMATION_MESSAGE);
			return conn;
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy driver SQL Server", "Lỗi", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Kết nối CSDL thất bại: " + e.getMessage(), "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return null;

	}

	public boolean isConnected() {
		try {
			return conn != null && !conn.isClosed();
		} catch (SQLException e) {
			return false;
		}
	}

	public ArrayList<ChiSoSucKhoeModel> getAllRecords() {
		ArrayList<ChiSoSucKhoeModel> records = new ArrayList<>();

		// Kiểm tra kết nối trước khi truy vấn
		if (conn == null) {
			connectSQL();
		}

		if (isConnected()) {
			String sql = "SELECT * FROM ChiSoSucKhoe";
			try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
				while (rs.next()) {
					ChiSoSucKhoeModel record = new ChiSoSucKhoeModel();
					record.setMaPhieu(rs.getInt("MaPhieu"));
					record.setUserID(rs.getInt("UserID"));
					record.setNgay(rs.getString("Ngay"));
					record.setTinhTrangCoThe(rs.getString("TinhTrangCoThe"));
					record.setGioiTinh(rs.getString("GioiTinh"));
					record.setChieuCao(rs.getFloat("ChieuCao"));
					record.setCanNang(rs.getFloat("CanNang"));
					record.setHuyetAp(rs.getString("HuyetAp"));
					record.setNhipTim(rs.getInt("NhipTim"));
					record.setLuongDuongMau(rs.getFloat("LuongDuongMau"));
					record.setNhietDoCoThe(rs.getFloat("NhietDoCoThe"));
					records.add(record);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("Không thể kết nối đến cơ sở dữ liệu!");
		}
		return records;
	}

	public Connection ensureConnection() {
		if (conn == null || !isConnected()) {
			return connectSQL();
		}
		return conn;
	}

	public ArrayList<ChiSoSucKhoeModel> getRecordsByDate(String date) {
		ArrayList<ChiSoSucKhoeModel> records = new ArrayList<>();

		// Kiểm tra kết nối trước khi thực hiện truy vấn
		if (conn == null) {
			connectSQL();
		}

		if (isConnected()) {
			String sql = "SELECT * FROM ChiSoSucKhoe WHERE Ngay = ?";
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, date);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					ChiSoSucKhoeModel record = new ChiSoSucKhoeModel();
					record.setMaPhieu(rs.getInt("MaPhieu"));
					record.setUserID(rs.getInt("UserID"));
					record.setNgay(rs.getString("Ngay"));
					record.setTinhTrangCoThe(rs.getString("TinhTrangCoThe"));
					record.setGioiTinh(rs.getString("GioiTinh"));
					record.setChieuCao(rs.getFloat("ChieuCao"));
					record.setCanNang(rs.getFloat("CanNang"));
					record.setHuyetAp(rs.getString("HuyetAp"));
					record.setNhipTim(rs.getInt("NhipTim"));
					record.setLuongDuongMau(rs.getFloat("LuongDuongMau"));
					record.setNhietDoCoThe(rs.getFloat("NhietDoCoThe"));
					records.add(record);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("Không thể kết nối đến cơ sở dữ liệu!");
		}
		return records;
	}

	public boolean addRecord(ChiSoSucKhoeModel record) {
		String sql = "INSERT INTO ChiSoSucKhoe ( UserID, Ngay, TinhTrangCoThe, GioiTinh, ChieuCao, CanNang, HuyetAp, NhipTim, LuongDuongMau, NhietDoCoThe) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, record.getUserID());
			pstmt.setString(2, record.getNgay());
			pstmt.setString(3, record.getTinhTrangCoThe());
			pstmt.setString(4, record.getGioiTinh());
			pstmt.setFloat(5, record.getChieuCao());
			pstmt.setFloat(6, record.getCanNang());
			pstmt.setString(7, record.getHuyetAp());
			pstmt.setInt(8, record.getNhipTim());
			pstmt.setFloat(9, record.getLuongDuongMau());
			pstmt.setFloat(10, record.getNhietDoCoThe());

			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateRecord(ChiSoSucKhoeModel record) {
		String sql = "UPDATE ChiSoSucKhoe SET Ngay = ?, TinhTrangCoThe = ?, GioiTinh = ?, ChieuCao = ?, CanNang = ?, "
				+ "HuyetAp = ?, NhipTim = ?, LuongDuongMau = ?, NhietDoCoThe = ? WHERE MaPhieu = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, record.getNgay());
			stmt.setString(2, record.getTinhTrangCoThe());
			stmt.setString(3, record.getGioiTinh());
			stmt.setFloat(4, record.getChieuCao());
			stmt.setFloat(5, record.getCanNang());
			stmt.setString(6, record.getHuyetAp());
			stmt.setInt(7, record.getNhipTim());
			stmt.setFloat(8, record.getLuongDuongMau());
			stmt.setFloat(9, record.getNhietDoCoThe());
			stmt.setInt(10, record.getMaPhieu());

			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0; // Thành công nếu có dòng được cập nhật
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteRecord(int maPhieu) {
		String sql = "DELETE FROM ChiSoSucKhoe WHERE MaPhieu=?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, maPhieu);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		ChiSoSucKhoeDao dao = new ChiSoSucKhoeDao();
		try (Connection conn = dao.connectSQL()) {
			if (conn != null && !conn.isClosed()) {
				System.out.println("Kết nối đến cơ sở dữ liệu thành công!");
			} else {
				System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
			}
		} catch (SQLException e) {
			System.out.println("Lỗi khi kết nối đến cơ sở dữ liệu: " + e.getMessage());
			e.printStackTrace();
		}
	}
}