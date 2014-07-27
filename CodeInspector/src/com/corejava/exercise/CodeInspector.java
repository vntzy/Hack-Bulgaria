package com.corejava.exercise;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

import syntaxhighlight.SyntaxHighlighter;
import syntaxhighlighter.SyntaxHighlighterParser;
import syntaxhighlighter.brush.BrushCss;
import syntaxhighlighter.brush.BrushJScript;
import syntaxhighlighter.brush.BrushJava;
import syntaxhighlighter.brush.BrushPhp;
import syntaxhighlighter.theme.ThemeRDark;

import com.nitido.utils.toaster.Example;

public class CodeInspector {
    public static void main(String[] args) {
        SyntaxHighlighterParser parser = new SyntaxHighlighterParser(new BrushJava());
        parser.setHtmlScript(true);
        parser.setHTMLScriptBrushes(Arrays.asList(new BrushCss(), new BrushJScript(), new BrushPhp()));

        SyntaxHighlighter highlighter = new SyntaxHighlighter(parser, new ThemeRDark());
        highlighter.setFirstLine(10);
        highlighter.setHighlightedLineList(Arrays.asList(13, 27, 28, 38, 42, 43, 53));
        try {
          highlighter.setContent(new File(args[0].toString()));
        } catch (IOException ex) {
          Logger.getLogger(Example.class.getName()).log(Level.SEVERE, null, ex);
        }

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(highlighter);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);

    }
}
