package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.UserDAO;
import test.testChiSoSucKhoe;
import view.LoginView;

public class LoginController {
	private LoginView view;
	private UserDAO userDAO;
	private testChiSoSucKhoe chiSoSucKhoe = new testChiSoSucKhoe();

	public LoginController(LoginView view, UserDAO userDAO, testChiSoSucKhoe chiSoSucKhoe) {
		this.view = view;
		this.userDAO = userDAO;
		this.chiSoSucKhoe = chiSoSucKhoe;

		// Gắn sự kiện
		this.view.addLoginListener(new LoginAction());
		this.view.addCancelListener(new CancelAction());
	}

	class LoginAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String username = view.getUsername();
			String password = view.getPassword();

			if (userDAO.validateUser(username, password)) {
				view.showMessage("Đăng nhập thành công");

				// Chuyển hướng đến màn hình chính hoặc đóng form login
				view.dispose();
				chiSoSucKhoe.main(null);
				;
			} else {
				view.showMessage("Mật khẩu hoặc tài khoản không đúng! Vui lòng nhập lại.");
				view.reset();
			}
		}
	}

	class CancelAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			view.dispose(); // Đóng form
		}
	}
}
