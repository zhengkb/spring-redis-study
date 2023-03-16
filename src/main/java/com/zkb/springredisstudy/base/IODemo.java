package com.zkb.springredisstudy.base;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class IODemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8088);

        new Thread(() -> {
            try {
                Socket accept = serverSocket.accept();
                new Thread(() -> {
                    try {
                        int len;
                        byte[] data = new byte[1024];
                        InputStream inputStream = accept.getInputStream();
                        while ((len = inputStream.read(data)) != -1) {
                            System.out.println(new String(data, 0, len));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
