package model;

public class PasswordValidator {

	// Hàm kiểm tra mật khẩu hợp lệ
	public static boolean isPasswordValid(String password) {
		// Kiểm tra mật khẩu ít nhất 8 ký tự
		if (password.length() < 8) {
			return false;
		}

		// Kiểm tra có ít nhất 1 chữ in hoa
		if (!password.matches(".*[A-Z].*")) {
			return false;
		}

		// Kiểm tra có ít nhất 1 số
		if (!password.matches(".*\\d.*")) {
			return false;
		}

		// Kiểm tra không có ký tự đặc biệt
		if (password.matches(".*[^a-zA-Z0-9].*")) {
			return false;
		}

		return true;
	}
}
