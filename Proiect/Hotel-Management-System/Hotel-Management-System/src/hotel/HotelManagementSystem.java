package hotel;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

    JLabel labelStart;
    JButton buttonNext;

    public HotelManagementSystem() {

        setSize(1366, 430);
        setLayout(null);
        setLocation(300, 300);

        labelStart = new JLabel("");
        buttonNext = new JButton("Next");

        buttonNext.setBackground(Color.WHITE);
        buttonNext.setForeground(Color.BLACK);

        JLabel labelTitle = new JLabel("HOTEL MANAGEMENT SYSTEM");
        labelTitle.setBounds(30, 300, 1500, 100);
        labelTitle.setFont(new Font("serif", Font.PLAIN, 70));
        labelTitle.setForeground(Color.red);
        labelStart.add(labelTitle);

        buttonNext.setBounds(1170, 325, 150, 50);
        labelStart.setBounds(0, 0, 1366, 390);

        labelStart.add(buttonNext);
        add(labelStart);

        buttonNext.addActionListener(this);
        setVisible(true);

        while (true) {
            labelTitle.setVisible(false); // lid =  j label
            try {
                Thread.sleep(500); //1000 = 1 second
            } catch (Exception e) {
            }
            labelTitle.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }

    public void actionPerformed(ActionEvent ae) {
        new Login().setVisible(true);
        this.setVisible(false);

    }

    public static void main(String[] args) {
        HotelManagementSystem window = new HotelManagementSystem();
        window.setVisible(true);
    }
}
