package com.scoundEffect;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicEffect{

    Clip clip;

    public void setFile(String soundFileName) {
        File file = new File(soundFileName);
        try {
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    void play(){
        clip.setFramePosition(0);
        clip.start();
    }

    void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    void stop(){
        clip.stop();
        clip.close();
    }
}
