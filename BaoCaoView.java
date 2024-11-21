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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import test.testChiSoSucKhoe;
import test.testLogin;
import test.testMucTieu;
import test.testRecall;

public class BaoCaoView extends JFrame {

	private static final long serialVersionUID = 1L;
	public ButtonGroup btn_gioitinh;
	private DefaultTableModel tableModel;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaoCaoView frame = new BaoCaoView();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BaoCaoView() {
		getContentPane().setBackground(SystemColor.info);
		getContentPane().setLayout(null);

		JLabel lbl_danhsachphieu = new JLabel("Báo Cáo Chi Tiết");
		lbl_danhsachphieu.setBounds(10, 10, 149, 33);
		lbl_danhsachphieu.setForeground(new Color(153, 0, 204));
		lbl_danhsachphieu.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 15));
		getContentPane().add(lbl_danhsachphieu);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 120, 841, 121);
		getContentPane().add(scrollPane);

		tableModel = new DefaultTableModel(new String[] { "Ngày", "Tình trạng cơ thể", "Gi\u1EDBi t\u00EDnh",
				"Chi\u1EC1u cao", "C\u00E2n n\u1EB7ng", "Huy\u1EBFt \u00E1p", "Nh\u1ECBp tim", "Lượng đường",
				"Nhi\u1EC7t \u0111\u1ED9 c\u01A1 th\u1EC3" }, 0);
		table = new JTable(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));

		table.setRowHeight(25);
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(434, 288, 368, 196);
		getContentPane().add(panel);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 368, 196);
		panel.add(textArea);

		JButton btnKtvslk = new JButton("Kiểm tra và cho lời khuyên");
		btnKtvslk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		btnKtvslk.setForeground(Color.BLACK);
		btnKtvslk.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		btnKtvslk.setBackground(new Color(204, 102, 255));
		btnKtvslk.setBounds(248, 640, 300, 44);
		getContentPane().add(btnKtvslk);

		JLabel lbl_danhsachphieu_1 = new JLabel("So sánh và Lời khuyên");
		lbl_danhsachphieu_1.setBounds(10, 251, 208, 33);
		getContentPane().add(lbl_danhsachphieu_1);
		lbl_danhsachphieu_1.setForeground(new Color(153, 0, 204));
		lbl_danhsachphieu_1.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 15));

		JPanel panel_timkiem = new JPanel();
		panel_timkiem.setBounds(10, 49, 841, 54);
		getContentPane().add(panel_timkiem);
		panel_timkiem.setLayout(null);
		panel_timkiem.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_timkiem.setBackground(Color.WHITE);

		JButton btn_timbc = new JButton("Tìm");
		btn_timbc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_timbc.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Ampeross-Qetto-2-Search.16.png"));
		btn_timbc.setForeground(new Color(255, 153, 0));
		btn_timbc.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		btn_timbc.setBackground(Color.WHITE);
		btn_timbc.setBounds(405, 7, 120, 33);
		panel_timkiem.add(btn_timbc);

		JButton btn_huytimbc = new JButton("Hủy tìm");
		btn_huytimbc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_huytimbc.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Hopstarter-Sleek-Xp-Basic-Close-2.16.png"));
		btn_huytimbc.setForeground(new Color(255, 153, 0));
		btn_huytimbc.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		btn_huytimbc.setBackground(Color.WHITE);
		btn_huytimbc.setBounds(624, 7, 120, 33);
		panel_timkiem.add(btn_huytimbc);

		JLabel lbl_tinhtrang = new JLabel("Ngày:");
		lbl_tinhtrang.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Icons8-Ios7-Time-And-Date-Calendar.24.png"));
		lbl_tinhtrang.setForeground(new Color(255, 153, 0));
		lbl_tinhtrang.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lbl_tinhtrang.setBounds(10, 0, 101, 47);
		panel_timkiem.add(lbl_tinhtrang);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(137, 8, 224, 31);
		panel_timkiem.add(textField);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 251, 841, 4);
		getContentPane().add(separator_1_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(44, 288, 340, 335);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JTextArea txtrCcChS = new JTextArea();
		txtrCcChS.setText(
				"Các chỉ số trung bình: \r\n   -Chiều cao: \r\n      + Nam: 1.65 m - 1.8 m\r\n      + Nữ: 1.55 m - 1.7 m\r\n   -Cân nặng:\r\n      + Nam: 55 kg - 90 kg\r\n      + Nữ: 45 kg - 80 kg\r\n\r\n   -Huyết áp: 90 - 120 mmHg\r\n\r\n   -Nhịp tim: 60 - 100 nhịp/phút\r\n\r\n   -Lượng đường: \r\n      +Lúc đói: 70 - 100 mg/dL\n\r\n      +Sau ăn: Dưới 140 mg/dL\r\n\r\n   -Nhiệt độ cơ thể: 36.1°C - 37.2°C");
		txtrCcChS.setBounds(0, 0, 340, 335);
		panel_1.add(txtrCcChS);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Iconka-Cat-Commerce-Review.32.png"));
		setTitle("Healthymeow");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 772);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenuItem mn_DangXuat = new JMenuItem("Đăng xuất     ");
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
				JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(mn_QuanLiNguoiDung);
				currentFrame.dispose();
				testChiSoSucKhoe chiSoSucKhoeView = new testChiSoSucKhoe();
				chiSoSucKhoeView.main(null);

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
		mn_Thoat.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Saki-NuoveXT-2-Apps-session-logout.24.png"));
		mn_Thoat.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		mn_Thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recall Recall = new Recall();
				view.Recall Recall2 = new Recall();
				Recall2.setVisible(true);

				dispose();
			}
		});
		menuBar.add(mn_Thoat);

		tableModel = new DefaultTableModel(new String[] { "Mã Phiếu", "Ngày", "Tình trạng cơ thể",
				"Gi\u1EDBi t\u00EDnh", "Chi\u1EC1u cao", "C\u00E2n n\u1EB7ng", "Huy\u1EBFt \u00E1p", "Nh\u1ECBp tim",
				"Lượng đường", "Nhi\u1EC7t \u0111\u1ED9 c\u01A1 th\u1EC3" }, 0);

		btn_gioitinh = new ButtonGroup();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public Object getTable() {
		// TODO Auto-generated method stub
		return null;
	}

}
