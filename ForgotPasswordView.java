package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
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

public class ForgotPasswordView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField newPasswordField;
	private ChiSoSucKhoeView userManagementForm;
	private JButton btn_dangnhap;
	private JLabel lblErrorMessage;
	private JButton submitButton;
	private JCheckBox showPasswordCheckBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPasswordView frame = new ForgotPasswordView();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ForgotPasswordView() {
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

		JLabel lbl_dangnhap = new JLabel("Quên mật khẩu");
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

		usernameField = new JTextField();
		usernameField.setBackground(SystemColor.control);
		usernameField.setFont(new Font("Arial", Font.PLAIN, 15));
		usernameField.setBounds(561, 169, 342, 44);
		contentPane.add(usernameField);
		usernameField.setColumns(10);

		JLabel lbl_matkhau = new JLabel("Mật khẩu mới:");
		lbl_matkhau.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Icons8-Ios7-User-Interface-Password.32.png"));
		lbl_matkhau.setForeground(new Color(204, 102, 255));
		lbl_matkhau.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_matkhau.setBounds(378, 255, 173, 32);
		contentPane.add(lbl_matkhau);

		newPasswordField = new JPasswordField();
		newPasswordField.setBackground(SystemColor.control);
		newPasswordField.setFont(new Font("Arial", Font.PLAIN, 15));
		newPasswordField.setBounds(561, 255, 342, 44);
		contentPane.add(newPasswordField);

		// Checkbox để hiển thị mật khẩu
		showPasswordCheckBox = new JCheckBox("Hiển thị mật khẩu");
		showPasswordCheckBox.setFont(new Font("Arial", Font.PLAIN, 14));
		showPasswordCheckBox.setBounds(560, 323, 150, 25);
		contentPane.add(showPasswordCheckBox);

		// Xử lý sự kiện khi chọn checkbox
		showPasswordCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (showPasswordCheckBox.isSelected()) {
					// Hiển thị mật khẩu
					newPasswordField.setEchoChar((char) 0);

				} else {
					// Ẩn mật khẩu
					newPasswordField.setEchoChar('●');

				}
			}
		});

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(407, 371, 496, 8);
		contentPane.add(separator_1);

		btn_dangnhap = new JButton("Đăng nhập");
		btn_dangnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(submitButton);
				currentFrame.dispose();
				testLogin login = new testLogin();
				login.main(null);
			}
		});
		btn_dangnhap.setForeground(Color.BLACK);
		btn_dangnhap.setBackground(new Color(204, 102, 255));
		btn_dangnhap.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		btn_dangnhap.setBounds(701, 408, 144, 44);

		contentPane.add(btn_dangnhap);

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

		submitButton = new JButton("Xác nhận");

		submitButton.setForeground(Color.BLACK);
		submitButton.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		submitButton.setBackground(new Color(204, 102, 255));
		submitButton.setBounds(482, 408, 145, 44);
		contentPane.add(submitButton);

	}

	// Lấy tên đăng nhập và mật khẩu từ giao diện
	public String getUsername() {
		return usernameField.getText();
	}

	public String getPassword() {
		return new String(newPasswordField.getPassword());
	}

	public void addLoginListener(ActionListener listener) {
		btn_dangnhap.addActionListener(listener);
	}

	public void reset() {
		this.usernameField.setText("");
		this.newPasswordField.setText("");
	}

	public void setSubmitButtonActionListener(ActionListener listener) {
		submitButton.addActionListener(listener);
	}

}
