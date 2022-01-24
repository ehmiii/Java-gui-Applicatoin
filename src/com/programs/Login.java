package com.programs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class Login {
    Login(){
        Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
        JFrame login_frame=new JFrame("Ahmad Khan");
        Image logo= Toolkit.getDefaultToolkit().getImage("/home/anonymous/Study Material/JAVA/JAVAProject/src/expenses.png");
        // Making title label
        JLabel title_label=new JLabel("Expenses Tracker",SwingConstants.CENTER);
        title_label.setBounds(0,0,463,70);
        title_label.setFont(new Font("Sofia", Font.BOLD, 32));
        // creating error dialog box


        // Enter your name Label
        JTextField username=new JTextField();
        username.setBounds(122,85,219,36);
        username.setBackground(Color.cyan);
        username.setFont(new Font("Luxurious Roman",Font.PLAIN,16));
        username.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        username.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(username.getText().equals("Enter your name")) {
                    username.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(username.getText().equals("")) {
                    username.setText("Enter your name");
                    username.setForeground(Color.gray);
                }
            }
        });

        // Creating password field
        JPasswordField password =new JPasswordField("Enter your password");
        password.setBounds(122,136,219,36);
        password.setFont(new Font("Luxurious Roman",Font.PLAIN,16));
        password.setBackground(Color.cyan);
        password.setForeground(Color.gray);
        password.setEchoChar((char) 0);
        password.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        password.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                String str=String.valueOf(password.getPassword());
                String str1="Enter your password";
                if(str.equals(str1)) {
                    password.setText("");
                    password.setEchoChar('*');
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                String str=String.valueOf(password.getPassword());
                if(str.equals("")) {
                    password.setText("Enter your password");
                    password.setForeground(Color.gray);
                    password.setEchoChar((char)0);
                }
            }
        });

        //Creating login button
        JButton login_button=new JButton("Login");
        login_button.setBounds(122,187,106,35);
        login_button.setFont(new Font("Sofia", Font.BOLD, 16));
        login_button.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        //Creating action listener on login button
        login_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String string=username.getText();
                final String string1=String.valueOf(password.getPassword());
                if(string.equals("ahmad") && string1.equals("ahmad")) {
                    new Entries_Table();
                    login_frame.dispose();
                }
                else if(!string.equals("ahmad") && (!string1.equals("ahmad"))){
                    JOptionPane.showMessageDialog(null,"Wrong user name and Password","Error occur",1);
                }
                else if(string.equals("ahmad") && (!string1.equals("ahmad"))){
                    JOptionPane.showMessageDialog(null,"Wrong Password","Error occur",1);
                }
                else if(!string.equals("ahmad") && (string1.equals("ahmad"))){
                    JOptionPane.showMessageDialog(null,"Wrong user name","Error occur",1);
                }
            }
        });

///////////////////////////////////////////////////////////////////////////////////////////////
        // Creating signup_button
        JButton signup_button=new JButton("Signup");
        signup_button.setBounds(235,187,106,35);
        signup_button.setFont(new Font("Sofia", Font.BOLD, 16));
        signup_button.setBorder(BorderFactory.createLineBorder(Color.BLUE));

//////////////////////////////////////////////////////////////////////////////////////////////////////////


//////////////////////////////////////////////////////////////////////////////////////////////////////////////

        login_frame.add(signup_button);
        login_frame.add(login_button);
        login_frame.add(username);
        login_frame.add(password);
        login_frame.add(title_label);
//        login_frame.add(background);
        login_frame.setIconImage(logo);
        login_frame.setSize(463,307);
        login_frame.setLocation(dimension.width/2-login_frame.getSize().width/2, dimension.height/2-login_frame.getSize().height/2);
        login_frame.setResizable(false);
        login_frame.setLayout(null);
        login_frame.setVisible(true);
        login_frame.getContentPane().setBackground(new Color(175,231,234,255));
        login_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
