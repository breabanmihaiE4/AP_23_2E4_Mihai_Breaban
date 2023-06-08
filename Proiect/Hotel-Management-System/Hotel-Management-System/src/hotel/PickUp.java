package hotel;


import java.awt.*;

import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PickUp extends JFrame {
    ResultSet rs = null;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PickUp frame = new PickUp();
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

    public PickUp() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 200, 800, 600);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel labelTitle = new JLabel("Pick Up Service");
        labelTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelTitle.setBounds(90, 11, 158, 25);
        contentPane.add(labelTitle);

        JLabel labelCarType = new JLabel("Type of Car");
        labelCarType.setBounds(32, 97, 89, 14);
        contentPane.add(labelCarType);


        Choice choiceCarType = new Choice();
        try {
            conn c = new conn();
            ResultSet rs = c.statemant.executeQuery("select * from driver");
            while (rs.next()) {
                choiceCarType.add(rs.getString("brand"));
            }
        } catch (Exception e) {
        }
        choiceCarType.setBounds(123, 94, 150, 25);
        contentPane.add(choiceCarType);

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(24, 208, 46, 14);
        contentPane.add(labelName);

        JLabel labelPhone = new JLabel("Phone");
        labelPhone.setBounds(145, 208, 46, 14);
        contentPane.add(labelPhone);

        JLabel labelGender = new JLabel("Gender");
        labelGender.setBounds(264, 208, 46, 14);
        contentPane.add(labelGender);

        JLabel labelCompany = new JLabel("Company");
        labelCompany.setBounds(366, 208, 80, 14);
        contentPane.add(labelCompany);

        JLabel labelBrand = new JLabel("Brand");
        labelBrand.setBounds(486, 208, 105, 14);
        contentPane.add(labelBrand);

        JLabel labelHotel = new JLabel("Available");
        labelHotel.setBounds(600, 208, 86, 14);
        contentPane.add(labelHotel);

        JLabel labelLocation = new JLabel("Location");
        labelLocation.setBounds(700, 208, 73, 14);
        contentPane.add(labelLocation);

        JTable table = new JTable();
        table.setBounds(0, 233, 800, 250);
        contentPane.add(table);

        JButton buttonDisplay = new JButton("Display");
        buttonDisplay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String SQL = "select * from driver where brand = '" + choiceCarType.getSelectedItem() + "'";
                try {

                    conn c = new conn();
                    rs = c.statemant.executeQuery(SQL);
                    table.setModel(DbUtils.resultSetToTableModel(rs));


                } catch (SQLException ss) {
                    ss.printStackTrace();
                }


            }
        });
        buttonDisplay.setBounds(200, 500, 120, 30);
        buttonDisplay.setBackground(Color.BLACK);
        buttonDisplay.setForeground(Color.WHITE);
        contentPane.add(buttonDisplay);

        JButton buttonBack = new JButton("Back");
        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        buttonBack.setBounds(420, 500, 120, 30);
        buttonBack.setBackground(Color.BLACK);
        buttonBack.setForeground(Color.WHITE);
        contentPane.add(buttonBack);



        getContentPane().setBackground(Color.WHITE);
    }
}