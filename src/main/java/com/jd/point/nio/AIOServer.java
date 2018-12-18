package com.jd.point.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class AIOServer extends Thread {
    @Override
    public void run() {

//        AsynchronousServerSocketChannel serverSock =        AsynchronousServerSocketChannel.open().bind(sockAddr);
//        serverSock.accept(serverSock, new CompletionHandler<>() { // 为异步操作指定 CompletionHandler 回调函数
//            @Override
//            public void completed(AsynchronousSocketChannel sockChannel, AsynchronousServerSocketChannel serverSock) {
//                serverSock.accept(serverSock, this);
//                // 另外一个 write（sock，CompletionHandler{}）
//                sayHelloWorld(sockChannel, Charset.defaultCharset().encode
//                        ("Hello World!"));
//            }
//            // 省略其他路径处理方法...
//        });


        try(Selector selector = Selector.open();//创建一个selector 类似于调度员的角色
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.bind(new InetSocketAddress(InetAddress.getLocalHost(),8888));
            serverSocketChannel.configureBlocking(false);

            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);//高速调度员 severSocketChannel 关注新的连接
            while (true) {
                selector.select();//阻塞等待就绪的channel 
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iter = selectionKeys.iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    sayHello((ServerSocketChannel) key.channel());
                    iter.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sayHello(ServerSocketChannel channel) throws IOException {
        try (SocketChannel client = channel.accept()) {
            client.write(Charset.defaultCharset().encode("Hello World !"));
        }
    }
}
