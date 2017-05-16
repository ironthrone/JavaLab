

interface Interface {
    String hello = "hello";

    default void greet() {
        System.out.println(hello);
    }
}