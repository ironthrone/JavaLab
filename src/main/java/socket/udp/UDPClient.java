package socket.udp;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.*;

/**
 * Created by Administrator on 2017/5/8.
 */
public class UDPClient {
        private  static int TRY_CONNECT = 3;
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9000);
        String greet = "hello";
        byte[] greetBytes = greet.getBytes();
        InetAddress local = InetAddress.getLocalHost();
        //发送的数据包，指定内容和目标ip，port
        DatagramPacket packet = new DatagramPacket(greetBytes, greetBytes.length, local, 3000);
        byte[] buffer = new byte[1024];
        DatagramPacket dpReceive = new DatagramPacket(buffer, 1024);
        //socket timeout
        socket.setSoTimeout(3000);
        int trySend = 0;
        boolean getResponse = false;

        //获得回复或者不到最大重试次数，进行发送
        while (!getResponse && trySend < TRY_CONNECT) {
            //发送数据包
            socket.send(packet);
            try {
                //接收回复，由于设置了超时，超时时候receive被打断，所以我们捕捉了打断异常，
                socket.receive(dpReceive);
                if (!dpReceive.getAddress().equals(local)) {
                    throw new IOException("接收到其他主机的响应");
                }
                getResponse = true;
            } catch (InterruptedIOException e) {
                trySend++;
                System.out.println("超时，重试");
            }

        }
        if (getResponse) {
            String received = new String(dpReceive.getData());
            System.out.println("received data:" + received);
            dpReceive.setLength(1024);
        } else {
            System.out.println("no response");
        }
        socket.close();
    }
}
