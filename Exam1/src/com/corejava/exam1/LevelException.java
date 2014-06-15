package com.corejava.exam1;

public class LevelException extends RuntimeException {
    /**
     * Exception is thrown when logging a message with incorrect level
     */
    private static final long serialVersionUID = 7349805433860994938L;

    public LevelException() {
        super("Level must be a positive integer!");
    }
}
