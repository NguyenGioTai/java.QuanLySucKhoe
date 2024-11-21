package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.MucTieuModel;

public class MucTieuDAO {
	private Connection conn;

	// Phương thức thực hiện kết nối CSDL
	public Connection connectSQL() throws SQLException {
		if (conn == null || conn.isClosed()) {
			try {
				String userName = "sa";
				String password = "123";
				String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLySucKhoe;encrypt=true;trustServerCertificate=true;";

				// Nạp driver
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

				// Kết nối CSDL
				conn = java.sql.DriverManager.getConnection(url, userName, password);
			} catch (ClassNotFoundException | SQLException e) {
				JOptionPane.showMessageDialog(null, "Không thể kết nối CSDL: " + e.getMessage(), "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				throw new SQLException(e);
			}
		}
		return conn;
	}

	// Phương thức đóng kết nối
	private void closeConnection() {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException ex) {
			System.out.println("Lỗi khi đóng kết nối: " + ex.getMessage());
		}
	}

	// Phương thức lấy tất cả mục tiêu
	public List<MucTieuModel> getAllMucTieu() throws SQLException {
		List<MucTieuModel> list = new ArrayList<>();
		String query = "SELECT * FROM ChieuCaoVaCanNang";
		try (Statement stmt = connectSQL().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				MucTieuModel mt = new MucTieuModel(rs.getInt("id"), rs.getInt("thoiGian"), rs.getFloat("chieuCao"),
						rs.getFloat("canNang"));
				list.add(mt);
			}
		} catch (SQLException e) {
			System.out.println("Lỗi khi truy vấn dữ liệu: " + e.getMessage());
			throw e;
		}
		return list;
	}

	// Phương thức thêm mục tiêu
	public void addMucTieu(MucTieuModel mucTieu) throws SQLException {
		String sql = "INSERT INTO ChieuCaoVaCanNang (ThoiGian, ChieuCao, CanNang) VALUES (?, ?, ?)";
		try (PreparedStatement ps = connectSQL().prepareStatement(sql)) {
			ps.setInt(1, mucTieu.getThoiGian());
			ps.setFloat(2, mucTieu.getChieuCaoMongMuon());
			ps.setFloat(3, mucTieu.getCanNangMongMuon());
			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Lỗi khi thêm mục tiêu: " + ex.getMessage());
			throw ex;
		}
	}

	// Phương thức cập nhật mục tiêu
	public void updateMucTieu(MucTieuModel mt) throws SQLException {
		String query = "UPDATE ChieuCaoVaCanNang SET thoiGian = ?, chieuCao = ?, canNang = ? WHERE id = ?";
		try (PreparedStatement pstmt = connectSQL().prepareStatement(query)) {
			pstmt.setInt(1, mt.getThoiGian());
			pstmt.setFloat(2, mt.getChieuCaoMongMuon());
			pstmt.setFloat(3, mt.getCanNangMongMuon());
			pstmt.setInt(4, mt.getId());
			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Mục tiêu đã được cập nhật!");
			} else {
				System.out.println("Không tìm thấy mục tiêu để cập nhật.");
			}
		}
	}

	// Phương thức xóa mục tiêu
	public void deleteMucTieu(int id) throws SQLException {
		String query = "DELETE FROM ChieuCaoVaCanNang WHERE id = ?";
		try (PreparedStatement pstmt = connectSQL().prepareStatement(query)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}
	}

	// Phương thức thêm mục tiêu hoàn thành
	public void addMucTieuHoanThanh(MucTieuModel mt) {
		String sql = "INSERT INTO MucTieuHoanThanh (ThoiGianHoanThanh, ChieuCaoHoanThanh, CanNangHoanThanh) VALUES (?, ?, ?)";
		try (PreparedStatement ps = connectSQL().prepareStatement(sql)) {
			ps.setInt(1, mt.getThoiGian()); // Chuyển giá trị thời gian từ đối tượng MucTieuModel
			ps.setFloat(2, mt.getChieuCaoMongMuon());
			ps.setFloat(3, mt.getCanNangMongMuon());

			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void deleteAllMucTieu() throws Exception {
		String sql1 = "DELETE FROM ChieuCaoVaCanNang";

		try (Connection conn = connectSQL(); PreparedStatement stmt1 = conn.prepareStatement(sql1)) {
			conn.setAutoCommit(false); // Bắt đầu transaction

			// Xóa dữ liệu từ bảng liên kết trước
			stmt1.executeUpdate();

			// Xóa dữ liệu từ bảng mục tiêu

			conn.commit(); // Commit transaction
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new Exception("Lỗi khi xóa toàn bộ dữ liệu: " + ex.getMessage());
		}
	}

	// Phương thức trong DAO để lấy tất cả các mục tiêu đã hoàn thành từ bảng
	// MucTieuHoanThanh
	// Phương thức lấy tất cả mục tiêu hoàn thành
	public List<MucTieuModel> getAllMucTieuHoanThanh() throws SQLException {
		List<MucTieuModel> list = new ArrayList<>();
		String query = "SELECT * FROM MucTieuHoanThanh"; // Sử dụng tên bảng đúng

		try (Statement stmt = connectSQL().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				MucTieuModel mt = new MucTieuModel(rs.getInt("id"), rs.getInt("ThoiGianHoanThanh"),
						rs.getFloat("ChieuCaoHoanThanh"), rs.getFloat("CanNangHoanThanh"));
				list.add(mt);
			}
		} catch (SQLException e) {
			System.out.println("Lỗi khi truy vấn dữ liệu mục tiêu hoàn thành: " + e.getMessage());
			throw e;
		}
		return list;
	}

	public static void main(String[] args) {
		MucTieuDAO dao = new MucTieuDAO();
		try {
			dao.connectSQL(); // Kết nối CSDL
			System.out.println("Kết nối đến cơ sở dữ liệu thành công!");
		} catch (SQLException e) {
			System.out.println("Lỗi khi kết nối đến cơ sở dữ liệu: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
