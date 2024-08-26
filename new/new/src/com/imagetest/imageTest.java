package com.imagetest;

import javax.swing.*;
import java.awt.*;

public class imageTest {

    Container con;
    JFrame frame;
    JPanel imagePanel;
    JLabel imgLabel;
    ImageIcon img;

    public static void main(String[] args) {
        new imageTest();
    }

    public imageTest(){
        frame = new JFrame();
        frame.setSize(800,600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.black);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        con = frame.getContentPane();

        imagePanel = new JPanel();
        imagePanel.setBounds(140,130,500,300);
        imagePanel.setBackground(Color.black);

        img = new ImageIcon("res/earth.jpeg");
        imgLabel = new JLabel();
        imgLabel.setIcon(img);

        imagePanel.add(imgLabel);

        con.add(imagePanel);
    }

}
