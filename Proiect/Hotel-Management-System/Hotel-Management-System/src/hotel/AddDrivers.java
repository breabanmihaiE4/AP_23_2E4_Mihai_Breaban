package hotel;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddDrivers extends JFrame implements ActionListener {
    private JTextField textName, textPhoneNumber, textCarCompany, textCarBrand, textLocation;
    private JComboBox comboBox, comboBox_1;
    JButton buttonAdd, buttonBack;

    public static void main(String[] args) {
        new AddDrivers().setVisible(true);
    }


    public AddDrivers() {
        setBounds(450, 200, 1000, 500);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/driver.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(400, 30, 500, 370);
        add(l15);

        JLabel labelTitle = new JLabel("Add Drivers");
        labelTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
        labelTitle.setBounds(194, 10, 120, 22);
        contentPane.add(labelTitle);


        JLabel labelName = new JLabel("Name");
        labelName.setForeground(new Color(25, 25, 112));
        labelName.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelName.setBounds(64, 70, 102, 22);
        contentPane.add(labelName);

        textName = new JTextField();
        textName.setBounds(174, 70, 156, 20);
        contentPane.add(textName);


        JLabel labelPhoneNumber = new JLabel("Phone Number");
        labelPhoneNumber.setForeground(new Color(25, 25, 112));
        labelPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelPhoneNumber.setBounds(64, 110, 102, 22);
        contentPane.add(labelPhoneNumber);

        textPhoneNumber = new JTextField();
        textPhoneNumber.setBounds(174, 110, 156, 20);
        contentPane.add(textPhoneNumber);


        JLabel labelGender = new JLabel("Gender");
        labelGender.setForeground(new Color(25, 25, 112));
        labelGender.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelGender.setBounds(64, 150, 102, 22);
        contentPane.add(labelGender);

        comboBox = new JComboBox(new String[]{"Male", "Female"});
        comboBox.setBounds(176, 150, 154, 20);
        contentPane.add(comboBox);


        JLabel labelCarCompany = new JLabel("Car Company");
        labelCarCompany.setForeground(new Color(25, 25, 112));
        labelCarCompany.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelCarCompany.setBounds(64, 190, 102, 22);
        contentPane.add(labelCarCompany);

        textCarCompany = new JTextField();
        textCarCompany.setBounds(174, 190, 156, 20);
        contentPane.add(textCarCompany);


        JLabel labelCarBrand = new JLabel("Car Brand");
        labelCarBrand.setForeground(new Color(25, 25, 112));
        labelCarBrand.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelCarBrand.setBounds(64, 230, 102, 22);
        contentPane.add(labelCarBrand);

        textCarBrand = new JTextField();
        textCarBrand.setBounds(174, 230, 156, 20);
        contentPane.add(textCarBrand);


        JLabel labelAvailable = new JLabel("Available");
        labelAvailable.setForeground(new Color(25, 25, 112));
        labelAvailable.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelAvailable.setBounds(64, 270, 102, 22);
        contentPane.add(labelAvailable);

        comboBox_1 = new JComboBox(new String[]{"Yes", "No"});
        comboBox_1.setBounds(176, 270, 154, 20);
        contentPane.add(comboBox_1);


        JLabel labelLocation = new JLabel("Location");
        labelLocation.setForeground(new Color(25, 25, 112));
        labelLocation.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelLocation.setBounds(64, 310, 102, 22);
        contentPane.add(labelLocation);


        textLocation = new JTextField();
        textLocation.setBounds(174, 310, 156, 20);
        contentPane.add(textLocation);


        buttonAdd = new JButton("Add");
        buttonAdd.addActionListener(this);
        buttonAdd.setBounds(64, 380, 111, 33);
        buttonAdd.setBackground(Color.BLACK);
        buttonAdd.setForeground(Color.WHITE);
        contentPane.add(buttonAdd);

        buttonBack = new JButton("Back");
        buttonBack.addActionListener(this);
        buttonBack.setBounds(198, 380, 111, 33);
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
                    String name = textName.getText();
                    String phone = textPhoneNumber.getText();
                    String gender = (String) comboBox.getSelectedItem();
                    String company = textCarCompany.getText();
                    String brand = textCarBrand.getText();
                    String available = (String) comboBox_1.getSelectedItem();
                    String location = textLocation.getText();
                    String str = "INSERT INTO driver values( '" + name + "', '" + phone + "', '" + gender + "','" + company + "', '" + brand + "', '" + available + "','" + location + "')";


                    c.statemant.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Driver Successfully Added");
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
