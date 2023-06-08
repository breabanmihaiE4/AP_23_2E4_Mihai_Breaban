package hotel;

import java.awt.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewCustomer extends JFrame {
    private JPanel contentPane;
    private JTextField textIDNumber, textName, textCheckInStatus, textDeposit;
    JComboBox comboBoxID;
    JRadioButton radioMale, radioFemale;
    Choice choiceAllocatedRoomNumber;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NewCustomer frame = new NewCustomer();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public NewCustomer() throws SQLException {

        setBounds(530, 200, 850, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newCustomer.png"));
        Image i3 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(480, 10, 300, 500);
        add(l1);

        JLabel labelTitle = new JLabel("NEW CUSTOMER FORM");
        labelTitle.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        labelTitle.setBounds(118, 11, 260, 53);
        contentPane.add(labelTitle);

        JLabel labelID = new JLabel("ID :");
        labelID.setBounds(35, 76, 200, 14);
        contentPane.add(labelID);

        comboBoxID = new JComboBox(new String[]{"Passport", "IdNumber"});
        comboBoxID.setBounds(271, 73, 150, 20);
        contentPane.add(comboBoxID);

        JLabel labelIDNumber = new JLabel("IdNumber :");
        labelIDNumber.setBounds(35, 111, 200, 14);
        contentPane.add(labelIDNumber);

        textIDNumber = new JTextField();
        textIDNumber.setBounds(271, 111, 150, 20);
        contentPane.add(textIDNumber);
        textIDNumber.setColumns(10);

        JLabel labelName = new JLabel("Name :");
        labelName.setBounds(35, 151, 200, 14);
        contentPane.add(labelName);

        textName = new JTextField();
        textName.setBounds(271, 151, 150, 20);
        contentPane.add(textName);
        textName.setColumns(10);


        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(35, 191, 200, 14);
        contentPane.add(labelGender);

        radioMale = new JRadioButton("Male");
        radioMale.setFont(new Font("Raleway", Font.BOLD, 14));
        radioMale.setBackground(Color.WHITE);
        radioMale.setBounds(271, 191, 80, 12);
        add(radioMale);

        radioFemale = new JRadioButton("Female");
        radioFemale.setFont(new Font("Raleway", Font.BOLD, 14));
        radioFemale.setBackground(Color.WHITE);
        radioFemale.setBounds(350, 191, 100, 12);
        add(radioFemale);


        JLabel labelAllocatedRoomNumber = new JLabel("Allocated Room Number :");
        labelAllocatedRoomNumber.setBounds(35, 274, 200, 14);
        contentPane.add(labelAllocatedRoomNumber);

        choiceAllocatedRoomNumber = new Choice();
        try {
            conn c = new conn();
            ResultSet rs = c.statemant.executeQuery("select * from room");
            while (rs.next()) {
                choiceAllocatedRoomNumber.add(rs.getString("room_number"));
            }
        } catch (Exception e) {
        }
        choiceAllocatedRoomNumber.setBounds(271, 274, 150, 20);
        contentPane.add(choiceAllocatedRoomNumber);

        JLabel labelCheckInStatus = new JLabel("Checked-In :");
        labelCheckInStatus.setBounds(35, 316, 200, 14);
        contentPane.add(labelCheckInStatus);

        textCheckInStatus = new JTextField();
        textCheckInStatus.setBounds(271, 316, 150, 20);
        contentPane.add(textCheckInStatus);
        textCheckInStatus.setColumns(10);

        JLabel labelDeposit = new JLabel("Deposit :");
        labelDeposit.setBounds(35, 359, 200, 14);
        contentPane.add(labelDeposit);

        textDeposit = new JTextField();
        textDeposit.setBounds(271, 359, 150, 20);
        contentPane.add(textDeposit);
        textDeposit.setColumns(10);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                String radio = null;

                if (radioMale.isSelected()) {
                    radio = "Male";
                } else if (radioFemale.isSelected()) {
                    radio = "Female";
                }


                try {
                    String s1 = (String) comboBoxID.getSelectedItem();
                    String s2 = textIDNumber.getText();
                    String s3 = textName.getText();
                    String s4 = radio;
                    String s5 = choiceAllocatedRoomNumber.getSelectedItem();
                    String s6 = textCheckInStatus.getText();
                    String s7 = textDeposit.getText();

                    String q1 = "insert into customer values('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "')";
                    String q2 = "update room set availability = 'Occupied' where room_number = " + s5;
                    c.statemant.executeUpdate(q1);
                    c.statemant.executeUpdate(q2);


                    JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                    new Reception().setVisible(true);
                    setVisible(false);
                } catch (SQLException e1) {
                    System.out.println(e1.getMessage());
                } catch (NumberFormatException s) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid Number");
                }
            }
        });
        btnNewButton.setBounds(100, 430, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(260, 430, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);
    }
}