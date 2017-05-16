/**
 * Created by Administrator on 2017/5/5.
 */
public class RuntimeClient {
    public static void main(String[] args)  {
        Runtime runtime = Runtime.getRuntime();
        StringBuilder sb = new StringBuilder();

        // 分配大的内存，产生内存溢出
        byte[] dump = new byte[1024 * 1024 * 1024];
//        byte[] dum2 = new byte[1024 * 1024 * 1024];


        sb.append("availableProcessor: " + runtime.availableProcessors());
        sb.append("\n");
        sb.append("maxMemory: " + runtime.maxMemory());
        sb.append("\n");
        sb.append("totalMemory: " + runtime.totalMemory());
        sb.append("\n");
        sb.append("freeMemory: " + runtime.freeMemory());
        sb.append("\n");
        System.out.println(sb.toString());
    }
}
