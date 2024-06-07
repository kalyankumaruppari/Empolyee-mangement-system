import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField tfName, tfAge, tfSalary, tfPhone, tfEmail, tfJob;
    JButton update, back;

    UpdateEmployee() {
        super("Update Employee");

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(20, 20, 100, 30);
        add(lblName);

        tfName = new JTextField();
        tfName.setBounds(150, 20, 150, 30);
        add(tfName);

        JLabel lblAge = new JLabel("Age:");
        lblAge.setBounds(20, 70, 100, 30);
        add(lblAge);

        tfAge = new JTextField();
        tfAge.setBounds(150, 70, 150, 30);
        add(tfAge);

        JLabel lblSalary = new JLabel("Salary:");
        lblSalary.setBounds(20, 120, 100, 30);
        add(lblSalary);

        tfSalary = new JTextField();
        tfSalary.setBounds(150, 120, 150, 30);
        add(tfSalary);

        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setBounds(20, 170, 100, 30);
        add(lblPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(150, 170, 150, 30);
        add(tfPhone);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(20, 220, 100, 30);
        add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(150, 220, 150, 30);
        add(tfEmail);

        JLabel lblJob = new JLabel("Job:");
        lblJob.setBounds(20, 270, 100, 30);
        add(lblJob);

        tfJob = new JTextField();
        tfJob.setBounds(150, 270, 150, 30);
        add(tfJob);

        update = new JButton("Update");
        update.setBounds(100, 320, 120, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(240, 320, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setLayout(null);
        setSize(500, 500);
        setLocation(400, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            try {
                String name = tfName.getText();
                int age = Integer.parseInt(tfAge.getText());
                int salary = Integer.parseInt(tfSalary.getText());
                String phone = tfPhone.getText();
                String email = tfEmail.getText();
                String job = tfJob.getText();

                Conn c = new Conn();
                String query = "update employee set age=" + age + ", salary=" + salary + ", phone='" + phone + "', email='" + email + "', job='" + job + "' where name='" + name + "'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Employee updated successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee();
    }
}
