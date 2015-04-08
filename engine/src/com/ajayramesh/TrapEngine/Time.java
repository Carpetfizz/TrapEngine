package com.ajayramesh.TrapEngine;

public class Time
{
    public static double currentTimeMs()
    {
        return System.nanoTime() / 1000000L;
    }
}
