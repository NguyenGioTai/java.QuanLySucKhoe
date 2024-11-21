package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import DAO.ForgotPasswordDAO;
import model.ForgotPasswordModel;
import view.ForgotPasswordView;

public class ForgotPasswordController {

	private ForgotPasswordView forgotPasswordView;
	private ForgotPasswordDAO forgotPasswordDAO;

	// Constructor: initializes the view and DAO, sets up the action listener
	public ForgotPasswordController(ForgotPasswordView forgotPasswordView, ForgotPasswordDAO forgotPasswordDAO) {
		this.forgotPasswordView = forgotPasswordView;
		this.forgotPasswordDAO = forgotPasswordDAO;

		// Make the forgot password form visible
		forgotPasswordView.setVisible(true);

		// Set the action listener for the submit button
		forgotPasswordView.setSubmitButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Get username and new password from the view
				String username = forgotPasswordView.getUsername();
				String newPassword = forgotPasswordView.getPassword();

				// Validate inputs
				if (username.isEmpty() || newPassword.isEmpty()) {
					JOptionPane.showMessageDialog(forgotPasswordView, "Vui lòng điền đầy đủ thông tin!", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Check if the user exists in the database
				if (forgotPasswordDAO.checkUserExists(username)) {
					// Create the model to update the password
					ForgotPasswordModel model = new ForgotPasswordModel(username, newPassword);
					// Attempt to reset the password
					if (forgotPasswordDAO.resetPassword(model)) {
						JOptionPane.showMessageDialog(forgotPasswordView, "Mật khẩu đã được thay đổi!", "Thông báo",
								JOptionPane.INFORMATION_MESSAGE);
						forgotPasswordView.reset(); // Reset fields after successful password reset
					} else {
						JOptionPane.showMessageDialog(forgotPasswordView, "Không thể thay đổi mật khẩu!", "Lỗi",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(forgotPasswordView, "Tên đăng nhập không tồn tại!", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	// Main method to test the ForgotPasswordController
	public static void main(String[] args) {
		ForgotPasswordView forgotPasswordView = new ForgotPasswordView(); // Initialize the view
		ForgotPasswordDAO forgotPasswordDAO = new ForgotPasswordDAO(); // Initialize the DAO
		new ForgotPasswordController(forgotPasswordView, forgotPasswordDAO); // Instantiate the controller
	}
}
