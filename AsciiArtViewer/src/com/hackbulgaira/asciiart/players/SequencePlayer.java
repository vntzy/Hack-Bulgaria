package com.hackbulgaira.asciiart.players;

import java.io.File;
import java.io.IOException;

public abstract class SequencePlayer extends FilePlayer {

    public SequencePlayer(File input) throws IOException {
        super(input);
    }
}
