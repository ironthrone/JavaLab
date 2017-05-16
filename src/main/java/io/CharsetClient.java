package io;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * Created by Administrator on 2017/2/23.
 */
public class CharsetClient {
    public static void main(String[] args) throws CharacterCodingException {
        Charset charset = Charset.forName("8859_1");
        CharsetEncoder encoder = charset.newEncoder();
        ByteBuffer byteBuffer = ByteBuffer.allocate(128);
        byteBuffer.put(new byte[]{2, 4, 5, 6, 67,3});
        System.out.println(byteBuffer);
        byteBuffer.flip();
//        byteBuffer.clear();
//
//        System.out.println(byteBuffer);
        ByteBuffer encoded = encoder.encode(byteBuffer.asCharBuffer());
        System.out.println(encoded);



    }
}
