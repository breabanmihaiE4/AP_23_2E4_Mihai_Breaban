package hotel;


import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerInfo extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerInfo frame = new CustomerInfo();
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

    public CustomerInfo() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 200, 900, 600);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel labelID = new JLabel("ID");
        labelID.setBounds(50, 11, 46, 14);
        contentPane.add(labelID);

        JLabel labelNumber = new JLabel("Number");
        labelNumber.setBounds(160, 11, 46, 14);
        contentPane.add(labelNumber);

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(280, 11, 65, 14);
        contentPane.add(labelName);

        JLabel labelGender = new JLabel("Gender");
        labelGender.setBounds(410, 11, 46, 14);
        contentPane.add(labelGender);

        JLabel labelRoom = new JLabel("Room");
        labelRoom.setBounds(560, 11, 46, 14);
        contentPane.add(labelRoom);

        JLabel labelCheckIn = new JLabel("Check-in Status");
        labelCheckIn.setBounds(660, 11, 100, 14);
        contentPane.add(labelCheckIn);

        JLabel labelDeposit = new JLabel("Deposit");
        labelDeposit.setBounds(800, 11, 100, 14);
        contentPane.add(labelDeposit);

        JTable table = new JTable();
        table.setBounds(0, 40, 900, 450);
        contentPane.add(table);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(450, 510, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        JButton btnLoadData = new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    conn c = new conn();

                    String displayCustomersql = "select * from Customer";
                    ResultSet rs = c.statemant.executeQuery(displayCustomersql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        btnLoadData.setBounds(300, 510, 120, 30);
        btnLoadData.setBackground(Color.BLACK);
        btnLoadData.setForeground(Color.WHITE);
        contentPane.add(btnLoadData);

        getContentPane().setBackground(Color.WHITE);
    }
}