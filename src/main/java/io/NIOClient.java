package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created by Administrator on 2017/2/22.
 */
public class NIOClient {
    public static void main(String[] args) throws IOException {
        init();
//copy();
//        transfer();
    }

    private static void init() throws IOException {

        File file = new File("test.txt");
        FileOutputStream fos = new FileOutputStream(file);
        FileChannel out = fos.getChannel();
//        ByteBuffer buffer = ByteBuffer.wrap("Hello world".getBytes());
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.asCharBuffer().put("hello world");
//        buffer.compact();
//        buffer.limit(buffer.position());
        out.write(buffer);
        FileInputStream fis = new FileInputStream(file);
        FileChannel in = fis.getChannel();
        buffer.clear();
        in.read(buffer);
        buffer.flip();
        String encoding = System.getProperty("file.encoding");
        System.out.println(Charset.forName(encoding).decode(buffer));
        buffer.rewind();
        System.out.println(buffer.asCharBuffer());
    }

    private static void copy() throws IOException {
        File file = new File("test.txt");
        File copy = new File("copy.txt");
        FileChannel in = new FileInputStream(file).getChannel();
        FileChannel out = new FileOutputStream(copy).getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (in.read(byteBuffer) != -1) {
            byteBuffer.flip();
            out.write(byteBuffer);
            byteBuffer.clear();
        }
    }

    private static void transfer() throws IOException {
        File file = new File("test.txt");
        File copy = new File("transfer.txt");
        FileChannel in = new FileInputStream(file).getChannel();
        FileChannel out = new FileOutputStream(copy).getChannel();
        in.transferTo(0,in.size(),out);
//        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//        while (in.read(byteBuffer) != -1) {
//            byteBuffer.flip();
//            out.write(byteBuffer);
//            byteBuffer.clear();
//        }
    }
}
