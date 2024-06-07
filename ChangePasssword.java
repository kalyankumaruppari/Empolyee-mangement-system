import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ChangePassword extends JFrame implements ActionListener {

    JTextField tfOldPassword, tfNewPassword;

    ChangePassword() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblOldPassword = new JLabel("Old Password");
        lblOldPassword.setBounds(40, 20, 100, 30);
        add(lblOldPassword);

        tfOldPassword = new JPasswordField();
        tfOldPassword.setBounds(150, 20, 150, 30);
        add(tfOldPassword);

        JLabel lblNewPassword = new JLabel("New Password");
        lblNewPassword.setBounds(40, 70, 100, 30);
        add(lblNewPassword);

        tfNewPassword = new JPasswordField();
        tfNewPassword.setBounds(150, 70, 150, 30);
        add(tfNewPassword);

        JButton submit = new JButton("Submit");
        submit.setBounds(150, 120, 100, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String oldPassword = tfOldPassword.getText();
                String newPassword = tfNewPassword.getText();

                try {
                    Conn c = new Conn();
                    // Check if old password is correct
                    String query = "select * from login where password = ?";
                    PreparedStatement pstmt = c.prepareStatement(query);
                    pstmt.setString(1, oldPassword);
                    ResultSet rs = pstmt.executeQuery();

                    if (rs.next()) {
                        // Update password if old password is correct
                        String updateQuery = "update login set password = ? where password = ?";
                        PreparedStatement updatePstmt = c.prepareStatement(updateQuery);
                        updatePstmt.setString(1, newPassword);
                        updatePstmt.setString(2, oldPassword);
                        int rowsAffected = updatePstmt.executeUpdate();

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Password updated successfully");
                            setVisible(false);
                            new Home();
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to update password");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect old password");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        add(submit);

        setSize(400, 200);
        setLocation(500, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ChangePassword();
    }
}
