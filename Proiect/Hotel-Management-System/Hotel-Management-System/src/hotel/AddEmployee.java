package hotel;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddEmployee extends JFrame {


    JTextField taxtName, textAge, textSalary, textPhone, textIDNumber, textEmail;
    JComboBox courseJob;

    public AddEmployee() {
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD EMPLOYEE DETAILS");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778, 486);
        getContentPane().setLayout(null);

        JLabel labelName = new JLabel("NAME");
        labelName.setFont(new Font("Tahoma", Font.PLAIN, 17));
        labelName.setBounds(60, 30, 150, 27);
        add(labelName);

        taxtName = new JTextField();
        taxtName.setBounds(200, 30, 150, 27);
        add(taxtName);

        JLabel labelAge = new JLabel("AGE");
        labelAge.setFont(new Font("Tahoma", Font.PLAIN, 17));
        labelAge.setBounds(60, 80, 150, 27);
        add(labelAge);

        textAge = new JTextField();
        textAge.setBounds(200, 80, 150, 27);
        add(textAge);

        JLabel labelGender = new JLabel("GENDER");
        labelGender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        labelGender.setBounds(60, 120, 150, 27);
        add(labelGender);

        JRadioButton radioMale = new JRadioButton("MALE");
        radioMale.setBackground(Color.WHITE);
        radioMale.setBounds(200, 120, 70, 27);
        add(radioMale);

        JRadioButton radioFemale = new JRadioButton("FEMALE");
        radioFemale.setBackground(Color.WHITE);
        radioFemale.setBounds(280, 120, 70, 27);
        add(radioFemale);


        JLabel labelJob = new JLabel("JOB");
        labelJob.setFont(new Font("Tahoma", Font.PLAIN, 17));
        labelJob.setBounds(60, 170, 150, 27);
        add(labelJob);

        String course[] = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Waiter/Waitress", "Manager", "Accountant", "Chef"};
        courseJob = new JComboBox(course);
        courseJob.setBackground(Color.WHITE);
        courseJob.setBounds(200, 170, 150, 30);
        add(courseJob);

        JLabel labelSalary = new JLabel("SALARY");
        labelSalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        labelSalary.setBounds(60, 220, 150, 27);
        add(labelSalary);

        textSalary = new JTextField();
        textSalary.setBounds(200, 220, 150, 27);
        add(textSalary);

        JLabel labelPhone = new JLabel("PHONE");
        labelPhone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        labelPhone.setBounds(60, 270, 150, 27);
        add(labelPhone);

        textPhone = new JTextField();
        textPhone.setBounds(200, 270, 150, 27);
        add(textPhone);

        JLabel labelIDNumber = new JLabel("IDNumber");
        labelIDNumber.setFont(new Font("Tahoma", Font.PLAIN, 17));
        labelIDNumber.setBounds(60, 320, 150, 27);
        add(labelIDNumber);

        textIDNumber = new JTextField();
        textIDNumber.setBounds(200, 320, 150, 27);
        add(textIDNumber);


        JLabel labelEmail = new JLabel("EMAIL");
        labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        labelEmail.setBounds(60, 370, 150, 27);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setBounds(200, 370, 150, 27);
        add(textEmail);
        setVisible(true);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/addEmployee.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(410, 80, 480, 410);
        add(image);

        JButton Save = new JButton("SAVE");
        Save.setBounds(200, 420, 150, 30);
        Save.setBackground(Color.BLACK);
        Save.setForeground(Color.WHITE);
        add(Save);

        Save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String name = taxtName.getText();
                String age = textAge.getText();
                String salary = textSalary.getText();
                String phone = textPhone.getText();
                String idNo = textIDNumber.getText();
                String email = textEmail.getText();

                String gender = null;

                if (radioMale.isSelected()) {
                    gender = "male";

                } else if (radioFemale.isSelected()) {
                    gender = "female";
                }

                String jobs = (String) courseJob.getSelectedItem();

                try {
                    conn c = new conn();
                    String str = "INSERT INTO employee values( '" + name + "', '" + age + "', '" + gender + "','" + jobs + "', '" + salary + "', '" + phone + "','" + idNo + "', '" + email + "')";

                    c.statemant.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Employee Added");
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        setSize(900, 600);
        setVisible(true);
        setLocation(530, 200);

    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}