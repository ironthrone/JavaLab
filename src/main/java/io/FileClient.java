package io;

import java.io.IOException;
import java.io.File;
/**
 * Created by Administrator on 2016/12/29.
 */
public class FileClient {
    public static void main(String[] args) throws IOException {

        File file = new File("Where/How");
        boolean create;
        if (file.exists()) {
            file.delete();
        }
        //创建文件夹，上级文件夹不存在的时候也被创建
        file.mkdirs();
        //判断是否存在，然后在创建
        if (!file.exists()) {
            do {
                create = file.createNewFile();
            } while (!create);

        }
        File how = new File("How");
        file.renameTo(how);  //重命名
        System.out.println(file.lastModified());
        System.out.println(file.canRead());
        System.out.println("success");


    }
}
