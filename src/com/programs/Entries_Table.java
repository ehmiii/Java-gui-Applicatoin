package com.programs;


import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;


public class Entries_Table {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    double total_Price=0;
    int count=0;
    Entries_Table(){
        final Dimension[] dimension = {Toolkit.getDefaultToolkit().getScreenSize()};
        JFrame entries_Table=new JFrame("Entries Table");
        JTextArea textArea=new JTextArea();
        JTextArea textArea1=new JTextArea();
        JLabel total_Label=new JLabel();
        JTextField income_Field=new JTextField("Enter your income");
        JCheckBox checkBox=new JCheckBox("Do you want to enter income?",false);
        JTextField item_Field=new JTextField("Enter item name");
        JTextField price_field=new JTextField("Enter item price");
        JButton add_button=new JButton("ADD");
        JButton remove_button=new JButton("REMOVE");
        JButton calculate_button=new JButton("CALCULATE");
        JButton logout_button=new JButton("Logout");
///////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////
        // Income Text field
        income_Field.setVisible(false);
        income_Field.setForeground(Color.gray);
        income_Field.setBounds(159,39,227,30);
        income_Field.setBackground(new Color(175,231,234,255));
        income_Field.setFont(new Font("Luxurious Roman",Font.PLAIN,16));
        income_Field.setBackground(Color.cyan);
        income_Field.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        income_Field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(income_Field.getText().equals("Enter your income")) {
                    income_Field.setFont(new Font("Nanum", Font.PLAIN, 16));
                    income_Field.setText("");
                    income_Field.setForeground(Color.black);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(income_Field.getText().equals("")) {
                    income_Field.setForeground(Color.gray);
                    income_Field.setText("Enter your income");
                    income_Field.setFont(new Font("Luxurious Roman",Font.PLAIN,16));
                }
            }
        });

        income_Field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!(e.getKeyChar() >= '0' && e.getKeyChar() <= '9')) {
                    e.consume();
                }
            }
        });

        income_Field.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                income_Field.setBorder(BorderFactory.createLineBorder(Color.RED));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                income_Field.setBorder(BorderFactory.createLineBorder(Color.blue));
            }
        });
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
        // Creating checkBox
        checkBox.setBounds(146,0,253,30);
        checkBox.setBackground(new Color(175,231,234,255));
        checkBox.setFont(new Font("Nanum",Font.PLAIN,15));
        checkBox.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                income_Field.setVisible(e.getStateChange() == ItemEvent.SELECTED);
            }
        });

        checkBox.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                checkBox.setBorder(BorderFactory.createLineBorder(Color.RED));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                checkBox.setBorder(BorderFactory.createLineBorder(Color.blue));
            }
        });

/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
        // Creating Item name field
        item_Field.setForeground(Color.gray);
        item_Field.setBounds(63,78,192,30);
        item_Field.setFont(new Font("Luxurious Roman",Font.PLAIN,15));
        item_Field.setBackground(Color.cyan);
        item_Field.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        item_Field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(item_Field.getText().equals("Enter item name"))
                {
                    item_Field.setText("");
                    item_Field.setForeground(Color.black);
                    item_Field.setFont(new Font("Nanum",Font.PLAIN,15));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (item_Field.getText().equals(""))
                {
                    item_Field.setForeground(Color.gray);
                    item_Field.setText("Enter item name");
                    item_Field.setFont(new Font("Luxurious Roman",Font.PLAIN,15));

                }
            }
        });
        item_Field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9')) {
                    e.consume();
                }
            }
        });

        item_Field.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                item_Field.setBorder(BorderFactory.createLineBorder(Color.RED));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                item_Field.setBorder(BorderFactory.createLineBorder(Color.blue));
            }
        });

//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
        // Creating Item price field
        price_field.setForeground(Color.gray);
        price_field.setBounds(290,78,192,30);
        price_field.setFont(new Font("Luxurious Roman",Font.PLAIN,16));
        price_field.setBackground(Color.cyan);
        price_field.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        price_field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(price_field.getText().equals("Enter item price"))
                {
                    price_field.setText("");
                    price_field.setForeground(Color.black);
                    price_field.setFont(new Font("Nanum",Font.PLAIN,15));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(price_field.getText().equals("")){
                    price_field.setForeground(Color.gray);
                    price_field.setText("Enter item price");
                    price_field.setFont(new Font("Luxurious Roman",Font.PLAIN,15));

                }
            }
        });
        price_field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!(e.getKeyChar() >= '0' && e.getKeyChar() <= '9')) {
                    e.consume();
                }
            }
        });

        price_field.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                price_field.setBorder(BorderFactory.createLineBorder(Color.RED));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                price_field.setBorder(BorderFactory.createLineBorder(Color.blue));
            }
        });

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Creating adding button
        add_button.setBounds(63,117,115,30);
        add_button.setFont(new Font("Sofia", Font.PLAIN, 16));
        add_button.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    count++;
                    if (item_Field.getText().equals("Enter item name")){
                        JOptionPane.showMessageDialog(null,"Please enter your item name","Error",JOptionPane.INFORMATION_MESSAGE);
                }
                    else if (price_field.getText().equals("Enter item price")){
                        JOptionPane.showMessageDialog(null,"Please enter your item price","Error", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    double price = Double.parseDouble(price_field.getText());
                    textArea.setForeground(Color.black);
                    textArea.append(item_Field.getText() + " : \n");
                    textArea1.append(price+"\n");
                    price_field.setText("Enter item price");
                    price_field.setForeground(Color.gray);
                    item_Field.setForeground(Color.gray);
                    item_Field.setText("Enter item name");
                    }
                }catch (Exception ignored){
                    JOptionPane.showMessageDialog(null,"Please enter price in Numbers","Error",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        add_button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                add_button.setBorder(BorderFactory.createLineBorder(Color.RED));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                add_button.setBorder(BorderFactory.createLineBorder(Color.blue));
            }
        });

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Creating remove button
        remove_button.setBounds(215,117,115,30);
        remove_button.setFont(new Font("Sofia", Font.PLAIN, 18));
        remove_button.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        remove_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textArea.getText().equals("") && textArea1.getText().equals("")){
                 JOptionPane.showMessageDialog(null,"Text area clear!!!","Error",JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    try {
                        int getLine = textArea.getLineStartOffset(count-1);
                        int end = textArea.getLineEndOffset(count-1);
                        textArea.replaceRange(null, getLine, end);
                        int getLine1 = textArea1.getLineStartOffset(count-1);
                        int end1 = textArea1.getLineEndOffset(count-1);
                        textArea1.replaceRange(null, getLine1, end1);
                        if(count <0){
                            count=0;
                        }
                        else count--;
                    } catch (BadLocationException badLocationException) {
                        badLocationException.printStackTrace();
                    }
                }
            }
        });

        remove_button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                remove_button.setBorder(BorderFactory.createLineBorder(Color.RED));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                remove_button.setBorder(BorderFactory.createLineBorder(Color.blue));
            }
        });
/////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////
        // Creating calculation button
        calculate_button.setBounds(367,117,115,30);
        calculate_button.setFont(new Font("Sofia", Font.PLAIN, 16));
        calculate_button.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        calculate_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(!textArea.getText().equals("")) {
                        String[] total = textArea1.getText().split("\n");
                        String[] find = textArea.getText().split("\\n");
                        double[] total_price = Arrays.stream(total).mapToDouble(Double::parseDouble).toArray();
                        double sum = 0;

                        for (int i = 0; i <= total_price.length - 1; i++) {
                            if (find[i].equals("Total :")) {
                                continue;
                            } else {
                                sum += total_price[i];
                            }
                            total_Price = sum;
                        }
                        File Total_Income = new File("Income.txt");
                        Scanner income = new Scanner(Total_Income);
                        double total_income = Double.parseDouble(income.nextLine());
                        double left_cash = total_income - sum;
                        total_Label.setText("");
                        total_Label.setText("Expenses: " + sum + "Rs" + "    Left: " + left_cash + "Rs" + "    Total amount: " + total_income);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"There is nothing to calculate please enter some amount","Attention!!!",1);
                    }
                }catch (Exception ignored){

                }
            }
        });

        calculate_button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                calculate_button.setBorder(BorderFactory.createLineBorder(Color.RED));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                calculate_button.setBorder(BorderFactory.createLineBorder(Color.blue));
            }
        });
///////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////
        // Creating text area for adding item temporary
        textArea.setBounds(63,156,209,276);
        textArea1.setBounds(272,156,209,276);
        textArea1.setFont(new Font("Nanum",Font.PLAIN,16));
        textArea.setFont(new Font("Nanum", Font.PLAIN,16));
        textArea.setHighlighter(null);
        textArea1.setHighlighter(null);
        textArea.setEditable( false );
        textArea1.setEditable(false);
        textArea.setForeground(Color.black);
        textArea1.setForeground(Color.black);



//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
        // Creating Label for displaying total price
        total_Label.setBounds(5,434,535,35);
        total_Label.setFont(new Font("Nanum", Font.PLAIN, 16));
        total_Label.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        total_Label.setHorizontalAlignment(SwingConstants.CENTER);
        total_Label.setVerticalAlignment(SwingConstants.CENTER);

///////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////
        // Creating SAVE button
        JButton save_button=new JButton("SAVE");
        save_button.setBounds(63,482,96,36);
        save_button.setFont(new Font("Sofia", Font.PLAIN, 18));
        save_button.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        save_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    BufferedWriter total_Items = new BufferedWriter(
                            new FileWriter("Total_Items.txt", true));

                    BufferedWriter total_Items1 = new BufferedWriter(
                            new FileWriter("Total_Items1.txt", true));

                    File Date_log=new File("DateLogs.txt");
                    FileWriter date_log=new FileWriter("DateLogs.txt");
                    int lines = textArea.getLineCount();
                    for(int i=0; i<lines-1;i++){
                        int start = textArea.getLineStartOffset(i);
                        int start1 = textArea1.getLineStartOffset(i);
                        int end=textArea.getLineEndOffset(i);
                        int end1=textArea1.getLineEndOffset(i);

                        total_Items.write(textArea.getText(start,end-start));
                        total_Items1.write(textArea1.getText(start1,end1-start1));

                        total_Items.flush();
                        total_Items1.flush();
                    }
                    date_log.write("Date: "+ dateFormat.format(date)+"\n");

                    date_log.flush();
                    date_log.close();
                    total_Items1.close();
                    total_Items.close();

                    if(!income_Field.getText().equals("Enter your income")) {
                        File Income = new File("Income.txt");
                        FileWriter income = new FileWriter("Income.txt");

                        income.write(income_Field.getText() + "\n");
                        income.flush();
                        income.close();
                    }
                }catch (Exception ignored){
                }
            }
        });

        save_button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                save_button.setBorder(BorderFactory.createLineBorder(Color.RED));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                save_button.setBorder(BorderFactory.createLineBorder(Color.blue));
            }
        });

///////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////
        // Creating Check history Button
        JButton check_history_button=new JButton("Check");
        check_history_button.setBounds(224,482,96,36);
        check_history_button.setFont(new Font("Sofia", Font.PLAIN, 18));
        check_history_button.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        check_history_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new History();
                } catch (IOException ignored) {
                }
                entries_Table.dispose();
            }
        });

        check_history_button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                check_history_button.setBorder(BorderFactory.createLineBorder(Color.RED));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                check_history_button.setBorder(BorderFactory.createLineBorder(Color.blue));
            }
        });

///////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////
        // Creating Logout Button

        logout_button.setBounds(386,482,96,36);
        logout_button.setFont(new Font("Sofia", Font.PLAIN, 18));
        logout_button.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        logout_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
                entries_Table.dispose();
            }
        });

        logout_button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                logout_button.setBorder(BorderFactory.createLineBorder(Color.RED));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                logout_button.setBorder(BorderFactory.createLineBorder(Color.blue));
            }
        });
//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
        entries_Table.add(logout_button);
        entries_Table.add(save_button);
        entries_Table.add(check_history_button);
        entries_Table.add(textArea);
        entries_Table.add(textArea1);
        entries_Table.add(total_Label);
        entries_Table.add(remove_button);
        entries_Table.add(add_button);
        entries_Table.add(calculate_button);
        entries_Table.add(price_field);
        entries_Table.add(income_Field);
        entries_Table.add(item_Field);
        entries_Table.add(checkBox);
        entries_Table.setSize(545,568);
        entries_Table.setLocation(dimension[0].width/2-entries_Table.getSize().width/2, dimension[0].height/2-entries_Table.getSize().height/2);
        entries_Table.setResizable(false);
        entries_Table.setLayout(null);
        entries_Table.setVisible(true);
        entries_Table.getContentPane().setBackground(new Color(175,231,234,255));
        entries_Table.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}