package com.corejava.exam1;

public class Logger {
    
    private int level;
    
    public Logger(int lvl) {
        if (lvl <= 0)
            throw new LevelException();
        else
            this.level = lvl;
    }
    
    public Logger() {
        this.level = 3;
    }
    
    public void setLevel(int lvl) {
        if (lvl <= 0)
            throw new LevelException();
        else
            level = lvl;
    }
    
    public void log(int lvl, String message) {
        if (lvl <= 0)
            throw new LevelException();
        else
            if (lvl <= level && lvl > 0) printToConsole(lvl, message);
    }
    
    public void log(String message) {
        this.log(3, message);
    }
    
    protected void printToConsole(int lvl, String message) {
        System.out.println(lvl + " => " + message);
    }
}
