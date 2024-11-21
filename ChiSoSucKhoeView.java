package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import test.testBaoCao;
import test.testChiSoSucKhoe;
import test.testLogin;
import test.testMucTieu;
import test.testRecall;

public class ChiSoSucKhoeView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTable table;
	public JTextField textField_ngay;
	public JTextField textField_chieucao;
	public JTextField textField_cannang;
	public JTextField textField_huyetap;
	public ButtonGroup btn_gioitinh;
	private JTextField textField_nhiptim;
	private JTextField textField_luongduong;
	private JTextField textField_nhietdocothe;

	private JTextField textField_tinhtrang2;
	private JTextField textField_timkiem;
	private JButton btn_them;
	private JButton btn_xoa;
	private JButton btn_capnhat;
	private JButton btn_huybo;
	private DefaultTableModel tableModel;

	private JTextField textField_gioitinh;
	private JTextField textField_userid;
	private JButton btn_tim;
	private JButton btn_huytim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiSoSucKhoeView frame = new ChiSoSucKhoeView();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChiSoSucKhoeView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Iconka-Cat-Commerce-Review.32.png"));
		setTitle("Healthymeow");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 772);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenuItem mn_DangXuat = new JMenuItem("Đăng xuất      ");
		mn_DangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(mn_DangXuat);
				currentFrame.dispose();
				testLogin login = new testLogin();
				login.main(null);

			}
		});
		mn_DangXuat.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Custom-Icon-Design-Pretty-Office-11-Logout.24.png"));
		mn_DangXuat.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		menuBar.add(mn_DangXuat);

		JMenu mn_QuanLiNguoiDung = new JMenu("Quản lý người dùng    ");
		mn_QuanLiNguoiDung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(mn_DangXuat);
				currentFrame.dispose();
				testChiSoSucKhoe chiSoSucKhoe = new testChiSoSucKhoe();
				chiSoSucKhoe.main(null);
				;

			}
		});
		mn_QuanLiNguoiDung.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Dtafalonso-Ios8-Health.24.png"));
		mn_QuanLiNguoiDung.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		menuBar.add(mn_QuanLiNguoiDung);

		JMenuItem mn_MucTieu = new JMenuItem("Mục tiêu     ");
		mn_MucTieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(mn_MucTieu);
				currentFrame.dispose();
				testMucTieu muctieu = new testMucTieu();
				muctieu.main(null);
			}
		});
		mn_MucTieu.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Gartoon-Team-Gartoon-Misc-Seahorse-Applet-Signed.24.png"));
		mn_MucTieu.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mn_MucTieu);

		JMenuItem mn_BaoCaoChiTiet = new JMenuItem("Báo cáo");
		mn_BaoCaoChiTiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(mn_BaoCaoChiTiet);
				currentFrame.dispose();
				testBaoCao baocao = new testBaoCao();
				baocao.main(null);
			}
		});
		mn_BaoCaoChiTiet.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Inipagi-Business-Economic-Checklist.24.png"));
		mn_BaoCaoChiTiet.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		menuBar.add(mn_BaoCaoChiTiet);

		JMenuItem mn_NhacNho = new JMenuItem("Nhắc nhở    ");
		mn_NhacNho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(mn_NhacNho);
				currentFrame.dispose();
				testRecall recall = new testRecall();
				recall.main(null);
			}
		});
		mn_NhacNho.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Alecive-Flatwoken-Apps-Notifications.24.png"));
		mn_NhacNho.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		menuBar.add(mn_NhacNho);

		JMenuItem mn_Thoat = new JMenuItem("Thoát");
		mn_Thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(mn_Thoat);
				currentFrame.dispose();
				testRecall recall = new testRecall();
				recall.main(null);
			}
		});
		mn_Thoat.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Saki-NuoveXT-2-Apps-session-logout.24.png"));
		mn_Thoat.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		menuBar.add(mn_Thoat);
		/*
		 * mn_Thoat.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { System.exit(0); } });
		 */

		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_danhsachphieu = new JLabel("Danh sách phiếu");
		lbl_danhsachphieu.setForeground(new Color(153, 0, 204));
		lbl_danhsachphieu.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 15));
		lbl_danhsachphieu.setBounds(10, 95, 149, 33);
		contentPane.add(lbl_danhsachphieu);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 128, 841, 211);
		contentPane.add(scrollPane);

		tableModel = new DefaultTableModel(new String[] { "Mã Phiếu", "Ngày", "Tình trạng cơ thể",
				"Gi\u1EDBi t\u00EDnh", "Chi\u1EC1u cao", "C\u00E2n n\u1EB7ng", "Huy\u1EBFt \u00E1p", "Nh\u1ECBp tim",
				"Lượng đường", "Nhi\u1EC7t \u0111\u1ED9 c\u01A1 th\u1EC3" }, 0);
		table = new JTable(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));

		table.setRowHeight(25);
		scrollPane.setViewportView(table);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 349, 841, 4);
		contentPane.add(separator_1_1);

		JLabel lbl_ghinhanchisosuckhoe = new JLabel("Ghi nhận chỉ số sức khỏe");
		lbl_ghinhanchisosuckhoe.setForeground(new Color(153, 0, 204));
		lbl_ghinhanchisosuckhoe.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 15));
		lbl_ghinhanchisosuckhoe.setBounds(10, 349, 207, 31);
		contentPane.add(lbl_ghinhanchisosuckhoe);

		btn_gioitinh = new ButtonGroup();

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(10, 607, 851, 4);
		contentPane.add(separator_1_2);

		JPanel panel_timkiem = new JPanel();
		panel_timkiem.setBackground(new Color(255, 255, 255));
		panel_timkiem.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_timkiem.setBounds(10, 10, 841, 85);
		contentPane.add(panel_timkiem);
		panel_timkiem.setLayout(null);

		btn_tim = new JButton("Tìm");
		btn_tim.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Ampeross-Qetto-2-Search.16.png"));
		btn_tim.setForeground(new Color(255, 153, 0));
		btn_tim.setBackground(new Color(255, 255, 255));
		btn_tim.setBounds(467, 24, 120, 33);
		panel_timkiem.add(btn_tim);

		btn_tim.setFont(new Font("Segoe UI Black", Font.BOLD, 15));

		btn_huytim = new JButton("Hủy tìm");
		btn_huytim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_huytim.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Hopstarter-Sleek-Xp-Basic-Close-2.16.png"));
		btn_huytim.setForeground(new Color(255, 153, 0));
		btn_huytim.setBackground(new Color(255, 255, 255));
		btn_huytim.setBounds(664, 24, 120, 33);
		panel_timkiem.add(btn_huytim);

		btn_huytim.setFont(new Font("Segoe UI Black", Font.BOLD, 15));

		JLabel lbl_tinhtrang = new JLabel("Ngày:");
		lbl_tinhtrang.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Icons8-Ios7-Time-And-Date-Calendar.24.png"));
		lbl_tinhtrang.setForeground(new Color(255, 153, 0));
		lbl_tinhtrang.setBounds(22, 17, 113, 47);
		panel_timkiem.add(lbl_tinhtrang);
		lbl_tinhtrang.setFont(new Font("Segoe UI Black", Font.BOLD, 15));

		textField_timkiem = new JTextField();
		textField_timkiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_timkiem.setColumns(10);
		textField_timkiem.setBounds(145, 24, 224, 31);
		panel_timkiem.add(textField_timkiem);

		JPanel panel_phieu = new JPanel();
		panel_phieu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_phieu.setBackground(new Color(255, 255, 255));
		panel_phieu.setBounds(10, 128, 851, 211);
		contentPane.add(panel_phieu);
		panel_phieu.setLayout(null);

		JPanel panel_nhapchiso = new JPanel();
		panel_nhapchiso.setBackground(new Color(255, 255, 255));
		panel_nhapchiso.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_nhapchiso.setBounds(10, 378, 851, 219);
		contentPane.add(panel_nhapchiso);
		panel_nhapchiso.setLayout(null);

		JLabel lbl_tinhtrangsk = new JLabel("Tình trạng cơ thể:\r\n");
		lbl_tinhtrangsk.setBounds(10, 116, 162, 37);
		panel_nhapchiso.add(lbl_tinhtrangsk);
		lbl_tinhtrangsk.setFont(new Font("Segoe UI Light", Font.BOLD, 15));

		JLabel lbl_ngay = new JLabel("Ngày:");
		lbl_ngay.setBounds(10, 73, 96, 19);
		panel_nhapchiso.add(lbl_ngay);
		lbl_ngay.setFont(new Font("Segoe UI Light", Font.BOLD, 15));

		JLabel lbl_cannang = new JLabel("Cân nặng:");
		lbl_cannang.setBounds(368, 73, 86, 19);
		panel_nhapchiso.add(lbl_cannang);
		lbl_cannang.setFont(new Font("Segoe UI Light", Font.BOLD, 15));

		textField_ngay = new JTextField();
		textField_ngay.setBounds(167, 68, 176, 31);
		panel_nhapchiso.add(textField_ngay);
		textField_ngay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_ngay.setColumns(10);

		textField_tinhtrang2 = new JTextField();
		textField_tinhtrang2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_tinhtrang2.setColumns(10);
		textField_tinhtrang2.setBounds(167, 120, 176, 31);
		panel_nhapchiso.add(textField_tinhtrang2);

		textField_gioitinh = new JTextField();
		textField_gioitinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_gioitinh.setColumns(10);
		textField_gioitinh.setBounds(167, 174, 122, 31);
		panel_nhapchiso.add(textField_gioitinh);

		JLabel lblNewLabel = new JLabel("nam");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Custom-Icon-Design-Flatastic-7-Male.16.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(299, 183, 67, 13);
		panel_nhapchiso.add(lblNewLabel);

		JLabel lblN = new JLabel("nữ");
		lblN.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Graphicloads-Medical-Health-Female.16.png"));
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblN.setBounds(373, 178, 61, 23);
		panel_nhapchiso.add(lblN);

		JLabel lblN_1 = new JLabel("/");
		lblN_1.setIcon(null);
		lblN_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblN_1.setBounds(355, 178, 12, 23);
		panel_nhapchiso.add(lblN_1);

		JLabel lbl_gioitinh = new JLabel("Giới tính:");
		lbl_gioitinh.setBounds(10, 179, 73, 19);
		panel_nhapchiso.add(lbl_gioitinh);
		lbl_gioitinh.setFont(new Font("Segoe UI Light", Font.BOLD, 15));

		JLabel lbl_chieucao = new JLabel("Chiều cao:");
		lbl_chieucao.setBounds(368, 20, 86, 19);
		panel_nhapchiso.add(lbl_chieucao);
		lbl_chieucao.setFont(new Font("Segoe UI Light", Font.BOLD, 15));

		textField_chieucao = new JTextField();
		textField_chieucao.setBounds(464, 15, 112, 31);
		panel_nhapchiso.add(textField_chieucao);
		textField_chieucao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_chieucao.setColumns(10);

		textField_cannang = new JTextField();
		textField_cannang.setBounds(464, 68, 112, 31);
		panel_nhapchiso.add(textField_cannang);
		textField_cannang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_cannang.setColumns(10);

		JLabel lbl_huyetap = new JLabel("Huyết áp:");
		lbl_huyetap.setBounds(368, 125, 89, 19);
		panel_nhapchiso.add(lbl_huyetap);
		lbl_huyetap.setFont(new Font("Segoe UI Light", Font.BOLD, 15));

		textField_huyetap = new JTextField();
		textField_huyetap.setBounds(464, 120, 112, 31);
		panel_nhapchiso.add(textField_huyetap);
		textField_huyetap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_huyetap.setColumns(10);

		JLabel lbl_nhiptim = new JLabel("Nhịp tim:");
		lbl_nhiptim.setBounds(596, 125, 86, 19);
		panel_nhapchiso.add(lbl_nhiptim);
		lbl_nhiptim.setFont(new Font("Segoe UI Light", Font.BOLD, 15));

		textField_nhiptim = new JTextField();
		textField_nhiptim.setBounds(724, 120, 122, 31);
		panel_nhapchiso.add(textField_nhiptim);
		textField_nhiptim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_nhiptim.setColumns(10);

		JLabel lbl_luongduong = new JLabel("Lượng đường:");
		lbl_luongduong.setBounds(596, 20, 127, 19);
		panel_nhapchiso.add(lbl_luongduong);
		lbl_luongduong.setFont(new Font("Segoe UI Light", Font.BOLD, 15));

		textField_luongduong = new JTextField();
		textField_luongduong.setBounds(724, 15, 122, 31);
		panel_nhapchiso.add(textField_luongduong);
		textField_luongduong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_luongduong.setColumns(10);

		JLabel lblM_nhietdocothe = new JLabel("Nhiệt độ cơ thể:");
		lblM_nhietdocothe.setBounds(596, 70, 127, 25);
		panel_nhapchiso.add(lblM_nhietdocothe);
		lblM_nhietdocothe.setFont(new Font("Segoe UI Light", Font.BOLD, 15));

		textField_nhietdocothe = new JTextField();
		textField_nhietdocothe.setBounds(724, 68, 122, 31);
		panel_nhapchiso.add(textField_nhietdocothe);
		textField_nhietdocothe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_nhietdocothe.setColumns(10);

		JLabel lbl_tinhtrangsk_1 = new JLabel("Lần nhập trong ngày:");
		lbl_tinhtrangsk_1.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lbl_tinhtrangsk_1.setBounds(10, 11, 147, 37);
		panel_nhapchiso.add(lbl_tinhtrangsk_1);

		textField_userid = new JTextField();
		textField_userid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_userid.setColumns(10);
		textField_userid.setBounds(167, 15, 176, 31);
		panel_nhapchiso.add(textField_userid);

		JPanel panel_button = new JPanel();
		panel_button.setBackground(new Color(255, 255, 255));
		panel_button.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_button.setBounds(34, 631, 798, 64);
		contentPane.add(panel_button);
		panel_button.setLayout(null);

		btn_them = new JButton("Thêm");

		btn_them.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Icons8-Windows-8-Programming-Add-Property.16.png"));
		btn_them.setBackground(new Color(204, 102, 255));
		btn_them.setBounds(50, 17, 96, 29);
		panel_button.add(btn_them);
		btn_them.setFont(new Font("Segoe UI", Font.BOLD, 15));

		btn_xoa = new JButton("Xóa");
		btn_xoa.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Hopstarter-Sleek-Xp-Basic-Close-2.16.png"));
		btn_xoa.setBackground(new Color(204, 102, 255));
		btn_xoa.setBounds(243, 17, 89, 29);
		panel_button.add(btn_xoa);
		btn_xoa.setFont(new Font("Segoe UI", Font.BOLD, 15));

		btn_capnhat = new JButton("Cập nhật");
		btn_capnhat.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Custom-Icon-Design-Flatastic-1-Edit.16.png"));
		btn_capnhat.setBackground(new Color(204, 102, 255));
		btn_capnhat.setBounds(428, 17, 132, 29);
		panel_button.add(btn_capnhat);
		btn_capnhat.setFont(new Font("Segoe UI", Font.BOLD, 15));

		btn_huybo = new JButton("Hủy bỏ");
		btn_huybo.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Pictogrammers-Material-Light-Cancel.16.png"));
		btn_huybo.setBackground(new Color(204, 102, 255));
		btn_huybo.setBounds(654, 17, 123, 29);
		panel_button.add(btn_huybo);

		btn_huybo.setFont(new Font("Segoe UI", Font.BOLD, 15));

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	// Getter các thành phần giao diện để sử dụng trong controller

	public JTextField getTfUserID() {
		return textField_userid;
	}

	public JTextField getTfNgay() {
		return textField_ngay;
	}

	public JTextField getTfTinhTrangCoThe() {
		return textField_tinhtrang2;
	}

	public JTextField getTfGioiTinh() {
		return textField_gioitinh;
	}

	public JTextField getTfChieuCao() {
		return textField_chieucao;
	}

	public JTextField getTfCanNang() {
		return textField_cannang;
	}

	public JTextField getTfHuyetAp() {
		return textField_huyetap;
	}

	public JTextField getTfNhipTim() {
		return textField_nhiptim;
	}

	public JTextField getTfLuongDuongMau() {
		return textField_luongduong;
	}

	public JTextField getTfNhietDoCoThe() {
		return textField_nhietdocothe;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnAdd() {
		return btn_them;
	}

	public JButton getBtnUpdate() {
		return btn_capnhat;
	}

	public JButton getBtnDelete() {
		return btn_xoa;
	}

	public JButton getBtnClear() {
		return btn_huybo;
	}

	public JTextField getTfSearchDate() {
		return textField_timkiem;
	}

	public JButton getBtnSearch() {
		return btn_tim;
	}

	public JButton getBtnCancelSearch() {
		return btn_huytim;
	}

	// Hàm thêm ActionListener cho các nút
	public void addHealthRecordListener(ActionListener listener) {
		btn_them.addActionListener(listener);
		btn_capnhat.addActionListener(listener);
		btn_xoa.addActionListener(listener);
		btn_huybo.addActionListener(listener);
		btn_tim.addActionListener(listener);
		btn_huytim.addActionListener(listener);
	}

	// Hàm thêm dữ liệu vào bảng
	public void addRowToTable(Object[] row) {
		tableModel.addRow(row);
	}

	public void clearTable() {
		tableModel.setRowCount(0);
	}

	public void addAddButtonListener(ActionListener listener) {
		btn_them.addActionListener(listener);
	}

	public void addUpdateButtonListener(ActionListener listener) {
		btn_capnhat.addActionListener(listener);
	}

	public void addDeleteButtonListener(ActionListener listener) {
		btn_xoa.addActionListener(listener);
	}

	public void addClearButtonListener(ActionListener listener) {
		btn_huybo.addActionListener(listener);
	}

}