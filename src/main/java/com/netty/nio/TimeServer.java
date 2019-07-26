package com.netty.nio;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2019-07-26
 * Time: 13:38
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 8090;
        if (args != null && args.length > 0)
            port = Integer.valueOf(args[0]);
        MultipleTimeServer multipleTimeServer = new MultipleTimeServer(port);
        new Thread(multipleTimeServer, "NIO-MULTIPLE-SERVER-THREAD-01").start();
    }
}
