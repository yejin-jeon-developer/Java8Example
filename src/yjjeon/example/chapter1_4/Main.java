package yjjeon.example.chapter1_4;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        // 1. Function<Integer, Integer> myAdder = new Adder();
        /* 2. Lamda Expression
            Function<Integer, Integer> myAdder = (Integer x) -> {
            return x + 5;
        };
         */
        // 3. 추가 생략 가능
//        Function<Integer, Integer> myAdder = x -> x + 5; // 매개변수 유추가능(괄호생략), 리턴타입 유추가능 (중괄호, return 생략가능)
//
//        System.out.println(myAdder.apply(10));
//
//        BiFunction<Integer, Integer, Integer> add = (x, y) -> x+y;
//        int result = add.apply(3,5);
//        System.out.println(result);
//
//        TriFunction<Integer, Integer, Integer, Integer> triAdder = (x,y,z) -> x+y+z;
//
//        int result2 = triAdder.apply(1,2,3);
//        System.out.println(result2);

        Supplier<Integer> supplier = () -> 1;
        //System.out.println(supplier.get());

        Supplier<Double> doubleSupplier = () -> Math.random();
        //printRandomDouble(doubleSupplier, 5);

        Consumer<String> stringConsumer = (s) -> System.out.println(s);
        //stringConsumer.accept("hello");

        /*List<Integer> inputs = Arrays.asList(4, 2, 3); //immutable add하면 에러남
        Consumer<Integer> processor = (x) -> System.out.println("Processing Integer : " + x);
        process(inputs, processor);
        Consumer<Integer> diffProcessor = (x) -> System.out.println("Processing Integer in diff way : " + x);
        process(inputs, diffProcessor);

        List<Double> doubleInputs = Arrays.asList(1.1, 2.2, 3.3);
        Consumer<Double> doubleProcessor = (x) -> System.out.println("Processing Double : " + x);
        process2(doubleInputs, doubleProcessor );*/

        List<Double> doubleInputs = Arrays.asList(1.1, 2.2, 3.3);
        BiConsumer<Integer, Double> myProcessor = (index, input)
                -> System.out.println("Processing " + input + " at index  " + index );
        process3(doubleInputs, myProcessor);

    }

    public static <T> void process3 (List<T> inputs, BiConsumer<Integer, T> processor) {
        for (int i = 0; i < inputs.size(); i++) {
            processor.accept(i, inputs.get(i));
        }
    }

    // processor를 넘겨줘서 다양한 방법으로 process 가능
    public static void process(List<Integer> inputs, Consumer<Integer> processor) {
        for (Integer i : inputs) {
            processor.accept(i);
        }
    }

    public static <T> void process2(List<T> inputs, Consumer<T> processor) {
        for (T t : inputs) {
            processor.accept(t);
        }
    }

    public static void printRandomDouble(Supplier<Double> randomSupplier, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(randomSupplier.get());
        }
    }


}
