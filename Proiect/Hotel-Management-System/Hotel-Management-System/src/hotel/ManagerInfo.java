package hotel;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerInfo extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ManagerInfo frame = new ManagerInfo();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void close() {
        this.dispose();
    }

    public ManagerInfo() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(430, 200, 1000, 600);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(41, 11, 46, 14);
        contentPane.add(labelName);

        JLabel labelAge = new JLabel("Age");
        labelAge.setBounds(159, 11, 46, 14);
        contentPane.add(labelAge);

        JLabel labelGender = new JLabel("Gender");
        labelGender.setBounds(273, 11, 46, 14);
        contentPane.add(labelGender);

        JLabel labelJob = new JLabel("Job");
        labelJob.setBounds(416, 11, 86, 14);
        contentPane.add(labelJob);

        JLabel labelSalary = new JLabel("Salary");
        labelSalary.setBounds(536, 11, 86, 14);
        contentPane.add(labelSalary);

        JLabel labelPhone = new JLabel("Phone");
        labelPhone.setBounds(656, 11, 86, 14);
        contentPane.add(labelPhone);

        JLabel labelIDNumber = new JLabel("IDNumber");
        labelIDNumber.setBounds(786, 11, 86, 14);
        contentPane.add(labelIDNumber);

        JLabel labelGmail = new JLabel("Gmail");
        labelGmail.setBounds(896, 11, 86, 14);
        contentPane.add(labelGmail);

        JTable table = new JTable();
        table.setBounds(0, 34, 1000, 450);
        contentPane.add(table);

        JButton btnLoadData = new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String displayCustomersql = "select * from Employee where job = 'Manager'";
                    ResultSet rs = c.statemant.executeQuery(displayCustomersql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }

        });
        btnLoadData.setBounds(350, 500, 120, 30);
        btnLoadData.setBackground(Color.BLACK);
        btnLoadData.setForeground(Color.WHITE);
        contentPane.add(btnLoadData);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(510, 500, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);
    }
}