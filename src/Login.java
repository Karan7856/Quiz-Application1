import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    JButton login, back;
    JTextField tfname;
    JPasswordField pfpassword;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        JLabel image = new JLabel(i1);
        setLayout(null);
        image.setBounds(0, 0, 600, 500);
        add(image);

        JLabel heading = new JLabel("QuizBee");
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 45));
        heading.setBounds(790, 60, 300, 45);
        add(heading);

        JLabel name = new JLabel("Username");
        name.setBounds(810, 130, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 22));
        add(name);

        tfname = new JTextField();
        tfname.setBounds(735, 160, 300, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);

        JLabel pass = new JLabel("Password");
        pass.setBounds(810, 200, 300, 20);
        pass.setFont(new Font("Mongolian Baiti", Font.BOLD, 22));
        add(pass);

        pfpassword = new JPasswordField();
        pfpassword.setBounds(735, 230, 300, 25);
        pfpassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(pfpassword);

        login = new JButton("Login");
        login.setBounds(735, 290, 120, 40);
        login.setFont(new Font("Tahoma", Font.BOLD, 18));
        login.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        login.setForeground(Color.BLACK);
        login.setOpaque(false);
        login.setContentAreaFilled(false);
        login.setFocusPainted(false);
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                login.setContentAreaFilled(true);
                login.setBackground(new Color(255, 255, 255, 220));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                login.setContentAreaFilled(false);
            }
        });
        add(login);

        back = new JButton("Back");
        back.setBounds(915, 290, 120, 40);
        back.setFont(new Font("Tahoma", Font.BOLD, 18));
        back.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        back.setForeground(Color.BLACK);
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setFocusPainted(false);
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                back.setContentAreaFilled(true);
                back.setBackground(new Color(255, 255, 255, 220));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                back.setContentAreaFilled(false);
            }
        });
        add(back);

        login.addActionListener(this);
        back.addActionListener(this);

        setSize(1200, 500);
        setLocation(140, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String name = tfname.getText();
            String password = String.valueOf(pfpassword.getPassword());

            if (name.equals("Karan") && password.equals("1234")||name.equals("Puneet")&&password.equals("1234")||name.equals("Nikhil")&&password.equals("1234")) {
                setVisible(false);
                new Rules(name);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }


        } else if (ae.getSource() == back) {
            setVisible(false);  // close current frame
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
