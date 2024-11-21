package test;

import DAO.SigninDAO;
import controller.Signincontroller;
import view.SignIn;

public class SigninTest {
	public static void main(String[] args) {
		SignIn view = new SignIn();
		SigninDAO DAO = new SigninDAO();

		new Signincontroller(view, DAO);
		view.setVisible(true);
	}
}