package com.hackbulgaira.asciiart.players;

import java.io.IOException;
import java.nio.file.Paths;

import org.jcodec.api.JCodecException;

public class Main {
    public static void main(String[] args) throws IOException, JCodecException, InterruptedException {
        FilePlayer player = null;
        if (args[0].toLowerCase().equals("picture")) {
            player = new PicturePlayer(Paths.get(args[1]).toFile());
        } else if (args[0].toLowerCase().equals("video")){
            player = new VideoPlayer(Paths.get(args[1]).toFile());
        } else {
            System.out.println("Please enter 'video' or 'picture' for first argument!");
            System.exit(1);
        }
        player.play();
    }
}
