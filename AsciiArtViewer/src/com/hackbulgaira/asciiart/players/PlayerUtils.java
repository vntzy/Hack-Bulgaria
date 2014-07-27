package com.hackbulgaira.asciiart.players;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PlayerUtils {
    
    public static void write(File file) throws IOException {
        System.out.println(new ASCIIViewer(file).toString());
    }
    
    public static void write(BufferedImage img) throws IOException {
        System.out.println(new ASCIIViewer(img).toString());
    }
    
    private static class ASCIIViewer {
        private final static int columns = 140;
        private BufferedImage image;
        private int scale;

        public ASCIIViewer(BufferedImage img) {
            image = img;
            if (image.getWidth() > columns) {
                scale = image.getWidth() / columns + 1;
            } else {
                scale = 1;
            }
        }

        public ASCIIViewer(File file) throws IOException {
            new ASCIIViewer(ImageIO.read(file));
        }

        private int getBlockIntensity(int x, int y) {
            int averageIntensity = 0;
            for (int i = x; i < scale + x; i++) {
                for (int j = y; j < scale + y; j++) {
                    averageIntensity += getIntensity(i, j);
                }
            }
            return averageIntensity / (scale * scale);
        }

        private int getIntensity(int x, int y) {
            Color color = new Color(this.image.getRGB(x, y), false);
            int intensity = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
            return intensity;
        }

        private String pixelToChar(int intensity) {
            if (intensity >= 240) {
                return " ";
            } else if (intensity >= 200 && intensity < 240) {
                return ".";
            } else if (intensity >= 160 && intensity < 200) {
                return "~";
            } else if (intensity >= 120 && intensity < 160) {
                return "+";
            } else if (intensity >= 80 && intensity < 120) {
                return "=";
            } else if (intensity >= 40 && intensity < 80) {
                return "#";
            } else {
                return "@";
            }
        }

        @Override
        public String toString() {
            String result = "";
            for (int y = 0; y < this.image.getHeight() - scale; y += scale) {
                for (int x = 0; x < this.image.getWidth() - scale; x += scale) {
                    result += pixelToChar(getBlockIntensity(x, y));
                }
                result += System.lineSeparator();
            }
            return result;
        }
    }
}
