import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewEmployee extends JFrame implements ActionListener {

    JTable t1;
    JButton back;

    ViewEmployee() {
        super("View Employees");

        t1 = new JTable();
        t1.setBounds(0, 40, 1000, 500);
        add(t1);

        back = new JButton("Back");
        back.setBounds(450, 560, 120, 30);
        back.addActionListener(this);
        add(back);

        String[] columnNames = {"Name", "Age", "Salary", "Phone", "Email", "Job"};
        String[][] data = new String[20][6];
        int i = 0;
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while (rs.next()) {
                data[i][0] = rs.getString("name");
                data[i][1] = rs.getString("age");
                data[i][2] = rs.getString("salary");
                data[i][3] = rs.getString("phone");
                data[i][4] = rs.getString("email");
                data[i][5] = rs.getString("job");
                i++;
            }
            t1.setModel(new DefaultTableModel(data, columnNames));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(null);
        setSize(1000, 650);
        setLocation(200, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}
