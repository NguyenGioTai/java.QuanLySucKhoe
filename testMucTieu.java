package test;

import DAO.MucTieuDAO;
import controller.MucTieuController;
import view.MucTieuView;

public class testMucTieu {

	public static void main(String[] args) {
		MucTieuView view = new MucTieuView();
		MucTieuDAO dao = new MucTieuDAO();
		new MucTieuController(view, dao);
		view.setVisible(true); // Hiển thị giao diện
	}

}
