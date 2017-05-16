package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/2/9.
 */
public class Stack<E extends Object> {
    private ArrayList<E> elements = new ArrayList<E>();

    public Stack(int size) {
    }

    public boolean isEmpty() {
        return false;
    }

    public E pop() {
        if(elements.size() == 0) return null;
        return elements.remove(elements.size());
    }

    public void push(E e) {
        elements.add(e);
    }

    public void popAll(Collection<? super E> dst) {
        if (!isEmpty()) {
            dst.add(pop());
        }
    }

    public void wildcard(Collection<? extends Integer> e) {

    }

    public static <E> Set<? extends E> union(Set<E> s1, Set<E> s2) {
        return null;
    }

    public static void swapp(List<?> list, int a, int b) {
        swapHelper(list,a,b);
    }

    public static <E> void swapHelper(List<E> list, int a, int b) {
        list.set(a, list.set(b, list.get(a)));

    }

    public static <E> void swap(List<E> list, int a, int b) {
        list.set(a, list.set(b, list.get(a)));

    }

    public static void main(String[] args) {
        Stack<Number> stack = new Stack<Number>(20);
        Collection<String> coll = new ArrayList<String>();
        coll.add("sfs");
        Collection<Object> objects = new ArrayList<Object>();
        stack.popAll(objects);
    }
}
