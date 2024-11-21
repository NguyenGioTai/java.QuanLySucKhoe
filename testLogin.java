package test;

import DAO.UserDAO;
import controller.LoginController;
import view.LoginView;

public class testLogin {
	public static void main(String[] args) {
		LoginView view = new LoginView();
		UserDAO userDAO = new UserDAO();
		testChiSoSucKhoe chiSoSucKhoe = new testChiSoSucKhoe();
		new LoginController(view, userDAO, chiSoSucKhoe);
		view.setVisible(true);
	}
}
