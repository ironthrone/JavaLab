/**
 * Created by Administrator on 2017/4/6.
 */
public class ExceptionLab {
    public static void main(String[] args) {
        try {
            throw new UnsupportedOperationException();
        } catch (UnsupportedOperationException e) {
            e.printStackTrace(System.out);
        }

        System.out.println("survive through a disaster");
    }
}
