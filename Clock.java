package com.digitalClock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

class Clock {
    public static void main(String[] args) {
        clockLabel date = new clockLabel("date");
        clockLabel time = new clockLabel("time");
        clockLabel day = new clockLabel("day");

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("DIGITAL CLOCK");
        frame.setSize(350,600);
        frame.getContentPane().setLayout(new GridLayout(3,1));
        frame.setVisible(true);

        frame.getContentPane().add(day);
        frame.getContentPane().add(time);
        frame.getContentPane().add(date);


        frame.getContentPane().setBackground(Color.BLACK);
    }
}
class clockLabel extends JLabel implements ActionListener{
    String one;
    SimpleDateFormat sdf;
    public clockLabel(String one){
        this.one = one;
        setForeground(Color.GREEN);

        switch (one){
            case "date" : sdf = new SimpleDateFormat("dd-MM-yyyy");
            setFont(new Font("Gayathri",Font.PLAIN,60));
            setHorizontalAlignment(SwingConstants.CENTER);
            break;

            case "time": sdf = new SimpleDateFormat("HH:mm:ss");
            setFont(new Font("Gayathri",Font.BOLD,90));
            setHorizontalAlignment(SwingConstants.CENTER);
            break;

            case "day": sdf = new SimpleDateFormat("EEEE");
            setFont(new Font("Gayathri",Font.PLAIN,60));
            setHorizontalAlignment(SwingConstants.CENTER);
            break;

            default: sdf = new SimpleDateFormat();
            break;
        }
        Timer timer = new Timer(0, this);
        timer.start();
        }
    public void actionPerformed(ActionEvent arg0){
        Date dt = new Date();
        setText(sdf.format(dt));
    }

}
