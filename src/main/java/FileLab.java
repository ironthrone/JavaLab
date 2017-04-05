import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/4/5.
 */
public class FileLab {
    public static void main(String[] args) {
        /**
         * 上一个文件夹符号".."可用
         */
        java.io.File file = new File("src/main/java/..", "lastDir.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
