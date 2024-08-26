package com.scoundEffect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sound {

    MusicEffect mu = new MusicEffect();
    SoundEffect se = new SoundEffect();
    ButtonHandler bHandler = new ButtonHandler();

    JFrame frame;
    JPanel panel;
    JButton button, musicButton;
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);

    String clickSound;
    String music;
    boolean musicState;

    public static void main(String[] args) {
        new Sound();
    }

    public Sound(){
        frame = new JFrame();
        frame.setSize(800,600);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBounds(200,330,400,150);
        panel.setBackground(Color.black);
        panel.setLayout(new GridLayout(2,1));

        button = new JButton("SOUND EFFECT");
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.setFocusPainted(false);
        button.setFont(normalFont);
        button.addActionListener(bHandler);
        button.setActionCommand("s1");
        panel.add(button);

        musicButton = new JButton("MUSIC EFFECT");
        musicButton.setFont(normalFont);
        musicButton.setBackground(Color.black);
        musicButton.setForeground(Color.white);
        musicButton.setFocusPainted(false);
        musicButton.addActionListener(bHandler);
        musicButton.setActionCommand("s2");
        panel.add(musicButton);

        frame.add(panel);
        frame.setVisible(true);

        clickSound = "res/button-202966.wav";
        music = "res/tavern-pack-transitions_16-64821.wav";
    }


    public class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String clickButton = e.getActionCommand();

            switch (clickButton){
                case "s1" :
                    se.setFile(clickSound);
                    se.play();
                    break;
                case "s2" :
                    if (!musicState) {
                        mu.setFile(music);
                        mu.play();
                        mu.loop();
                        musicState = true;
                        musicButton.setText("MUSIC ON");
                    } else {
                        musicState = false;
                        mu.stop();
                        musicButton.setText("MUSIC OFF");
                    }
            }
        }
    }
}
