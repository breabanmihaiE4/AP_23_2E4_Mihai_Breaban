package hotel;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

import static java.lang.System.exit;

public class Login extends JFrame implements ActionListener {
    JTextField textUsername;
    JPasswordField textPassword;
    JButton buttonLogin, buttonCancel;

    Login() {

        super("Login");

        setLayout(null);

        JLabel labelUsername = new JLabel("Username");
        labelUsername.setBounds(40, 20, 100, 30);
        add(labelUsername);

        textUsername = new JTextField();
        textUsername.setBounds(150, 20, 150, 30);
        add(textUsername);

        JLabel labelPassword = new JLabel("Password");
        labelPassword.setBounds(40, 70, 100, 30);
        add(labelPassword);

        textPassword = new JPasswordField();
        textPassword.setBounds(150, 70, 150, 30);
        add(textPassword);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350, 10, 150, 150);
        add(l3);


        buttonLogin = new JButton("Login");
        buttonLogin.setBounds(40, 140, 120, 30);
        buttonLogin.setFont(new Font("serif", Font.BOLD, 15));
        buttonLogin.addActionListener(this);
        buttonLogin.setBackground(Color.BLACK);
        buttonLogin.setForeground(Color.WHITE);
        add(buttonLogin);

        buttonCancel = new JButton("Cancel");
        buttonCancel.setBounds(180, 140, 120, 30);
        buttonCancel.setFont(new Font("serif", Font.BOLD, 15));
        buttonCancel.setBackground(Color.BLACK);
        buttonCancel.setForeground(Color.WHITE);
        add(buttonCancel);

        buttonCancel.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(600, 300);
        setLocation(600, 350);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == buttonLogin) {
            try {
                conn c1 = new conn();
                String username = textUsername.getText();
                String password = textPassword.getText();

                String q = "select * from login where username='" + username + "' and password='" + password + "'";

                ResultSet rs = c1.statemant.executeQuery(q);
                if (rs.next()) {
                    new Dashboard().setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    setVisible(false);
                    exit(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == buttonCancel) {
            exit(0);
        }
    }

    public static void main(String[] arg) {
        new Login();
    }
}