package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/2/13.
 */
public class BufferClient {
    static String path = "F:\\AndroidStudioProjects\\tij4\\src\\main\\java\\test.exe";
    static final int TEST_COUNT = 1;

    static class NormalRead implements Runnable {
        public void run() {
            try {
                FileInputStream fileInputStream = new FileInputStream(path);
                byte[] box = new byte[9196];
                long start = System.currentTimeMillis();
                for (int i = 0; i < TEST_COUNT; i++) {

                    while (fileInputStream.read(box) != -1) {


                    }
                }
                long end = System.currentTimeMillis();
                System.out.println("normal: " + (end - start));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    static class BufferedRead implements Runnable {

        public void run() {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
                byte[] box = new byte[1024];

                long start = System.currentTimeMillis();

                for (int i = 0; i < TEST_COUNT; i++) {

                    while (bufferedInputStream.read() != -1) {

                    }
                }
                long end = System.currentTimeMillis();
                System.out.println("buffer: " + (end - start));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    static class ChannelRaad implements Runnable {

        public void run() {
            try {
                FileInputStream fileInputStream = new FileInputStream(path);
                FileChannel channel = fileInputStream.getChannel();
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                long start = System.currentTimeMillis();
                while ( channel.read(byteBuffer) == 1024){

                }
                long end = System.currentTimeMillis();
                System.out.println("channel: " + (end - start));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(BufferClient.class.getProtectionDomain().getCodeSource().getLocation());
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new NormalRead());
        executorService.execute(new BufferedRead());
        executorService.execute(new ChannelRaad());

    }
}
