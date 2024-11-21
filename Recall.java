package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import test.testChiSoSucKhoe;

public class Recall extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recall frame = new Recall();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Recall() {
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
		panel_dangnhap.setBackground(new Color(204, 153, 102));
		panel_dangnhap.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(0, 0, 0), new Color(0, 0, 0)));
		panel_dangnhap.setBounds(10, 10, 893, 101);
		contentPane.add(panel_dangnhap);
		panel_dangnhap.setLayout(null);

		JLabel lbl_dangnhap = new JLabel("Nhắc nhở\r\n");
		lbl_dangnhap.setBackground(new Color(0, 102, 255));
		lbl_dangnhap.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Alecive-Flatwoken-Apps-Notifications.24.png"));
		lbl_dangnhap.setForeground(new Color(245, 255, 250));
		lbl_dangnhap.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_dangnhap.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 50));
		lbl_dangnhap.setBounds(246, 10, 355, 81);
		panel_dangnhap.add(lbl_dangnhap);

		JButton btn_kiemtra = new JButton("Nhập chỉ số sức khỏe");
		btn_kiemtra.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Dtafalonso-Ios8-Health.24.png"));
		btn_kiemtra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(btn_kiemtra);
				currentFrame.dispose();
				testChiSoSucKhoe chiSoSucKhoeView = new testChiSoSucKhoe();
				chiSoSucKhoeView.main(null);

			}
		});
		btn_kiemtra.setForeground(new Color(255, 153, 51));
		btn_kiemtra.setBackground(Color.WHITE);
		btn_kiemtra.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		btn_kiemtra.setBounds(168, 409, 304, 44);

		contentPane.add(btn_kiemtra);

		JButton btn_huybo = new JButton("Thoát");
		btn_huybo.setIcon(new ImageIcon(
				"C:\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\UngDungChamSocSucKhoe\\icon\\Saki-NuoveXT-2-Apps-session-logout.24.png"));
		btn_huybo.setForeground(new Color(255, 153, 51));
		btn_huybo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btn_huybo.setBackground(Color.WHITE);
		btn_huybo.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		btn_huybo.setBounds(609, 409, 144, 44);
		contentPane.add(btn_huybo);

		Panel panel = new Panel();
		panel.setBackground(new Color(255, 255, 128));
		panel.setBounds(168, 146, 587, 224);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lbl_dangnhap_1 = new JLabel("- Bạn đã nhập chỉ số sức khỏe trong ngày hôm nay chưa\r\n");
		lbl_dangnhap_1.setBounds(10, 14, 567, 47);
		lbl_dangnhap_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_dangnhap_1.setForeground(new Color(0, 0, 0));
		lbl_dangnhap_1.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 20));
		panel.add(lbl_dangnhap_1);

		JLabel lbl_dangnhap_1_1 = new JLabel("- Bạn đã kiểm tra báo cáo sức khỏe tuần này chưa");
		lbl_dangnhap_1_1.setBounds(10, 57, 567, 53);
		lbl_dangnhap_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_dangnhap_1_1.setForeground(Color.BLACK);
		lbl_dangnhap_1_1.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 20));
		panel.add(lbl_dangnhap_1_1);

		JLabel lbl_dangnhap_1_1_1 = new JLabel("- Chúc bạn có một ngày tràn đầy sức khỏe");
		lbl_dangnhap_1_1_1.setBounds(10, 164, 567, 50);
		lbl_dangnhap_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_dangnhap_1_1_1.setForeground(Color.BLACK);
		lbl_dangnhap_1_1_1.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 20));
		panel.add(lbl_dangnhap_1_1_1);

		JLabel lbl_dangnhap_1_1_2 = new JLabel("- Bạn đã đặt ra mục tiêu cho chỉ số sức khỏe của mình chưa");
		lbl_dangnhap_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_dangnhap_1_1_2.setForeground(Color.BLACK);
		lbl_dangnhap_1_1_2.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 20));
		lbl_dangnhap_1_1_2.setBounds(10, 107, 560, 53);
		panel.add(lbl_dangnhap_1_1_2);
	}
}