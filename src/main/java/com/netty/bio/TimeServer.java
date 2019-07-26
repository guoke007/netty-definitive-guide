package com.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2019-07-26
 * Time: 9:52
 */
public class TimeServer {
    private static final ExecutorService executorService;

    static {
        executorService = new TimeServerHandlerExecutePool(50, 10000);
    }

    public static void main(String[] args) throws IOException {
        int port = 8090;
        if (args != null && args.length > 0)
            port = Integer.valueOf(args[0]);
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The timeServer start in port " + port);
            Socket socket;
            while (true) {
                socket = server.accept();
                executorService.execute(new TimeServerHandler(socket));
            }
        } finally {
            if (server != null) {
                System.out.println("the timeServer closed");
                server.close();
                server = null;
            }
        }
    }
}
