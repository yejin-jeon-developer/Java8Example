package yjjeon.example.chapter8;

import java.util.Optional;
import java.util.stream.Stream;

public class Chapter8S3 {
    public static void main(String[] args) {
        Optional<Integer> anyNegativeInteger = Stream.of(1,2,3,-4)
                .filter(n -> n < 0)
                .findAny();
        System.out.println(anyNegativeInteger);

        Optional<Integer> firstPositiveInteger = Stream.of(1,2,3,-4)
                .filter(n -> n > 0)
                .findFirst();
        System.out.println(firstPositiveInteger);
    }
}
