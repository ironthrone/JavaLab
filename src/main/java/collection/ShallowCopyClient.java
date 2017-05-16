package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/2/10.
 */
public class ShallowCopyClient {
    public static void main(String[] args) {
        List<Bean> beans = new ArrayList<Bean>();
        Bean apple = new Bean("apple");
        beans.add(apple);
        List<Bean> dst = new ArrayList<Bean>();
        dst.add(new Bean("asdf"));
        Collections.copy(dst,beans);
        apple.name = "patch";
        System.out.println(dst.get(0).name);
    }

    static class Bean{
        String name;

        public Bean(String name) {
            this.name = name;
        }
    }

}
