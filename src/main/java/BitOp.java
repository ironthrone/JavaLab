/**
 * Created by Administrator on 2017/4/27.
 */
public class BitOp {
    //十六进制表示整数
    static final int AMBITION = 0x0001;
    static final int EFFORT = 0x1 ;
    static final int LUCKY = 0x1 << 2;


    public static void main(String[] args) {
        int WHO_AM_I = 1 << 31;

        printBinary(WHO_AM_I);
        System.out.println(AMBITION);
        printBinary(AMBITION);
        printBinary((WHO_AM_I |= AMBITION ));
        printBinary(WHO_AM_I &= ~AMBITION);

    }

    static void printBinary(int i) {
        System.out.println(Integer.toBinaryString(i));
    }
}
