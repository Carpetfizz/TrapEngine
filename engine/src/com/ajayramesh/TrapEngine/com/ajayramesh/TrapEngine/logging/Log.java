package com.ajayramesh.TrapEngine.com.ajayramesh.TrapEngine.logging;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Log
{
	private static final long kSleepPeriod = 20; //ms
	private static Log instance = null;

    private static long startTime;
    private static LogLevel minimumLogLevel = LogLevel.DEBUG;
	
	private static final Queue<String> toLog = new ConcurrentLinkedQueue<String>();
	private final Thread periodicLogger;
	
	public static void initialize()
	{
		if (instance == null)
			instance = new Log();
	}

	private Log() {
		startTime = System.currentTimeMillis();
		periodicLogger = new PeriodicLogger();
		periodicLogger.start();
        Log.info("Initialized asynchronous logging");
	}
	
	public static void warn(String msg)
	{
		addToPrintQueue(msg, LogLevel.WARNING, System.currentTimeMillis());
	}
	
	public static void error(String msg)
	{
		addToPrintQueue(msg, LogLevel.ERROR, System.currentTimeMillis());
	}
	
	public static void info(String msg)
	{
		addToPrintQueue(msg, LogLevel.INFO, System.currentTimeMillis());
	}

	private static void addToPrintQueue(String msg, LogLevel level, long timestamp)
	{
        if(level.getPriority() < getMinimumLogLevel().getPriority())
            return;

        double properTime = (System.currentTimeMillis() - startTime) / 1000;
        String logMsg = String.format( "%.3f", properTime)+ '\t' + level + '\t' + msg;

        toLog.add(logMsg);
	}

	public static LogLevel getMinimumLogLevel()
    {
        return minimumLogLevel;
    }

    public static void setMinimumLogLevel(LogLevel level)
    {
        minimumLogLevel = level;
    }


	//Seperate thread periodically prints to output file
	private class PeriodicLogger extends Thread
	{
		@Override
		public void run()
		{
			while (true)
			{
				//long startTime = System.nanoTime();
				for (String msg : toLog) {
					System.out.println(msg);
				}
				toLog.clear();
				try
				{
					Thread.sleep(kSleepPeriod);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
