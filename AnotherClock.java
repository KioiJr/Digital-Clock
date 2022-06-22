package com.digitalClock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AnotherClock {
    public static void main(String[] args) {
        DigiClock day = new DigiClock("day");
        DigiClock time = new DigiClock("time");
        DigiClock date = new DigiClock("date");

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Another one");
        frame.setSize(350,350);
        frame.getContentPane().setLayout(new GridLayout(3,1));
        frame.getContentPane().add(day);
        frame.getContentPane().add(time);
        frame.getContentPane().add(date);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.BLACK);

    }
     static class DigiClock extends JLabel implements ActionListener {

        String watch;
        SimpleDateFormat dateFormat;

       public DigiClock(String watch){
           this.watch = watch;
           setForeground(Color.GREEN);
           switch (watch){
               case "day": dateFormat = new SimpleDateFormat("EEEE");
               setFont(new Font("Gayathri",Font.PLAIN,60));
               setHorizontalAlignment(SwingConstants.CENTER);
               break;

               case"date": dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                   setFont(new Font("Gayathri",Font.PLAIN,60));
                   setHorizontalAlignment(SwingConstants.CENTER);
                   break;

               case"time": dateFormat = new SimpleDateFormat("HH:mm:ss");
                   setFont(new Font("Gayathri",Font.PLAIN,60));
                   setHorizontalAlignment(SwingConstants.CENTER);
                   break;
               default: dateFormat = new SimpleDateFormat();
               break;
           }
           Timer timer = new Timer(0,this);
           timer.start();

        }

        public void actionPerformed(ActionEvent actionEvent) {
            Date date = new Date();
            setText(dateFormat.format(date));
        }
    }
}
