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
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import test.testBaoCao;
import test.testChiSoSucKhoe;
import test.testLogin;
import test.testMucTieu;
import test.testRecall;

public class MucTieuView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTable table_muctieu;
	public ButtonGroup btn_gioitinh;
	private JTextField txtLunTt;
	private JTextField textField_chieucao;
	private JTextField textField_cannang;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_thoigian;
	private JButton btn_them;
	private JButton btn_capnhat;
	private JButton btn_xoa;
	private JButton btn_hoanthanh;
	private JButton btn_lammoi;
	private JTable table_muctieuhoanthanh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MucTieuView frame = new MucTieuView();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MucTieuView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Iconka-Cat-Commerce-Review.32.png"));
		setTitle("Healthymeow");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1111, 772);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		setJMenuBar(menuBar);

		JMenuItem mn_DangXuat = new JMenuItem("Đăng xuất");
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

		JMenuItem mn_QuanLiNguoiDung = new JMenuItem("Quản lý người dùng");
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

		JMenuItem mn_MucTieu = new JMenuItem("Mục tiêu sức khỏe");
		mn_MucTieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(mn_DangXuat);
				currentFrame.dispose();
				testMucTieu mucTieu = new testMucTieu();
				mucTieu.main(null);
				;

			}
		});
		mn_MucTieu.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Gartoon-Team-Gartoon-Misc-Seahorse-Applet-Signed.24.png"));
		mn_MucTieu.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mn_MucTieu);

		JMenuItem mn_BaoCaoChiTiet = new JMenuItem("Báo cáo chi tiết");
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

		JMenuItem mn_NhacNho = new JMenuItem("Nhắc nhở");
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
				JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(mn_Thoat);
				currentFrame.dispose();
				testRecall recall = new testRecall();
				recall.main(null);
			}
		});
		menuBar.add(mn_Thoat);

		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btn_gioitinh = new ButtonGroup();

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 0, 0), new Color(128, 0, 0),
				new Color(128, 0, 0), new Color(128, 0, 0)));
		panel.setBackground(SystemColor.text);
		panel.setBounds(10, 10, 1077, 79);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("--- Mục tiêu chỉ số sức khỏe của bạn trong thời gian tới ---");
		lblNewLabel.setForeground(new Color(153, 102, 204));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(59, 10, 965, 59);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		panel_1.setForeground(Color.BLACK);
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(10, 113, 410, 549);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Thời gian:");
		lblNewLabel_1.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Icons8-Ios7-Time-And-Date-Calendar.24.png"));
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 100, 116, 26);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Tình trạng cơ thể:");
		lblNewLabel_1_1.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Ionic-Ionicons-Body-outline.24.png"));
		lblNewLabel_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 283, 181, 26);
		panel_1.add(lblNewLabel_1_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 69, 0), new Color(255, 69, 0),
				new Color(255, 69, 0), new Color(255, 69, 0)));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 10, 390, 55);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("MỤC TIÊU");
		lblNewLabel_2.setForeground(new Color(255, 99, 71));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblNewLabel_2.setBounds(10, 10, 370, 35);
		panel_2.add(lblNewLabel_2);

		txtLunTt = new JTextField();
		txtLunTt.setEditable(false);
		txtLunTt.setHorizontalAlignment(SwingConstants.CENTER);
		txtLunTt.setText("Ổn định");
		txtLunTt.setFont(new Font("Arial", Font.PLAIN, 13));
		txtLunTt.setColumns(10);
		txtLunTt.setBounds(214, 282, 106, 32);
		panel_1.add(txtLunTt);

		JLabel lblNewLabel_1_1_1 = new JLabel("Chiều cao:");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Pictogrammers-Material-Human-male-height.24.png"));
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(10, 163, 132, 26);
		panel_1.add(lblNewLabel_1_1_1);

		textField_chieucao = new JTextField();
		textField_chieucao.setHorizontalAlignment(SwingConstants.CENTER);
		textField_chieucao.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_chieucao.setColumns(10);
		textField_chieucao.setBounds(152, 162, 97, 32);
		panel_1.add(textField_chieucao);

		JLabel lblNewLabel_3 = new JLabel("Cm");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(259, 162, 45, 31);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Cân nặng:");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Icons8-Ios7-Science-Weight.24.png"));
		lblNewLabel_1_1_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(10, 225, 116, 26);
		panel_1.add(lblNewLabel_1_1_1_1);

		textField_cannang = new JTextField();
		textField_cannang.setHorizontalAlignment(SwingConstants.CENTER);
		textField_cannang.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_cannang.setColumns(10);
		textField_cannang.setBounds(152, 224, 97, 32);
		panel_1.add(textField_cannang);

		JLabel lblNewLabel_3_1 = new JLabel("Kg");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(259, 224, 45, 31);
		panel_1.add(lblNewLabel_3_1);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Huyết áp:");
		lblNewLabel_1_1_1_1_1.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Iconsmind-Outline-Blood.24.png"));
		lblNewLabel_1_1_1_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1.setBounds(10, 391, 116, 26);
		panel_1.add(lblNewLabel_1_1_1_1_1);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setText("120/80");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(152, 389, 97, 32);
		panel_1.add(textField_3);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Nhịp tim:");
		lblNewLabel_1_1_1_1_1_1.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Amitjakhu-Drip-Heart.24.png"));
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 448, 116, 26);
		panel_1.add(lblNewLabel_1_1_1_1_1_1);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setText("60-100");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(152, 446, 97, 32);
		panel_1.add(textField_4);

		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Nhiệt độ cơ thể:");
		lblNewLabel_1_1_1_1_1_1_1.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Iconsmind-Outline-Temperature-2.24.png"));
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(10, 502, 158, 26);
		panel_1.add(lblNewLabel_1_1_1_1_1_1_1);

		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setText("36.3 - 37.1");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(201, 500, 97, 32);
		panel_1.add(textField_5);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 69, 0), new Color(255, 69, 0),
				new Color(255, 69, 0), new Color(255, 69, 0)));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 328, 390, 46);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Những chỉ số lý tưởng của cơ thể khỏe mạnh");
		lblNewLabel_4.setForeground(new Color(255, 99, 71));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Arial", Font.ITALIC, 17));
		lblNewLabel_4.setBounds(23, 10, 350, 26);
		panel_3.add(lblNewLabel_4);

		JLabel lblNewLabel_3_2 = new JLabel("mmHg");
		lblNewLabel_3_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3_2.setBounds(259, 390, 45, 31);
		panel_1.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_2_1 = new JLabel("Lần/phút khi nghỉ ngơi");
		lblNewLabel_3_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3_2_1.setBounds(259, 447, 149, 31);
		panel_1.add(lblNewLabel_3_2_1);

		JLabel lblNewLabel_3_2_2 = new JLabel("°C");
		lblNewLabel_3_2_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3_2_2.setBounds(308, 502, 45, 31);
		panel_1.add(lblNewLabel_3_2_2);

		JLabel lblNewLabel_3_3 = new JLabel("Ngày");
		lblNewLabel_3_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3_3.setBounds(262, 99, 45, 31);
		panel_1.add(lblNewLabel_3_3);

		textField_thoigian = new JTextField();
		textField_thoigian.setHorizontalAlignment(SwingConstants.CENTER);
		textField_thoigian.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_thoigian.setColumns(10);
		textField_thoigian.setBounds(152, 99, 97, 32);
		panel_1.add(textField_thoigian);

		btn_them = new JButton("");
		btn_them.setBounds(35, 672, 69, 29);
		contentPane.add(btn_them);
		btn_them.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Paomedia-Small-N-Flat-Sign-add.16.png"));
		btn_them.setBackground(new Color(255, 255, 255));
		btn_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btn_them.setFont(new Font("Segoe UI", Font.BOLD, 13));

		btn_capnhat = new JButton("");
		btn_capnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_capnhat.setBounds(183, 672, 69, 29);
		contentPane.add(btn_capnhat);
		btn_capnhat.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Oxygen-Icons.org-Oxygen-Actions-edit-redo.16.png"));
		btn_capnhat.setBackground(new Color(255, 255, 255));

		btn_capnhat.setFont(new Font("Segoe UI", Font.BOLD, 15));

		btn_xoa = new JButton("");
		btn_xoa.setBounds(335, 672, 63, 29);
		contentPane.add(btn_xoa);
		btn_xoa.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Hopstarter-Sleek-Xp-Basic-Close-2.16.png"));
		btn_xoa.setBackground(new Color(255, 255, 255));

		btn_xoa.setFont(new Font("Segoe UI", Font.BOLD, 15));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(430, 144, 612, 203);
		contentPane.add(scrollPane);

		table_muctieu = new JTable();
		table_muctieu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_muctieu.setFont(new Font("Arial", Font.PLAIN, 15));
		table_muctieu.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Thời gian (ngày)", "Chiều cao (cm)", "Cân nặng (kg)" }));
		table_muctieu.setRowHeight(25);
		scrollPane.setViewportView(table_muctieu);

		JLabel lblNewLabel_2_1 = new JLabel("Chiều cao và cân nặng môn muốn của bạn");
		lblNewLabel_2_1.setBounds(546, 99, 407, 35);
		contentPane.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(new Color(255, 99, 71));
		lblNewLabel_2_1.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 18));

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(714, 357, 328, 63);
		contentPane.add(panel_4);
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 153, 0), new Color(255, 153, 0),
				new Color(255, 153, 0), new Color(255, 165, 0)));
		panel_4.setBackground(new Color(255, 250, 240));
		panel_4.setLayout(null);

		btn_hoanthanh = new JButton("Hoàn thành");
		btn_hoanthanh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_hoanthanh.setBounds(10, 20, 144, 29);
		panel_4.add(btn_hoanthanh);
		btn_hoanthanh.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Graphicloads-Folded-Check-page-folded.24.png"));
		btn_hoanthanh.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn_hoanthanh.setBackground(Color.WHITE);

		btn_lammoi = new JButton("Làm mới");
		btn_lammoi.setBounds(186, 20, 132, 29);
		panel_4.add(btn_lammoi);
		btn_lammoi.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Tatice-Cristal-Intense-Reload.24.png"));
		btn_lammoi.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn_lammoi.setBackground(Color.WHITE);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(430, 486, 612, 203);
		contentPane.add(scrollPane_1);

		table_muctieuhoanthanh = new JTable();
		table_muctieuhoanthanh.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_muctieuhoanthanh.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Thời gian (ngày)", "Chiều cao (cm)", "Cân nặng (kg)" }));
		table_muctieuhoanthanh.setRowHeight(25);
		table_muctieuhoanthanh.setFont(new Font("Arial", Font.PLAIN, 15));
		scrollPane_1.setViewportView(table_muctieuhoanthanh);

		JLabel lblNewLabel_2_1_1 = new JLabel("Mục tiêu đã hoàn thành");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setForeground(new Color(255, 99, 71));
		lblNewLabel_2_1_1.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_1_1.setBounds(546, 441, 407, 35);
		contentPane.add(lblNewLabel_2_1_1);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public JTextField getTfThoiGian() {
		return textField_thoigian;
	}

	public JTextField getTfChieuCao() {
		return textField_chieucao;
	}

	public JTextField getTfCanNang() {
		return textField_cannang;
	}

	public JTable getTableMucTieu() {
		return table_muctieu;
	}

	public JButton getBtnThem() {
		return btn_them;
	}

	public JButton getBtnSua() {
		return btn_capnhat;
	}

	public JButton getBtnXoa() {
		return btn_xoa;
	}

	public JButton getBtnLamMoi() {
		return btn_lammoi;
	}

	public JButton getBtnHoanThanh() {
		return btn_hoanthanh;
	}

	public JTable getTableMucTieuHoanThanh() {

		return table_muctieuhoanthanh;
	}

}
