package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.ChiSoSucKhoeDao;
import model.ChiSoSucKhoeModel;
import view.ChiSoSucKhoeView;

public class ChiSoSucKhoeController {
	private ChiSoSucKhoeView view;
	private ChiSoSucKhoeDao dao;

	public ChiSoSucKhoeController(ChiSoSucKhoeView view, ChiSoSucKhoeDao dao) {
		this.view = view;
		this.dao = dao;

		view.addHealthRecordListener(new HealthRecordActionListener());

		loadDataToTable();
	}

	private void loadDataToTable() {
		view.clearTable();
		ArrayList<ChiSoSucKhoeModel> records = dao.getAllRecords();
		for (ChiSoSucKhoeModel record : records) {
			view.addRowToTable(new Object[] { record.getMaPhieu(), record.getNgay(), record.getTinhTrangCoThe(),
					record.getGioiTinh(), record.getChieuCao(), record.getCanNang(), record.getHuyetAp(),
					record.getNhipTim(), record.getLuongDuongMau(), record.getNhietDoCoThe() });
		}
		view.getTable().getColumnModel().getColumn(0).setMinWidth(0);
		view.getTable().getColumnModel().getColumn(0).setMaxWidth(0);
		view.getTable().getColumnModel().getColumn(0).setWidth(0);
	}

	private void clearInputFields() {

		view.getTfUserID().setText("");
		view.getTfNgay().setText("");
		view.getTfTinhTrangCoThe().setText("");
		view.getTfGioiTinh().setText("");
		view.getTfChieuCao().setText("");
		view.getTfCanNang().setText("");
		view.getTfHuyetAp().setText("");
		view.getTfNhipTim().setText("");
		view.getTfLuongDuongMau().setText("");
		view.getTfNhietDoCoThe().setText("");
	}

	private ChiSoSucKhoeModel getRecordFromInput() {
		try {
			ChiSoSucKhoeModel record = new ChiSoSucKhoeModel();

			record.setUserID(Integer.parseInt(view.getTfUserID().getText()));

			record.setNgay(view.getTfNgay().getText());
			record.setTinhTrangCoThe(view.getTfTinhTrangCoThe().getText());
			record.setGioiTinh(view.getTfGioiTinh().getText());
			record.setChieuCao(Float.parseFloat(view.getTfChieuCao().getText()));
			record.setCanNang(Float.parseFloat(view.getTfCanNang().getText()));
			record.setHuyetAp(view.getTfHuyetAp().getText());
			record.setNhipTim(Integer.parseInt(view.getTfNhipTim().getText()));
			record.setLuongDuongMau(Float.parseFloat(view.getTfLuongDuongMau().getText()));
			record.setNhietDoCoThe(Float.parseFloat(view.getTfNhietDoCoThe().getText()));

			return record;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(view, "Vui lòng nhập đúng định dạng dữ liệu!", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	private class HealthRecordActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == view.getBtnSearch()) {
				String date = view.getTfSearchDate().getText().trim();
				if (date.isEmpty()) {
					JOptionPane.showMessageDialog(view, "Vui lòng nhập ngày để tìm kiếm!", "Thông báo",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				ArrayList<ChiSoSucKhoeModel> records = dao.getRecordsByDate(date);
				if (records.isEmpty()) {
					JOptionPane.showMessageDialog(view, "Không tìm thấy bản ghi nào với ngày: " + date, "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					view.clearTable();
					for (ChiSoSucKhoeModel record : records) {
						view.addRowToTable(new Object[] { record.getMaPhieu(), record.getNgay(),
								record.getTinhTrangCoThe(), record.getGioiTinh(), record.getChieuCao(),
								record.getCanNang(), record.getHuyetAp(), record.getNhipTim(),
								record.getLuongDuongMau(), record.getNhietDoCoThe() });
					}
				}
			} else if (e.getSource() == view.getBtnCancelSearch()) {
				view.clearTable(); // Xóa dữ liệu hiện tại trên bảng
				loadDataToTable(); // Tải lại toàn bộ dữ liệu
				view.getTfSearchDate().setText(""); // Xóa text tìm kiếm
			}

			if (e.getSource() == view.getBtnAdd()) {
				ChiSoSucKhoeModel record = getRecordFromInput();
				if (record != null) {
					if (dao.addRecord(record)) {
						JOptionPane.showMessageDialog(view, "Thêm bản ghi thành công!");
						loadDataToTable();

					} else {
						JOptionPane.showMessageDialog(view, "Lỗi thêm bản ghi!", "Lỗi", JOptionPane.ERROR_MESSAGE);
					}
				}
			} else if (e.getSource() == view.getBtnUpdate()) {
				int selectedRow = view.getTable().getSelectedRow(); // Lấy dòng được chọn trong bảng
				if (selectedRow >= 0) { // Kiểm tra có dòng nào được chọn không
					// Lấy dữ liệu từ các trường nhập
					try {
						String ngay = view.getTfNgay().getText().trim();
						String tinhTrangCoThe = view.getTfTinhTrangCoThe().getText().trim();
						String gioiTinh = view.getTfGioiTinh().getText().trim();
						float chieuCao = Float.parseFloat(view.getTfChieuCao().getText().trim());
						float canNang = Float.parseFloat(view.getTfCanNang().getText().trim());
						String huyetAp = view.getTfHuyetAp().getText().trim();
						int nhipTim = Integer.parseInt(view.getTfNhipTim().getText().trim());
						float luongDuongMau = Float.parseFloat(view.getTfLuongDuongMau().getText().trim());
						float nhietDoCoThe = Float.parseFloat(view.getTfNhietDoCoThe().getText().trim());

						// Cập nhật dữ liệu trong bảng
						view.getTable().setValueAt(ngay, selectedRow, 1);
						view.getTable().setValueAt(tinhTrangCoThe, selectedRow, 2);
						view.getTable().setValueAt(gioiTinh, selectedRow, 3);
						view.getTable().setValueAt(chieuCao, selectedRow, 4);
						view.getTable().setValueAt(canNang, selectedRow, 5);
						view.getTable().setValueAt(huyetAp, selectedRow, 6);
						view.getTable().setValueAt(nhipTim, selectedRow, 7);
						view.getTable().setValueAt(luongDuongMau, selectedRow, 8);
						view.getTable().setValueAt(nhietDoCoThe, selectedRow, 9);

						// Cập nhật cơ sở dữ liệu
						ChiSoSucKhoeModel updatedRecord = new ChiSoSucKhoeModel(
								(int) view.getTable().getValueAt(selectedRow, 0), // MaPhieu
								nhipTim, ngay, tinhTrangCoThe, gioiTinh, chieuCao, canNang, huyetAp, nhipTim,
								luongDuongMau, nhietDoCoThe);
						if (dao.updateRecord(updatedRecord)) {
							JOptionPane.showMessageDialog(view, "Cập nhật thành công!");
						} else {
							JOptionPane.showMessageDialog(view, "Cập nhật thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
						}

					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(view, "Vui lòng nhập đúng định dạng dữ liệu!", "Lỗi",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(view, "Vui lòng chọn một dòng để cập nhật!", "Thông báo",
							JOptionPane.WARNING_MESSAGE);
				}
			} else if (e.getSource() == view.getBtnDelete()) {
				int selectedRow = view.getTable().getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(view, "Vui lòng chọn bản ghi để xóa!");
					return;
				}
				int maPhieu = (int) view.getTable().getValueAt(selectedRow, 0);

				// Hiển thị hộp thoại xác nhận xóa
				int confirm = JOptionPane.showConfirmDialog(view, "Bạn có chắc chắn muốn xóa bản ghi này?",
						"Xác nhận xóa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				// Nếu người dùng chọn Yes, thực hiện xóa bản ghi
				if (confirm == JOptionPane.YES_OPTION) {
					if (dao.deleteRecord(maPhieu)) {
						JOptionPane.showMessageDialog(view, "Xóa bản ghi thành công!");
						loadDataToTable();
						clearInputFields();
					} else {
						JOptionPane.showMessageDialog(view, "Lỗi xóa bản ghi!", "Lỗi", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					// Nếu người dùng chọn No, không thực hiện hành động xóa
					JOptionPane.showMessageDialog(view, "Hành động xóa đã bị hủy.");
				}
			} else if (e.getSource() == view.getBtnClear()) {
				clearInputFields();
			}
		}
	}
}