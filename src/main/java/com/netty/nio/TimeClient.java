package com.netty.nio;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2019-07-26
 * Time: 14:48
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 8090;
        if (args != null && args.length > 0)
            port = Integer.valueOf(args[0]);
        new Thread(new TimeClientHandle("127.0.0.1", port), "NIO-MULTIPLE-CLIENT-THREAD-01").start();
    }
}
