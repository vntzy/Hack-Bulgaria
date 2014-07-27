package com.hackbulgaira.asciiart.players;

import java.io.File;
import java.io.IOException;

public abstract class FilePlayer implements Player {
    protected File file;
    
    public FilePlayer(File input) throws IOException {
        file = input;
    }
}
