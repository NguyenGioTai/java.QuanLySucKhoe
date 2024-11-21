package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class UserDAO {
	public Connection conn = null;

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

	public boolean validateUser(String username, String password) {
		try (Connection conn = connectSQL()) {
			String sql = "SELECT * FROM [user] WHERE username = ? AND password = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
