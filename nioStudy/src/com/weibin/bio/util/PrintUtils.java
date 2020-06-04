package com.weibin.bio.util;

import com.weibin.thread.B;

import java.io.*;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/5/30
 **/
public final class PrintUtils {

    private PrintUtils(){};

    private static final OutputStream os = new BufferedOutputStream(System.out);
    private static final OutputStream noSyncOs = new BufferedOutputStream(System.out);

    public static synchronized void syncPrint(Object obj)  {
        try {
            os.write(String.valueOf(obj).getBytes());
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void syncPrintln(Object obj)  {
        try {
            os.write((String.valueOf(obj) + "\r\n").getBytes());
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void print(Object obj) {
        try {
            os.write(String.valueOf(obj).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void println(Object obj)  {
        try {
            os.write((String.valueOf(obj) + "\r\n").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        os.close();
        noSyncOs.close();
    }
}
