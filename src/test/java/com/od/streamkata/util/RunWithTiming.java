package com.od.streamkata.util;

/**
 * Created by nick on 23/01/15.
 */
public class RunWithTiming {

    public static void runWithTiming(String desc, Runnable r) {
        long startTime = System.currentTimeMillis();
        r.run();
        long runTime = System.currentTimeMillis() - startTime;
        System.out.println(desc + " ran in " + runTime + " millis");
    }
}
