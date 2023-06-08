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

public class Room extends JFrame {

    public Room() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 200, 1100, 600);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/room.jpg"));
        Image i3 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(500, 0, 600, 600);
        add(l1);

        JLabel labelRoonNumber = new JLabel("Room Number");
        labelRoonNumber.setBounds(12, 15, 90, 14);
        contentPane.add(labelRoonNumber);

        JLabel labelAvailability = new JLabel("Availability");
        labelAvailability.setBounds(119, 15, 69, 14);
        contentPane.add(labelAvailability);

        JLabel labelCleanStatus = new JLabel("Clean Status");
        labelCleanStatus.setBounds(216, 15, 76, 14);
        contentPane.add(labelCleanStatus);

        JLabel labelPrice = new JLabel("Price");
        labelPrice.setBounds(330, 15, 46, 14);
        contentPane.add(labelPrice);

        JLabel labelBedType = new JLabel("Bed Type");
        labelBedType.setBounds(417, 15, 76, 14);
        contentPane.add(labelBedType);

        JTable table = new JTable();
        table.setBounds(0, 40, 500, 400);
        contentPane.add(table);

        JButton btnLoadData = new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String displayCustomersql = "select * from Room";
                    ResultSet rs = c.statemant.executeQuery(displayCustomersql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));


                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnLoadData.setBounds(100, 470, 120, 30);
        btnLoadData.setBackground(Color.BLACK);
        btnLoadData.setForeground(Color.WHITE);
        contentPane.add(btnLoadData);

        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnNewButton.setBounds(290, 470, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        getContentPane().setBackground(Color.WHITE);
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Room frame = new Room();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}