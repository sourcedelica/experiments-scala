package experiments;

public class Varargs {
    public static void main(String args[]) {
        foo("hey");
    }

    static void foo(String... args) {
        System.out.println(args[0]);
    }
}
