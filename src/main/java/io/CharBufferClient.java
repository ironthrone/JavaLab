package io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * Created by Administrator on 2017/2/23.
 */
public class CharBufferClient {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        charBuffer.put("hello");
        System.out.println(charBuffer.get(2));
        charBuffer.put(2, 'f');
        charBuffer.flip();
        while (charBuffer.hasRemaining()) {

            System.out.println(charBuffer.get());
        }

    }
}
