package com.suidl.test.nio;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerTest {
    @Test
    public void should_test_io() throws IOException {
        Server server = new Server();
        server.start();
        //client threads
        for(int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                try (Socket client = new Socket(InetAddress.getLocalHost(), server.getPort())){
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    bufferedReader.lines().forEach(s -> System.out.println(s));
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void should_test_nio() {
        NIOServer server = new NIOServer();
        server.start();
        //client threads
        for(int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                try (Socket client = new Socket(InetAddress.getLocalHost(), 8888)){
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    bufferedReader.lines().forEach(s -> System.out.println(s));
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}