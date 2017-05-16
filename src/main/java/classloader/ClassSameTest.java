package classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/3/3.
 */
public class ClassSameTest {
    public static void main(String[] args) {

        String rootDir = "F:\\AndroidStudioProjects\\tij4\\src\\main";
        MyClassLoader classLoader1 = new MyClassLoader(rootDir);
        MyClassLoader classLoader2 = new MyClassLoader(rootDir);
        System.out.println(classLoader1.getClass().getClassLoader());
        System.out.println(classLoader1.getClass().getClassLoader().getParent());
        try {
            Class<?> clazz = classLoader1.loadClass("Sample");
            Object obj = clazz.newInstance();

            Class<?> clazz2 = classLoader2.loadClass("Sample");
            Object obj2 = clazz2.newInstance();

            System.out.println(obj.getClass().toString() + "\n" + obj.getClass().getClassLoader().toString());
            System.out.println(obj2.getClass().toString() + "\n" + obj2.getClass().getClassLoader().toString());
            Method method = clazz.getMethod("setAnother", Object.class);
            method.invoke(obj, obj2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
