package com.scoundEffect;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundEffect{

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
}

