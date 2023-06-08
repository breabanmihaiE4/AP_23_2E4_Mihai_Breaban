package hotel;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchRoom extends JFrame {
    ResultSet rs = null;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchRoom frame = new SearchRoom();
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


    public SearchRoom() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 200, 700, 500);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel labelTitle = new JLabel("Search For Room");
        labelTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelTitle.setBounds(250, 11, 186, 31);
        contentPane.add(labelTitle);

        JLabel labelRoomBedType = new JLabel("Room Bed Type:");
        labelRoomBedType.setBounds(50, 73, 96, 14);
        contentPane.add(labelRoomBedType);

        Choice choiceRoomBedType = new Choice();
        choiceRoomBedType.add("Single Bed");
        choiceRoomBedType.add("Double Bed");
        choiceRoomBedType.setBounds(153, 70, 120, 20);
        contentPane.add(choiceRoomBedType);

        JLabel labelRoomNumber = new JLabel("Room Number");
        labelRoomNumber.setBounds(23, 162, 96, 14);
        contentPane.add(labelRoomNumber);

        JLabel labelAvailability = new JLabel("Availability");
        labelAvailability.setBounds(175, 162, 120, 14);
        contentPane.add(labelAvailability);

        JLabel labelPrice = new JLabel("Price");
        labelPrice.setBounds(458, 162, 46, 14);
        contentPane.add(labelPrice);

        JLabel labelBedType = new JLabel("Bed Type");
        labelBedType.setBounds(580, 162, 96, 14);
        contentPane.add(labelBedType);
        
        JLabel labelCleanStatus = new JLabel("Clean Status");
        labelCleanStatus.setBounds(306, 162, 96, 14);
        contentPane.add(labelCleanStatus);

        JCheckBox checkRoom = new JCheckBox("Only display Available");
        checkRoom.setBounds(400, 69, 205, 23);
        checkRoom.setBackground(Color.WHITE);
        contentPane.add(checkRoom);

        JTable table = new JTable();
        table.setBounds(0, 187, 700, 300);
        contentPane.add(table);

        JButton buttonSearch = new JButton("Search");
        buttonSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String SQL1 = "select * from Room where bed_type = '" + choiceRoomBedType.getSelectedItem() + "'";
                String SQL2 = "select * from Room where availability = 'Available' AND bed_type = '" + choiceRoomBedType.getSelectedItem() + "'";
                try {
                    conn c = new conn();
                    rs = c.statemant.executeQuery(SQL1);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                    if (checkRoom.isSelected()) {
                        rs = c.statemant.executeQuery(SQL2);
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }


                } catch (SQLException ss) {
                    ss.printStackTrace();
                }

            }
        });
        buttonSearch.setBounds(200, 400, 120, 30);
        buttonSearch.setBackground(Color.BLACK);
        buttonSearch.setForeground(Color.WHITE);
        contentPane.add(buttonSearch);

        JButton buttonBack = new JButton("Back");
        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        buttonBack.setBounds(380, 400, 120, 30);
        buttonBack.setBackground(Color.BLACK);
        buttonBack.setForeground(Color.WHITE);
        contentPane.add(buttonBack);

        getContentPane().setBackground(Color.WHITE);
    }
}