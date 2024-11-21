package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.MucTieuDAO;
import model.MucTieuModel;
import view.MucTieuView;

public class MucTieuController {
	private MucTieuView view;
	private MucTieuDAO model;

	public MucTieuController(MucTieuView view, MucTieuDAO model) {
		this.view = view;
		this.model = model;

		// Thêm action listener cho các nút
		view.getBtnThem().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				themMucTieu();
			}
		});

		view.getBtnSua().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				suaMucTieu();
			}
		});

		view.getBtnXoa().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				xoaMucTieu();
			}
		});

		view.getBtnLamMoi().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lamMoiTable();
			}
		});

		view.getBtnHoanThanh().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hoanThanhMucTieu();
			}
		});
		showMucTieu();
		showMucTieuHoanThanh();
	}

	public void showMucTieu() {
		try {
			List<MucTieuModel> list = model.getAllMucTieu();
			DefaultTableModel tableModel = new DefaultTableModel(
					new Object[] { "Id", "Thời Gian (ngày)", "Chiều Cao (cm)", "Cân Nặng (kg)" }, 0);

			for (MucTieuModel mt : list) {
				tableModel.addRow(new Object[] { mt.getId(), mt.getThoiGian(), mt.getChieuCaoMongMuon(),
						mt.getCanNangMongMuon() });
			}

			view.getTableMucTieu().setModel(tableModel);

			// Ẩn cột Id
			view.getTableMucTieu().getColumnModel().getColumn(0).setMinWidth(0);
			view.getTableMucTieu().getColumnModel().getColumn(0).setMaxWidth(0);
			view.getTableMucTieu().getColumnModel().getColumn(0).setWidth(0);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void themMucTieu() {
		try {
			// Lấy giá trị từ JTextField trong view
			String thoiGianStr = view.getTfThoiGian().getText();
			// Kiểm tra xem thời gian có trống hay không
			if (thoiGianStr.isEmpty()) {
				JOptionPane.showMessageDialog(view, "Vui lòng nhập thời gian mục tiêu!");
				return;
			}
			int thoiGian = Integer.parseInt(thoiGianStr); // Chuyển đổi thời gian sang kiểu int

			// Lấy chiều cao và cân nặng
			float chieuCao = Float.parseFloat(view.getTfChieuCao().getText());
			float canNang = Float.parseFloat(view.getTfCanNang().getText());

			// Kiểm tra nếu chiều cao và cân nặng không hợp lệ
			if (chieuCao <= 0 || canNang <= 0) {
				JOptionPane.showMessageDialog(view, "Vui lòng nhập chiều cao và cân nặng hợp lệ!");
				return;
			}

			// Tạo đối tượng MucTieuModel và thêm vào DB
			MucTieuModel mt = new MucTieuModel(0, thoiGian, chieuCao, canNang);
			model.addMucTieu(mt);
			showMucTieu(); // Hiển thị lại bảng mục tiêu
			JOptionPane.showMessageDialog(view, "Thêm mục tiêu thành công!");
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(view, "Dữ liệu nhập vào không hợp lệ! Vui lòng kiểm tra lại.");
			ex.printStackTrace();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(view, "Có lỗi xảy ra khi thêm mục tiêu!");
			ex.printStackTrace();
		}
	}

	private void suaMucTieu() {
		int row = view.getTableMucTieu().getSelectedRow();
		if (row != -1) {
			try {
				// Lấy ID của mục tiêu được chọn
				int id = (int) view.getTableMucTieu().getValueAt(row, 0);

				// Lấy giá trị từ JTextField trong view
				String thoiGianStr = view.getTfThoiGian().getText();
				// Kiểm tra xem thời gian có trống hay không
				if (thoiGianStr.isEmpty()) {
					JOptionPane.showMessageDialog(view, "Vui lòng nhập thời gian mục tiêu!");
					return;
				}
				int thoiGian = Integer.parseInt(thoiGianStr); // Chuyển đổi thời gian sang kiểu int

				// Lấy chiều cao và cân nặng
				float chieuCao = Float.parseFloat(view.getTfChieuCao().getText());
				float canNang = Float.parseFloat(view.getTfCanNang().getText());

				// Kiểm tra nếu chiều cao và cân nặng không hợp lệ
				if (chieuCao <= 0 || canNang <= 0) {
					JOptionPane.showMessageDialog(view, "Vui lòng nhập chiều cao và cân nặng hợp lệ!");
					return;
				}

				// Tạo đối tượng MucTieuModel và gọi phương thức update
				MucTieuModel mt = new MucTieuModel(id, thoiGian, chieuCao, canNang);
				model.updateMucTieu(mt); // Cập nhật mục tiêu trong cơ sở dữ liệu
				showMucTieu(); // Hiển thị lại bảng mục tiêu
				JOptionPane.showMessageDialog(view, "Cập nhật mục tiêu thành công!");
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(view, "Dữ liệu nhập vào không hợp lệ! Vui lòng kiểm tra lại.");
				ex.printStackTrace();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(view, "Có lỗi xảy ra khi cập nhật mục tiêu!");
				ex.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(view, "Vui lòng chọn mục tiêu để sửa!");
		}
	}

	private void xoaMucTieu() {
		int row = view.getTableMucTieu().getSelectedRow();
		if (row != -1) {
			try {
				int id = (int) view.getTableMucTieu().getValueAt(row, 0);
				int confirm = JOptionPane.showConfirmDialog(view, "Bạn có chắc muốn xóa mục tiêu này?", "Xác nhận",
						JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					model.deleteMucTieu(id); // Xóa mục tiêu khỏi DB
					showMucTieu();
					JOptionPane.showMessageDialog(view, "Xóa mục tiêu thành công!");
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(view, "Có lỗi xảy ra khi xóa mục tiêu!");
				ex.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(view, "Vui lòng chọn mục tiêu để xóa!");
		}
	}

	private void lamMoiTable() {
		int confirm = JOptionPane.showConfirmDialog(view, "Bạn có chắc chắn muốn xóa toàn bộ dữ liệu?", "Xác nhận",
				JOptionPane.YES_NO_OPTION);

		if (confirm == JOptionPane.YES_OPTION) {
			try {
				// Xóa toàn bộ dữ liệu trong bảng cơ sở dữ liệu
				model.deleteAllMucTieu();

				// Làm rỗng bảng hiển thị
				DefaultTableModel tableModel = (DefaultTableModel) view.getTableMucTieu().getModel();
				tableModel.setRowCount(0);

				JOptionPane.showMessageDialog(view, "Làm mới thành công, tất cả dữ liệu đã bị xóa!");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(view, "Có lỗi xảy ra khi xóa dữ liệu!");
				ex.printStackTrace();
			}
		}
	}

	private void hoanThanhMucTieu() {
		int row = view.getTableMucTieu().getSelectedRow();

		if (row != -1) {
			try {
				int id = (int) view.getTableMucTieu().getValueAt(row, 0);
				int thoiGian = (int) view.getTableMucTieu().getValueAt(row, 1);
				float chieuCao = (float) view.getTableMucTieu().getValueAt(row, 2);
				float canNang = (float) view.getTableMucTieu().getValueAt(row, 3);

				// Tạo đối tượng MucTieuModel mà không cần MaPhieu
				MucTieuModel mt = new MucTieuModel(id, thoiGian, chieuCao, canNang);

				// Gọi phương thức trong model mà không truyền MaPhieu
				model.addMucTieuHoanThanh(mt); // Cập nhật phương thức model để không cần MaPhieu

				showMucTieu(); // Cập nhật lại bảng hiển thị
				JOptionPane.showMessageDialog(view, "Mục tiêu đã được hoàn thành và lưu!");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(view, "Có lỗi xảy ra khi hoàn thành mục tiêu!");
				ex.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(view, "Vui lòng chọn mục tiêu để hoàn thành!");
		}
	}

	// Phương thức để hiển thị mục tiêu hoàn thành
	public void showMucTieuHoanThanh() {
		try {
			// Lấy danh sách mục tiêu hoàn thành từ DB
			List<MucTieuModel> list = model.getAllMucTieuHoanThanh(); // Lấy dữ liệu từ MucTieuHoanThanh

			// Cập nhật bảng MucTieuHoanThanh
			DefaultTableModel tableModel = new DefaultTableModel(new Object[] { "Thời Gian", "Chiều Cao", "Cân Nặng" },
					0); // Không cần cột ID

			for (MucTieuModel mt : list) {
				tableModel.addRow(new Object[] { mt.getThoiGian(), mt.getChieuCaoMongMuon(), mt.getCanNangMongMuon() });
			}

			// Cập nhật lại dữ liệu vào bảng
			view.getTableMucTieuHoanThanh().setModel(tableModel);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
