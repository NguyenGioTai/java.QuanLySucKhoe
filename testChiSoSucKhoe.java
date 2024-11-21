package test;

import DAO.ChiSoSucKhoeDao;
import controller.ChiSoSucKhoeController;
import view.ChiSoSucKhoeView;

public class testChiSoSucKhoe {
	public static void main(String[] args) {
		ChiSoSucKhoeView view = new ChiSoSucKhoeView();
		ChiSoSucKhoeDao dao = new ChiSoSucKhoeDao();
		new ChiSoSucKhoeController(view, dao);
		view.setVisible(true); // Hiển thị giao diện
	}
}
