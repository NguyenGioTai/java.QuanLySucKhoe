package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.SigninModel;

public class SigninDAO {

	// Chuỗi kết nối đến cơ sở dữ liệu
	private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=QuanLySucKhoe;encrypt=true;trustServerCertificate=true;";
	private static final String DB_USER = "sa"; // Thay bằng tài khoản SQL Server của bạn
	private static final String DB_PASSWORD = "123"; // Thay bằng mật khẩu của bạn

	/**
	 * Hàm thiết lập kết nối với cơ sở dữ liệu
	 * 
	 * @return Connection object nếu kết nối thành công, null nếu thất bại
	 */
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			System.out.println("Kết nối cơ sở dữ liệu thành công!");
		} catch (SQLException e) {
			System.err.println("Kết nối cơ sở dữ liệu thất bại!");
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * Hàm thêm người dùng mới vào bảng [user]
	 * 
	 * @param newUser Đối tượng SigninModel chứa thông tin người dùng
	 * @return true nếu thêm thành công, false nếu thất bại
	 */
	public boolean addUser(SigninModel newUser) {
		String sql = "INSERT INTO [user] (username, password) VALUES (?, ?)";
		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			// Gán giá trị vào câu lệnh SQL
			stmt.setString(1, newUser.getUsername());
			stmt.setString(2, newUser.getPassword());

			// Thực thi câu lệnh và kiểm tra kết quả
			int rowsInserted = stmt.executeUpdate();
			return rowsInserted > 0; // Trả về true nếu thêm thành công
		} catch (SQLException e) {
			System.err.println("Lỗi khi thêm người dùng vào cơ sở dữ liệu!");
			e.printStackTrace();
		}
		return false; // Trả về false nếu thêm thất bại
	}

	// Main để kiểm tra kết nối (nếu cần)
	public static void main(String[] args) {
		SigninDAO dao = new SigninDAO();

		// Kiểm tra kết nối
		Connection conn = getConnection();
		if (conn != null) {
			System.out.println("Kết nối cơ sở dữ liệu hoạt động tốt.");
		} else {
			System.out.println("Kiểm tra lại thông tin kết nối.");
		}

		// Kiểm tra hàm thêm người dùng

	}
}