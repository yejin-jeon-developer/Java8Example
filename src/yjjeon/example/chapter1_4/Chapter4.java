package yjjeon.example.chapter1_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Chapter4 {
    public static void main(String[] args) {
        Predicate<Integer> isPositive = x -> x > 0;
        System.out.println(isPositive.test(-1));

        List<Integer> inputs = Arrays.asList(1,-2,3,-4,0, 2);
        System.out.println("Positive number : " + filter(inputs, isPositive));
        System.out.println("Non-Positive Number : " + filter(inputs, isPositive.negate()));
        System.out.println("Non-Negative Number : " + filter(inputs, isPositive.or(x -> x == 0))); // x > 0 || x == 0
        System.out.println("Positive even number : " + filter(inputs, isPositive.and(x -> x % 2 == 0))); // x > 0 && x % 2 == 0
    }

    public static <T> List<T> filter(List<T> inputs, Predicate<T> condition) {
        List<T> output = new ArrayList<>();
        for (T t : inputs) {
            if (condition.test(t)) output.add(t);
        }
        return output;
    }
}
