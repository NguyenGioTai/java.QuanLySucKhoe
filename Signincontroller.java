package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import DAO.SigninDAO;
import model.SigninModel;
import view.SignIn;

public class Signincontroller {

	private SignIn signUpForm;
	private SigninDAO sqlServerConnection;

	// Constructor
	public Signincontroller(SignIn signUpForm, SigninDAO sqlServerConnection) {
		this.signUpForm = signUpForm;
		this.sqlServerConnection = sqlServerConnection;

		// Hiển thị giao diện đăng ký
		signUpForm.setVisible(true);

		// Gắn ActionListener cho nút "Đăng ký"
		signUpForm.getBtnSignUp().addActionListener(new SignUpActionListener());
	}

	/**
	 * Lớp xử lý sự kiện khi bấm nút đăng ký
	 */
	private class SignUpActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String username = signUpForm.getName();
			String password = signUpForm.getPassword();
			String confirmPassword = signUpForm.getConfirmPassword();

			// Kiểm tra các trường nhập liệu
			if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
				JOptionPane.showMessageDialog(signUpForm, "Vui lòng điền đầy đủ thông tin!", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Kiểm tra độ dài tài khoản
			if (!username.matches("^[a-zA-Z0-9]+$")) {
				JOptionPane.showMessageDialog(signUpForm, "Tài khoản không được chứa ký tự đặc biệt!", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Kiểm tra mật khẩu
			if (!password.equals(confirmPassword)) {
				JOptionPane.showMessageDialog(signUpForm, "Mật khẩu không khớp!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (!password.matches("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
				JOptionPane.showMessageDialog(signUpForm,
						"Mật khẩu không được sử dụng kí tự đặc biệt,"
								+ " phải có ít nhất 8 ký tự, 1 chữ in hoa và 1 chữ số!",
						"Lỗi", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Tạo đối tượng người dùng và thêm vào CSDL
			SigninModel newUser = new SigninModel(username, password);
			boolean isUserAdded = sqlServerConnection.addUser(newUser);

			if (isUserAdded) {
				JOptionPane.showMessageDialog(signUpForm, "Đăng ký thành công!", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				signUpForm.clearFields(); // Xóa các trường sau khi đăng ký thành công
			} else {
				JOptionPane.showMessageDialog(signUpForm, "Đăng ký thất bại. Tài khoản đã tồn tại hoặc có lỗi!", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public static void main(String[] args) {
		new Signincontroller(null, null);
	}
}
