package com.ajayramesh.TrapEngine.com.ajayramesh.TrapEngine.logging;


public class LogLevel
{
    public static LogLevel DEBUG = new LogLevel("Debug", 0);
    public static LogLevel INFO = new LogLevel("Info", 1);
    public static LogLevel WARNING = new LogLevel("Warning", 2);
    public static LogLevel ERROR = new LogLevel("Error", 3);

    private String name;

    private int priority;

    private LogLevel(String name, int priority)
    {
        this.name = name;
        this.priority = priority;
    }

    public String getName()
    {
        return name;
    }

    public String toString()
    {
        return getName();
    }

    public int getPriority()
    {
        return priority;
    }
}
