package hotel;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddRoom extends JFrame implements ActionListener {
    private JTextField textPrice, textRoomNumber;
    private JComboBox comboBoxAvailability, comboBoxCleaningStatus, comboBoxBedType;
    JButton buttonAdd, buttonBack;


    public static void main(String[] args) {
        new AddRoom().setVisible(true);
    }

    public AddRoom() {
        setBounds(450, 200, 1000, 450);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/addRoom.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(400, 30, 500, 370);
        add(l15);

        JLabel labelTitle = new JLabel("Add Rooms");
        labelTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
        labelTitle.setBounds(194, 10, 120, 22);
        contentPane.add(labelTitle);

        JLabel labelRoomNumber = new JLabel("Room Number");
        labelRoomNumber.setForeground(new Color(25, 25, 112));
        labelRoomNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelRoomNumber.setBounds(64, 70, 102, 22);
        contentPane.add(labelRoomNumber);

        textRoomNumber = new JTextField();
        textRoomNumber.setBounds(174, 70, 156, 20);
        contentPane.add(textRoomNumber);


        JLabel labelAvailability = new JLabel("Availability");
        labelAvailability.setForeground(new Color(25, 25, 112));
        labelAvailability.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelAvailability.setBounds(64, 110, 102, 22);
        contentPane.add(labelAvailability);

        comboBoxAvailability = new JComboBox(new String[]{"Available", "Occupied"});
        comboBoxAvailability.setBounds(176, 110, 154, 20);
        contentPane.add(comboBoxAvailability);


        JLabel labelCleaningStatus = new JLabel("Cleaning Status");
        labelCleaningStatus.setForeground(new Color(25, 25, 112));
        labelCleaningStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelCleaningStatus.setBounds(64, 150, 102, 22);
        contentPane.add(labelCleaningStatus);

        comboBoxCleaningStatus = new JComboBox(new String[]{"Cleaned", "Dirty"});
        comboBoxCleaningStatus.setBounds(176, 150, 154, 20);
        contentPane.add(comboBoxCleaningStatus);


        JLabel labelPrice = new JLabel("Price");
        labelPrice.setForeground(new Color(25, 25, 112));
        labelPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelPrice.setBounds(64, 190, 102, 22);
        contentPane.add(labelPrice);

        textPrice = new JTextField();
        textPrice.setBounds(174, 190, 156, 20);
        contentPane.add(textPrice);


        JLabel labelBedType = new JLabel("Bed Type");
        labelBedType.setForeground(new Color(25, 25, 112));
        labelBedType.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelBedType.setBounds(64, 230, 102, 22);
        contentPane.add(labelBedType);

        comboBoxBedType = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        comboBoxBedType.setBounds(176, 230, 154, 20);
        contentPane.add(comboBoxBedType);


        buttonAdd = new JButton("Add");
        buttonAdd.addActionListener(this);
        buttonAdd.setBounds(64, 321, 111, 33);
        buttonAdd.setBackground(Color.BLACK);
        buttonAdd.setForeground(Color.WHITE);
        contentPane.add(buttonAdd);

        buttonBack = new JButton("Back");
        buttonBack.addActionListener(this);
        buttonBack.setBounds(198, 321, 111, 33);
        buttonBack.setBackground(Color.BLACK);
        buttonBack.setForeground(Color.WHITE);
        contentPane.add(buttonBack);


        contentPane.setBackground(Color.WHITE);

    }

    public void actionPerformed(ActionEvent ae) {
        try {

            if (ae.getSource() == buttonAdd) {
                try {
                    conn c = new conn();
                    String room = textRoomNumber.getText();
                    String available = (String) comboBoxAvailability.getSelectedItem();
                    String status = (String) comboBoxCleaningStatus.getSelectedItem();
                    String price = textPrice.getText();
                    String type = (String) comboBoxBedType.getSelectedItem();
                    String query = "INSERT INTO room values( '" + room + "', '" + available + "', '" + status + "','" + price + "', '" + type + "')";


                    c.statemant.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Room Successfully Added");
                    this.setVisible(false);

                } catch (Exception ee) {
                    System.out.println(ee);
                }
            } else if (ae.getSource() == buttonBack) {
                this.setVisible(false);
            }
        } catch (Exception eee) {

        }
    }
}
