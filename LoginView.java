package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import test.SigninTest;
import test.testDoiMatKhau;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_taikhoan;
	private JPasswordField passwordField_matkhau;
	private ChiSoSucKhoeView userManagementForm;
	private JButton btn_dangnhap;
	private JButton btn_huybo;
	private JLabel lblErrorMessage;
	private JButton btn_dangki;
	private JCheckBox showPasswordCheckBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Iconka-Cat-Commerce-Review.32.png"));
		setTitle("Healthymeow");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 927, 524);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlLtHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_dangnhap = new JPanel();
		panel_dangnhap.setBackground(new Color(204, 102, 255));
		panel_dangnhap.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_dangnhap.setBounds(10, 10, 893, 101);
		contentPane.add(panel_dangnhap);
		panel_dangnhap.setLayout(null);

		JLabel lbl_dangnhap = new JLabel("Đăng nhập");
		lbl_dangnhap.setForeground(new Color(255, 255, 255));
		lbl_dangnhap.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_dangnhap.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 50));
		lbl_dangnhap.setBounds(295, 0, 354, 81);
		panel_dangnhap.add(lbl_dangnhap);

		JLabel lbl_taikhoan = new JLabel("Tài khoản:");
		lbl_taikhoan.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Oxygen-Icons.org-Oxygen-Places-user-identity.32.png"));
		lbl_taikhoan.setForeground(new Color(204, 102, 255));
		lbl_taikhoan.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_taikhoan.setBounds(407, 169, 144, 36);
		contentPane.add(lbl_taikhoan);

		textField_taikhoan = new JTextField();
		textField_taikhoan.setBackground(SystemColor.control);
		textField_taikhoan.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_taikhoan.setBounds(561, 169, 342, 44);
		contentPane.add(textField_taikhoan);
		textField_taikhoan.setColumns(10);

		JLabel lbl_matkhau = new JLabel("Mật khẩu:");
		lbl_matkhau.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Icons8-Ios7-User-Interface-Password.32.png"));
		lbl_matkhau.setForeground(new Color(204, 102, 255));
		lbl_matkhau.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_matkhau.setBounds(407, 255, 144, 32);
		contentPane.add(lbl_matkhau);

		passwordField_matkhau = new JPasswordField();
		passwordField_matkhau.setBackground(SystemColor.control);
		passwordField_matkhau.setFont(new Font("Arial", Font.PLAIN, 15));
		passwordField_matkhau.setBounds(561, 255, 342, 44);
		contentPane.add(passwordField_matkhau);

		// Checkbox để hiển thị mật khẩu
		showPasswordCheckBox = new JCheckBox("Hiển thị mật khẩu");
		showPasswordCheckBox.setFont(new Font("Arial", Font.PLAIN, 14));
		showPasswordCheckBox.setBounds(561, 313, 150, 25);
		contentPane.add(showPasswordCheckBox);

		// Xử lý sự kiện khi chọn checkbox
		showPasswordCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (showPasswordCheckBox.isSelected()) {
					// Hiển thị mật khẩu
					passwordField_matkhau.setEchoChar((char) 0);

				} else {
					// Ẩn mật khẩu
					passwordField_matkhau.setEchoChar('●');

				}
			}
		});

		// Thêm JLabel "Quên mật khẩu" vào giao diện đăng nhập
		JLabel lblForgotPassword = new JLabel("Quên mật khẩu?");
		lblForgotPassword.setForeground(new Color(0, 102, 204)); // Màu chữ xanh lam
		lblForgotPassword.setFont(new Font("Arial", Font.ITALIC, 14));
		lblForgotPassword.setBounds(781, 309, 122, 30); // Vị trí và kích thước
		lblForgotPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Hiệu ứng trỏ chuột
		contentPane.add(lblForgotPassword);

		// Gắn sự kiện nhấp chuột vào JLabel "Quên mật khẩu"
		lblForgotPassword.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(lblForgotPassword);
				currentFrame.dispose();
				testDoiMatKhau doimatkhau = new testDoiMatKhau();
				doimatkhau.main(null);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblForgotPassword.setForeground(new Color(255, 0, 0)); // Thay đổi màu khi di chuột vào
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblForgotPassword.setForeground(new Color(0, 102, 204)); // Khôi phục màu khi rời chuột
			}
		});

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(407, 371, 496, 8);
		contentPane.add(separator_1);

		btn_dangnhap = new JButton("Đăng nhập");
		btn_dangnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_dangnhap.setForeground(Color.BLACK);
		btn_dangnhap.setBackground(new Color(204, 102, 255));
		btn_dangnhap.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		btn_dangnhap.setBounds(592, 408, 144, 44);

		contentPane.add(btn_dangnhap);

		btn_huybo = new JButton("Hủy bỏ");
		btn_huybo.setBackground(new Color(204, 102, 255));
		btn_huybo.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		btn_huybo.setBounds(759, 408, 144, 44);
		contentPane.add(btn_huybo);

		JPanel panel_anh = new JPanel();
		panel_anh.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_anh.setBackground(new Color(204, 255, 255));
		panel_anh.setBounds(10, 121, 358, 356);
		contentPane.add(panel_anh);
		panel_anh.setLayout(null);

		JLabel lbl_anh = new JLabel("");
		lbl_anh.setBackground(new Color(255, 255, 255));
		lbl_anh.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Streamlineicons-Streamline-Ux-Free-Doctor-hospital.512.png"));
		lbl_anh.setBounds(10, 10, 338, 336);

		lblErrorMessage = new JLabel("");
		lblErrorMessage.setForeground(Color.RED);
		contentPane.add(lblErrorMessage);
		panel_anh.add(lbl_anh);

		btn_dangki = new JButton("Đăng kí");
		btn_dangki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(btn_dangki);
				currentFrame.dispose();
				SigninTest signin = new SigninTest();
				signin.main(null);
			}
		});
		btn_dangki.setForeground(Color.BLACK);
		btn_dangki.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		btn_dangki.setBackground(new Color(204, 102, 255));
		btn_dangki.setBounds(425, 408, 145, 44);
		contentPane.add(btn_dangki);
		this.setVisible(true);
	}

	// Lấy tên đăng nhập và mật khẩu từ giao diện
	public String getUsername() {
		return textField_taikhoan.getText();
	}

	public String getPassword() {
		return new String(passwordField_matkhau.getPassword());
	}

	public void addLoginListener(ActionListener listener) {
		btn_dangnhap.addActionListener(listener);
	}

	public void addCancelListener(ActionListener listener) {
		btn_huybo.addActionListener(listener);
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	public void reset() {
		this.textField_taikhoan.setText("");
		this.passwordField_matkhau.setText("");
	}

}
