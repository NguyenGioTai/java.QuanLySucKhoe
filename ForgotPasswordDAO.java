package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ForgotPasswordModel;

public class ForgotPasswordDAO {

	private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=QuanLySucKhoe;encrypt=true;trustServerCertificate=true;";
	private static final String DB_USER = "sa";
	private static final String DB_PASSWORD = "123";

	// Kết nối tới cơ sở dữ liệu
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			System.out.println("Kết nối cơ sở dữ liệu thành công!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Lỗi kết nối cơ sở dữ liệu: " + e.getMessage());
		}
		return connection;
	}

	// Kiểm tra người dùng có tồn tại không
	public boolean checkUserExists(String username) {
		String sql = "SELECT * FROM [user] WHERE username = ?";
		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			return rs.next(); // Trả về true nếu tồn tại
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Lỗi khi kiểm tra người dùng: " + e.getMessage());
			return false;
		}
	}

	// Cập nhật mật khẩu mới
	public boolean resetPassword(ForgotPasswordModel model) {
		String sql = "UPDATE [user] SET password = ? WHERE username = ?";
		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, model.getNewPassword());
			stmt.setString(2, model.getUsername());
			return stmt.executeUpdate() > 0; // Trả về true nếu có bản ghi bị thay đổi
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Lỗi SQL khi cập nhật mật khẩu: " + e.getMessage());
			return false;
		}
	}
}
