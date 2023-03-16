package com.zkb.springredisstudy.base.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {

    public static void main(String[] args) throws IOException {
        Selector severSelector = Selector.open();
        Selector clientSelector = Selector.open();

        new Thread(() -> {
            try {
                ServerSocketChannel listenerChannel = ServerSocketChannel.open();
                listenerChannel.socket().bind(new InetSocketAddress(8000));
                listenerChannel.configureBlocking(false);
                listenerChannel.register(severSelector, SelectionKey.OP_ACCEPT);

                while (true) {
                    if (severSelector.select(1) > 0) {
                        Set<SelectionKey> set = severSelector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = set.iterator();
                        while (keyIterator.hasNext()) {

                            SelectionKey key = keyIterator.next();

                            if (key.isAcceptable()) {
                                try {
                                    ServerSocketChannel channel = (ServerSocketChannel) (key.channel());
                                    SocketChannel clientChannel = channel.accept();
                                    clientChannel.configureBlocking(false);
                                    clientChannel.register(clientSelector, SelectionKey.OP_READ);
                                } finally {
                                    keyIterator.remove();
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {

            }
        }).start();


    }
}
