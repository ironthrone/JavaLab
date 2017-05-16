package generic;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/2/6.
 */
public class GenericClient {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        for (String arg : args) {
            stack.push(arg);
        }

    }
    static class Stack<E>{
        Object[] elements;
        int size;
        public Stack() {
            elements = new Object[2];
        }

        public void push(E e) {

            elements[size++] = e;
        }

        public E pop() {
            @SuppressWarnings("uncheck") E e =  (E) elements[size--];
            return e;
        }

        private void ensureCapacity() {
            if (elements.length == size) {
                elements = Arrays.copyOf(elements, elements.length * 2);
            }
        }
    }
}
