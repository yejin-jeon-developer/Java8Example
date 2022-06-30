package yjjeon.example.chapter8;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter8S5 {
    public static void main(String[] args) {
        List<Integer> numbers = Stream.of(3, 5, -3, 3, 4, 5)
                .collect(Collectors.toList());
        System.out.println(numbers);

        Set<Integer> numberSet = Stream.of(3, 5, -3, 3, 4, 5)
                .collect(Collectors.toSet());
        System.out.println(numberSet);

        List<Integer> numberList2 = Stream.of(3, 5, -3, 3, 4, 5)
                .collect(Collectors.mapping(x -> Math.abs(x), Collectors.toList()));
        System.out.println(numberList2);

        int sum = Stream.of(3, 5, -3, 3, 4, 5)
                .collect(Collectors.reducing(0, (x, y) -> x + y));
        System.out.println(sum);
    }
}
