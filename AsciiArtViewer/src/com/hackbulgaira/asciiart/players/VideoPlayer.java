package com.hackbulgaira.asciiart.players;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import jline.ConsoleReader;

import org.jcodec.api.FrameGrab;
import org.jcodec.api.JCodecException;
import org.jcodec.common.FileChannelWrapper;

public class VideoPlayer extends SequencePlayer {
    
    private FrameGrab grab;

    public VideoPlayer(File input) throws IOException, JCodecException {
        super(input);
        
        FileInputStream fileInputStream = new FileInputStream(file);
        grab = new FrameGrab(new FileChannelWrapper(fileInputStream.getChannel()));
//        fileInputStream.close();
    }

    @Override
    public void play() throws IOException, InterruptedException {
//        List<BufferedImage> frames = new ArrayList<>();
//        BufferedImage frame = null;
//        for (int i=0;i<500;i++) {
//            frame = grab.getFrame();
//            frames.add(frame);
//        }
//        
//        ConsoleReader r = new ConsoleReader();
//        for (BufferedImage img: frames) {
//            PlayerUtils.write(img);
//            Thread.sleep(20);
//            r.clearScreen();
//        }
        ConsoleReader r = new ConsoleReader();
        BufferedImage frame = null;
        while ((frame = grab.getFrame()) != null) {
            PlayerUtils.write(frame);
//            Thread.sleep(40);
            r.clearScreen();
        }
    }
}
