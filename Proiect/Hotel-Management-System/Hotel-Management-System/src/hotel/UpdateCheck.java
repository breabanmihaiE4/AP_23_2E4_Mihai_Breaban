package hotel;

import java.awt.*;

import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateCheck extends JFrame {
    private JPanel contentPane;
    private JTextField txt_Payment;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UpdateCheck frame = new UpdateCheck();
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

    public UpdateCheck() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 950, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel labelTitle = new JLabel("Check-In Details");
        labelTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelTitle.setBounds(124, 11, 222, 25);
        contentPane.add(labelTitle);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/checkin-checkout.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(450, 70, 476, 270);
        add(l1);

        JLabel labelID = new JLabel("ID:");
        labelID.setBounds(25, 88, 46, 14);
        contentPane.add(labelID);

        Choice choiceID = new Choice();
        try {
            conn c = new conn();
            ResultSet rs = c.statemant.executeQuery("select * from customer");
            while (rs.next()) {
                choiceID.add(rs.getString("number"));
            }
        } catch (Exception e) {
        }

        choiceID.setBounds(248, 85, 140, 20);
        contentPane.add(choiceID);

        JLabel labelRoomNumber = new JLabel("Room Number :");
        labelRoomNumber.setBounds(25, 129, 107, 14);
        contentPane.add(labelRoomNumber);

        JTextField textRoomNumber = new JTextField();
        textRoomNumber.setBounds(248, 129, 140, 20);
        contentPane.add(textRoomNumber);

        JLabel labelName = new JLabel("Name : ");
        labelName.setBounds(25, 174, 97, 14);
        contentPane.add(labelName);

        JTextField textName = new JTextField();
        textName.setBounds(248, 174, 140, 20);
        contentPane.add(textName);
        textName.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Checked-in :");
        lblNewLabel_3.setBounds(25, 216, 107, 14);
        contentPane.add(lblNewLabel_3);

        JTextField textCheckIn = new JTextField();
        textCheckIn.setBounds(248, 216, 140, 20);
        contentPane.add(textCheckIn);
        textCheckIn.setColumns(10);

        JLabel labelPaid = new JLabel("Amount Paid : ");
        labelPaid.setBounds(25, 261, 107, 14);
        contentPane.add(labelPaid);

        JTextField textPaid = new JTextField();
        textPaid.setBounds(248, 261, 140, 20);
        contentPane.add(textPaid);
        textPaid.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("Pending Amount : ");
        lblNewLabel_5.setBounds(25, 302, 150, 14);
        contentPane.add(lblNewLabel_5);

        txt_Payment = new JTextField();
        txt_Payment.setBounds(248, 302, 140, 20);
        contentPane.add(txt_Payment);
        txt_Payment.setColumns(10);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    conn c = new conn();

                    String s1 = choiceID.getSelectedItem();
                    String s2 = textRoomNumber.getText();
                    String s3 = textName.getText();
                    String s4 = textCheckIn.getText();
                    String s5 = textPaid.getText();

                    c.statemant.executeUpdate("update customer set room_number = '" + s2 + "', name = '" + s3 + "', status = '" + s4 + "', deposit = '" + s5 + "' where number = '" + s1 + "'");

                    JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                    new Reception().setVisible(true);
                    setVisible(false);
                } catch (Exception ee) {
                    System.out.println(ee);
                }


            }
        });
        btnUpdate.setBounds(168, 378, 89, 23);
        btnUpdate.setBackground(Color.BLACK);
        btnUpdate.setForeground(Color.WHITE);
        contentPane.add(btnUpdate);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(281, 378, 89, 23);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        JButton btnAdd = new JButton("Check");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String s1 = choiceID.getSelectedItem();
                    conn c = new conn();
                    ResultSet rs1 = c.statemant.executeQuery("select * from customer where number = " + s1);

                    while (rs1.next()) {
                        textRoomNumber.setText(rs1.getString("room_number"));
                        textName.setText(rs1.getString("name"));
                        textCheckIn.setText(rs1.getString("status"));
                        textPaid.setText(rs1.getString("deposit"));
                    }
                } catch (Exception ee) {
                }

                try {
                    String total = "";
                    conn c = new conn();
                    ResultSet rs2 = c.statemant.executeQuery("select * from room where room_number = " + textRoomNumber.getText());
                    while (rs2.next()) {
                        total = rs2.getString("price");

                    }
                    String paid = textPaid.getText();
                    int pending = Integer.parseInt(total) - Integer.parseInt(paid);

                    txt_Payment.setText(Integer.toString(pending));

                } catch (Exception ee) {
                }
            }
        });
        btnAdd.setBounds(56, 378, 89, 23);
        btnAdd.setBackground(Color.BLACK);
        btnAdd.setForeground(Color.WHITE);
        contentPane.add(btnAdd);

        getContentPane().setBackground(Color.WHITE);
    }

}