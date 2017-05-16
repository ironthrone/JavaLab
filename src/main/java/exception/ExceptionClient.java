package exception;

/**
 * Created by Administrator on 2017/2/10.
 */
public class ExceptionClient {
    public static void main(String[] args) {

        good();

    }

    private static void good() {
        error();
    }

    //注意观看异常的栈信息
    private static void error() {
        try {

            throw new UnsupportedOperationException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
