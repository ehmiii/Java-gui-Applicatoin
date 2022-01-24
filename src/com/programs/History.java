package com.programs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class History {
    History() throws IOException {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame history_frame = new JFrame("History");
/////////////////////////////////////////////////////////////////////////////////
        // Creating income label
        JLabel calculate_label=new JLabel("Click on calculate button");
        JLabel income_label=new JLabel();
        income_label.setBounds(145,5,366,33);
        income_label.setFont(new Font("Nanum", Font.BOLD, 16));
//        income_label.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        income_label.setBorder(null);
        income_label.setHorizontalAlignment(SwingConstants.CENTER);
        income_label.setVerticalAlignment(SwingConstants.CENTER);
        try{
        File Income=new File("Income.txt");
            Scanner income=new Scanner(Income);
            income_label.setText("Total Amount: "+income.nextLine());
            income.close();

        }catch (Exception ignored){

        }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Income clear button
        JButton income_clear=new JButton("CLEAR INCOME");
        income_clear.setBounds(518,5,135,32);
        income_clear.setFont(new Font("Sofia", Font.PLAIN, 14));
//        income_clear.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        income_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = JOptionPane.showConfirmDialog(history_frame,"Do you want to clear Income?","Conformation",JOptionPane.YES_NO_CANCEL_OPTION);
               if(JOptionPane.YES_OPTION==x){
                try (FileWriter income = new FileWriter("Income.txt")) {
                    income.write("");
                    income.flush();
                    income.close();
                    income_label.setText("");
                }catch (Exception ignored){

                }
               }
            }
        });

        income_clear.addMouseListener(new MouseListener() {
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
                income_clear.setBorder(BorderFactory.createLineBorder(Color.RED));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                income_clear.setBorder(null);
            }
        });
        income_clear.setBorder(null);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Creating Text area for history
        JTextArea textArea=new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(145,44,366,388);
        textArea.setBackground(new Color(85, 186, 235));
        textArea.setFont(new Font("Nanum", Font.PLAIN, 14));
//        textArea.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        try{
            File Total_Income=new File("Income.txt");
            File Total_Expenses=new File("Total_Expenses.txt");
            File Total_Items=new File("Total_Items.txt");
            File Total_Items_Price=new File("Total_Items1.txt");
            File Date_Log=new File("DateLogs.txt");
            Scanner total_Expenses=new Scanner(Total_Expenses);
            Scanner total_Items=new Scanner(Total_Items);
            Scanner total_Items_Price=new Scanner(Total_Items_Price);
            Scanner date_log=new Scanner(Date_Log);
            textArea.setText("\t"+date_log.nextLine()+"\n");
            textArea.append("====================================\n");
            while(total_Items.hasNextLine()){
                String lines=total_Items.nextLine()+total_Items_Price.nextLine();
                textArea.append(lines+"\n\n");
            }
            total_Expenses.close();
            total_Items.close();
            total_Items_Price.close();
            date_log.close();
            textArea.append("====================================");
        }catch (Exception ignored){

        }

/////////////////////////////////////////////////////////////////////////////////////////
        // Creating label for calculation
        calculate_label.setBounds(145,440,366,34);
        calculate_label.setFont(new Font("Nanum", Font.BOLD, 14));
//        calculate_label.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        calculate_label.setHorizontalAlignment(SwingConstants.CENTER);
        calculate_label.setVerticalAlignment(SwingConstants.CENTER);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Creating scrollbar for text area

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Creating print button
        JButton print_button=new JButton("PRINT");
        print_button.setBounds(145,482,98,32);
        print_button.setFont(new Font("Sofia", Font.PLAIN, 15));
//        print_button.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        print_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    textArea.print();
                } catch (PrinterException printerException) {
                    printerException.printStackTrace();
                }
            }
        });

        print_button.addMouseListener(new MouseListener() {
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
                print_button.setBorder(BorderFactory.createLineBorder(Color.RED));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                print_button.setBorder(null);
            }
        });
        print_button.setBorder(null);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Creating back button
        JButton back_button=new JButton("BACK");
        back_button.setBounds(413,482,98,32);
        back_button.setFont(new Font("Sofia", Font.PLAIN, 15));
//        back_button.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Entries_Table();
                history_frame.dispose();
            }
        });

        back_button.addMouseListener(new MouseListener() {
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
                back_button.setBorder(BorderFactory.createLineBorder(Color.RED));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                back_button.setBorder(null);
            }
        });
        back_button.setBorder(null);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Creating Calculate button
        JButton calculate_button=new JButton("CALCULATE");
        calculate_button.setBounds(265,482,126,32);
        calculate_button.setFont(new Font("Sofia", Font.PLAIN, 14));
//        calculate_button.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        calculate_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if(!textArea.getText().equals("")) {
                        File Income = new File("Income.txt");
                        File file = new File("Total_Items1.txt");
                        Scanner sc = new Scanner(file);
                        Scanner income = new Scanner(Income);
                        double total = 0;
                        while (sc.hasNextLine()) {
                            try {
                                total += sc.nextDouble();
                            } catch (Exception ignored) {

                            }
                        }
                        double sum = income.nextDouble() - total;
                        calculate_label.setText("Total expenses: " + total + "    Left amount: " + sum);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Nothing to calculate please enter some amount","Attention!!!",1);
                    }
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
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
                calculate_button.setBorder(null);
            }
        });
        calculate_button.setBorder(null);
////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////
        // Creating Clear Button
        JButton clear_button=new JButton("CLEAR");
        clear_button.setBounds(539,44,98,32);
        clear_button.setFont(new Font("Sofia", Font.PLAIN, 15));
//        clear_button.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        clear_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = JOptionPane.showConfirmDialog(history_frame,"Do you want to clear Income?","Conformation",JOptionPane.YES_NO_CANCEL_OPTION);
                if(JOptionPane.YES_OPTION==x) {
                    try {
                        FileWriter total_Items = new FileWriter("Total_Items.txt");
                        FileWriter total_Items_Price = new FileWriter("Total_Items1.txt");

                        FileWriter date_logs = new FileWriter("DateLogs.txt");
                        total_Items.write("");
                        total_Items_Price.write("");

                        date_logs.write("");
                        total_Items.flush();
                        total_Items_Price.flush();

                        date_logs.flush();
                        total_Items.close();
                        total_Items_Price.close();
                        date_logs.close();
                        textArea.setText("");
                    } catch (IOException ignored) {
                    }
                }
            }
        });

        clear_button.addMouseListener(new MouseListener() {
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
                clear_button.setBorder(BorderFactory.createLineBorder(Color.RED));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                clear_button.setBorder(null);
            }
        });
        clear_button.setBorder(null);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        JLabel background=new JLabel();
        background.setBounds(0,0,657,565);
        ImageIcon icon=new ImageIcon("/home/anonymous/Study Material/JAVA/JAVAProject/src/History.jpeg");
        background.setIcon(icon);
///////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////
        history_frame.add(income_clear);
        history_frame.add(calculate_button);
        history_frame.add(calculate_label);
        history_frame.add(clear_button);
        history_frame.add(back_button);
        history_frame.add(print_button);
        history_frame.add(textArea);
        history_frame.add(income_label);
        history_frame.setSize(657,565);
        history_frame.setLocation(dimension.width/2-history_frame.getSize().width/2, dimension.height/2-history_frame.getSize().height/2);
        history_frame.setResizable(false);
        history_frame.setLayout(null);
        history_frame.setVisible(true);
        history_frame.getContentPane().setBackground(new Color(175,231,234,255));
        history_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        history_frame.add(background);
    }
}
