package yjjeon.example.chapter5;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Chapter5S1 {
    public int mutiply(int x, int y) {
        return x * y;
    }

    public void myMethod() {
        calculate(1, 3, this::mutiply);
    }

    public static int calculate(int x, int y, BiFunction<Integer, Integer, Integer> operator) {
        return operator.apply(x, y);
    }

    public static void main(String[] args) {
        int i = Integer.parseInt("1");
        System.out.println(i);
        Function<String, Integer> str2int = Integer::parseInt;
        int n = str2int.apply("2");
        System.out.println(n);

        String str = "Hello";
        Predicate<String> equalsToHello = str::equals;
        System.out.println(equalsToHello.test("Hello"));
        System.out.println(equalsToHello.test("Bye"));

        calculate(1, 2, (x, y) -> x + y);
        int result = calculate(1, 3, Chapter5S1::add);
        System.out.println(result);
        result = calculate(2, 3, new Chapter5S1()::mutiply);
        System.out.println(result);
    }

    public static int add(int x, int y) {
        return x + y;
    }
}
