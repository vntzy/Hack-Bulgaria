package com.hackbulgaira.asciiart.players;

import java.io.File;
import java.io.IOException;

public class PicturePlayer extends FilePlayer {
    
    public PicturePlayer(File input) throws IOException {
        super(input);
    }
    
    @Override
    public void play() throws IOException {
        PlayerUtils.write(file);
    }

}
