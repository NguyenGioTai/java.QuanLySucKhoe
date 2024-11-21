package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import test.testLogin;

public class SignIn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textuser;
	private JPasswordField txtpass;
	private JPasswordField txtcfpass;
	private JButton btn_dangky;
	private JCheckBox showPasswordCheckBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				SignIn frame = new SignIn();

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignIn() {
		setTitle("HealthyMeow");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Iconka-Cat-Commerce-Review.32.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 886, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Header Panel
		JPanel panel_dangnhap = new JPanel();
		panel_dangnhap.setLayout(null);
		panel_dangnhap.setBorder(new BevelBorder(BevelBorder.LOWERED));
		panel_dangnhap.setBackground(new Color(204, 102, 255));
		panel_dangnhap.setBounds(0, 0, 872, 101);
		contentPane.add(panel_dangnhap);

		JLabel lbl_dangnhap = new JLabel("Đăng ký");
		lbl_dangnhap.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_dangnhap.setForeground(Color.WHITE);
		lbl_dangnhap.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 50));
		lbl_dangnhap.setBounds(246, 10, 354, 81);
		panel_dangnhap.add(lbl_dangnhap);

		// User Input Panel
		JLabel lbl_taikhoan = new JLabel("Tài khoản:");
		lbl_taikhoan.setForeground(new Color(204, 102, 255));
		lbl_taikhoan.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_taikhoan.setBounds(378, 158, 144, 36);
		contentPane.add(lbl_taikhoan);

		textuser = new JTextField();
		textuser.setFont(new Font("Arial", Font.PLAIN, 15));
		textuser.setBounds(611, 156, 251, 44);
		contentPane.add(textuser);

		JLabel lbl_matkhau = new JLabel("Mật khẩu:");
		lbl_matkhau.setForeground(new Color(204, 102, 255));
		lbl_matkhau.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_matkhau.setBounds(378, 236, 144, 32);
		contentPane.add(lbl_matkhau);

		txtpass = new JPasswordField();
		txtpass.setBounds(611, 234, 251, 44);
		contentPane.add(txtpass);

		JLabel lbl_cfpass = new JLabel("Nhập lại mật khẩu:");
		lbl_cfpass.setForeground(new Color(204, 102, 255));
		lbl_cfpass.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_cfpass.setBounds(378, 315, 227, 32);
		contentPane.add(lbl_cfpass);

		txtcfpass = new JPasswordField();
		txtcfpass.setBounds(611, 313, 251, 44);
		contentPane.add(txtcfpass);

		// Checkbox để hiển thị mật khẩu
		showPasswordCheckBox = new JCheckBox("Hiển thị mật khẩu");
		showPasswordCheckBox.setFont(new Font("Arial", Font.PLAIN, 14));
		showPasswordCheckBox.setBounds(611, 375, 150, 25);
		contentPane.add(showPasswordCheckBox);

		// Xử lý sự kiện khi chọn checkbox
		showPasswordCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (showPasswordCheckBox.isSelected()) {
					// Hiển thị mật khẩu
					txtpass.setEchoChar((char) 0);
					txtcfpass.setEchoChar((char) 0);
				} else {
					// Ẩn mật khẩu
					txtpass.setEchoChar('●');
					txtcfpass.setEchoChar('●');
				}
			}
		});

		// Buttons
		btn_dangky = new JButton("Đăng ký");
		btn_dangky.setForeground(Color.BLACK);
		btn_dangky.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		btn_dangky.setBackground(new Color(204, 102, 255));
		btn_dangky.setBounds(461, 448, 144, 44);
		contentPane.add(btn_dangky);

		JButton btn_dangnhap = new JButton("Đăng nhập");
		btn_dangnhap.setForeground(Color.BLACK);
		btn_dangnhap.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		btn_dangnhap.setBackground(new Color(204, 102, 255));
		btn_dangnhap.setBounds(671, 448, 144, 44);
		btn_dangnhap.addActionListener(e -> {
			JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(btn_dangnhap);
			currentFrame.dispose();
			// Call your login view here
			testLogin login = new testLogin();
			login.main(null);
		});
		contentPane.add(btn_dangnhap);

		JPanel panel_anh = new JPanel();
		panel_anh.setLayout(null);
		panel_anh.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_anh.setBackground(new Color(204, 255, 255));
		panel_anh.setBounds(10, 111, 358, 356);
		contentPane.add(panel_anh);

		JLabel lbl_anh = new JLabel("");
		lbl_anh.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Streamlineicons-Streamline-Ux-Free-Doctor-hospital.512.png"));
		lbl_anh.setBackground(Color.WHITE);
		lbl_anh.setBounds(0, 10, 348, 336);
		panel_anh.add(lbl_anh);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(412, 419, 450, 2);
		contentPane.add(separator_1);
	}

	/**
	 * Get username entered by user.
	 */
	public String getName() {
		return textuser.getText().trim();
	}

	/**
	 * Get password entered by user.
	 */
	public String getPassword() {
		return new String(txtpass.getPassword()).trim();
	}

	/**
	 * Get confirm password entered by user.
	 */
	public String getConfirmPassword() {
		return new String(txtcfpass.getPassword()).trim();
	}

	/**
	 * Get the Sign-Up button.
	 */
	public JButton getBtnSignUp() {
		return btn_dangky;
	}

	/**
	 * Clear input fields after successful registration.
	 */
	public void clearFields() {
		textuser.setText("");
		txtpass.setText("");
		txtcfpass.setText("");
	}
}
