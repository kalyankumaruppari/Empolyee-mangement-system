import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField tfName, tfAge, tfSalary, tfPhone, tfEmail, tfJob;

    AddEmployee() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(40, 20, 100, 30);
        add(lblName);

        tfName = new JTextField();
        tfName.setBounds(150, 20, 150, 30);
        add(tfName);

        JLabel lblAge = new JLabel("Age");
        lblAge.setBounds(40, 70, 100, 30);
        add(lblAge);

        tfAge = new JTextField();
        tfAge.setBounds(150, 70, 150, 30);
        add(tfAge);

        JLabel lblSalary = new JLabel("Salary");
        lblSalary.setBounds(40, 120, 100, 30);
        add(lblSalary);

        tfSalary = new JTextField();
        tfSalary.setBounds(150, 120, 150, 30);
        add(tfSalary);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(40, 170, 100, 30);
        add(lblPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(150, 170, 150, 30);
        add(tfPhone);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(40, 220, 100, 30);
        add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(150, 220, 150, 30);
        add(tfEmail);

        JLabel lblJob = new JLabel("Job");
        lblJob.setBounds(40, 270, 100, 30);
        add(lblJob);

        tfJob = new JTextField();
        tfJob.setBounds(150, 270, 150, 30);
        add(tfJob);

        JButton submit = new JButton("Submit");
        submit.setBounds(150, 320, 100, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        setSize(400, 400);
        setLocation(500, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String name = tfName.getText();
            int age = Integer.parseInt(tfAge.getText());
            int salary = Integer.parseInt(tfSalary.getText());
            String phone = tfPhone.getText();
            String email = tfEmail.getText();
            String job = tfJob.getText();

            Conn c = new Conn();
            String query = "insert into employee values('" + name + "'," + age + "," + salary + ",'" + phone + "','" + email + "','" + job + "')";
            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Employee added successfully");
            setVisible(false);
            new Home();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
