package hotel;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateRoom extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UpdateRoom frame = new UpdateRoom();
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
    public UpdateRoom() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 200, 1000, 450);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/updateRoom.jpg"));
        Image i3 = i1.getImage().getScaledInstance(550, 250, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(400, 80, 600, 250);
        add(l1);

        JLabel labelTitle = new JLabel("Update Room Status");
        labelTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelTitle.setBounds(85, 11, 206, 34);
        contentPane.add(labelTitle);

        JLabel labelGuestID = new JLabel("Guest ID:");
        labelGuestID.setBounds(27, 87, 90, 14);
        contentPane.add(labelGuestID);

        Choice choiceID = new Choice();
        try {
            conn c = new conn();
            ResultSet rs = c.statemant.executeQuery("select * from customer");
            while (rs.next()) {
                choiceID.add(rs.getString("number"));
            }
        } catch (Exception e) {
        }
        choiceID.setBounds(160, 84, 140, 20);
        contentPane.add(choiceID);

        JLabel lblRoomId = new JLabel("Room Number:");
        lblRoomId.setBounds(27, 133, 100, 14);
        contentPane.add(lblRoomId);

        JTextField textRoomNum = new JTextField();
        textRoomNum.setBounds(160, 130, 140, 20);
        contentPane.add(textRoomNum);
        textRoomNum.setColumns(10);

        JLabel labelAvailability = new JLabel("Availability:");
        labelAvailability.setBounds(27, 187, 90, 14);
        contentPane.add(labelAvailability);

        JTextField textAvailability = new JTextField();
        textAvailability.setBounds(160, 184, 140, 20);
        contentPane.add(textAvailability);
        textAvailability.setColumns(10);

        JLabel labelCleanStatus = new JLabel("Clean Status:");
        labelCleanStatus.setBounds(27, 240, 90, 14);
        contentPane.add(labelCleanStatus);

        JTextField textCleanStatus = new JTextField();
        textCleanStatus.setBounds(160, 237, 140, 20);
        contentPane.add(textCleanStatus);
        textCleanStatus.setColumns(10);

        JButton buttonCheck = new JButton("Check");
        buttonCheck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String s1 = choiceID.getSelectedItem();
                    conn c = new conn();
                    ResultSet rs1 = c.statemant.executeQuery("select * from customer where number = " + s1);

                    while (rs1.next()) {
                        textRoomNum.setText(rs1.getString("room_number"));
                    }
                } catch (Exception ee) {
                }

                try {
                    conn c = new conn();
                    ResultSet rs2 = c.statemant.executeQuery("select * from room where room_number = " + textRoomNum.getText());
                    while (rs2.next()) {
                        textAvailability.setText(rs2.getString("availability"));
                        textCleanStatus.setText(rs2.getString("clean_status"));
                    }
                } catch (Exception ee) {
                }
            }
        });
        buttonCheck.setBounds(120, 315, 89, 23);
        buttonCheck.setBackground(Color.BLACK);
        buttonCheck.setForeground(Color.WHITE);
        contentPane.add(buttonCheck);

        JButton buttonUpdate = new JButton("Update");
        buttonUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) throws NumberFormatException {

                try {
                    conn c = new conn();
                    String str = "update room set clean_status = '" + textCleanStatus.getText() + "' where room_number = " + textRoomNum.getText();
                    c.statemant.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Update Sucessful");

                    new Reception().setVisible(true);
                    setVisible(false);
                } catch (Exception ee) {
                    ee.printStackTrace();
                }


            }
        });
        buttonUpdate.setBounds(60, 355, 89, 23);
        buttonUpdate.setBackground(Color.BLACK);
        buttonUpdate.setForeground(Color.WHITE);
        contentPane.add(buttonUpdate);

        JButton buttonExit = new JButton("Back");
        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        buttonExit.setBounds(180, 355, 89, 23);
        buttonExit.setBackground(Color.BLACK);
        buttonExit.setForeground(Color.WHITE);
        contentPane.add(buttonExit);


        getContentPane().setBackground(Color.WHITE);
    }

}