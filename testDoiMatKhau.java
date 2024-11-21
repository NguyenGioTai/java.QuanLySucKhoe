package test;

import DAO.ForgotPasswordDAO;
import controller.ForgotPasswordController;
import view.ForgotPasswordView;

public class testDoiMatKhau {
	public static void main(String[] args) {
		ForgotPasswordView view = new ForgotPasswordView();
		ForgotPasswordDAO dao = new ForgotPasswordDAO();
		new ForgotPasswordController(view, dao);
		view.setVisible(true); // Hiển thị giao diện
	}
}
