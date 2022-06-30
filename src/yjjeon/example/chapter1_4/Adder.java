package yjjeon.example.chapter1_4;

import java.util.function.Function;

public class Adder implements Function<Integer, Integer> {
    public Integer apply(Integer x) {
        return x+10;
    }

    public <T> void add(T t) {

    }
}
