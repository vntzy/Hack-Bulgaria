package com.corejava.exam1;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateLogger extends Logger {
    
    public DateLogger() {
        super();
    }
    
    public DateLogger(int lvl) {
        super(lvl);
    }
    
    @Override
    protected void printToConsole(int lvl, String message) {
        String now = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy").format(Calendar.getInstance().getTime());
        System.out.print("|" + now + "| ");
        super.printToConsole(lvl, message);
    }
}
