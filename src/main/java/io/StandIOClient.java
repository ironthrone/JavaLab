package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by Administrator on 2017/2/13.
 */
public class StandIOClient {
    public static void main(String[] args) {
        try {
            //重定向标准IO
            FileOutputStream fileOutputStream = new FileOutputStream("Hello.txt");
            PrintStream printStream = new PrintStream(fileOutputStream);
            System.setOut(printStream);
            System.out.println("Hello,new output");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
