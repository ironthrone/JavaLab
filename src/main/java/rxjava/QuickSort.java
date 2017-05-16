package rxjava;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/2/28.
 */
public class QuickSort {

    static void sort(int[] data) {
        sort(data, 0, data.length - 1);
    }

    static void sort(int[] data, int lo, int hi) {
        if(lo >= hi) return;
        int p = partion(data, lo, hi);
        sort(data,lo,p-1);
        sort(data,p+1,hi);
    }

    static int partion(int[] data, int lo, int hi) {
        int i = lo;
        int j = hi+1;
        int v = data[lo];
        while (true) {
            while (data[++i] < v) if(i == hi) break;
            while (data[--j] > v) if(j==lo)break;
            if(i >= j) break;
            System.out.println("i: " + i);
            System.out.println("j: " + j);
            exchange(data,i,j);
        }
        exchange(data, lo, j);
        return j;
    }

    static void exchange(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    public static void main(String[] args) {
        int[] data = new int[]{1, 4, 6, 7, 4, 2, 33, 66, 77, 22};
        QuickSort.sort(data);
        System.out.println(Arrays.toString(data));
    }
}
