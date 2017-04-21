package effectivejava;

/**
 * Created by Administrator on 2017/4/21.
 */
public class BoxVSPrimitive {

    public static void main(String[] args) {

        Integer a = new Integer(24);
        Integer b = new Integer(24);

        //包装类型和原始类型混合运算，自动解包装
        System.out.println(a == 24);
        //原始类型直接使用"=="或者"!="时候,比较的是对象表示标识
        System.out.println(a == b);

        System.out.println(compareWithBox(a, b));
        System.out.println(compare(a, b));
        //原始类型的速度比包装类型的速度快10倍
        accumulate();
        accumulateWithBox();
    }

    private static void accumulateWithBox() {
        long start = System.currentTimeMillis();
        Long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("accumulateWithBox: cost " + (end - start));

    }

    private static void accumulate() {
        long start = System.currentTimeMillis();
        long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("accumulate: cost " + (end - start));

    }

    private static int compareWithBox(Integer a, Integer b) {
        return a - b < 0 ? -1 : a == b ? 0 : 1;
    }

    private static int compare(Integer a, Integer b) {
        int A = a;
        int B = b;
        return A - B < 0 ? -1 : A == B ? 0 : 1;
    }
}
