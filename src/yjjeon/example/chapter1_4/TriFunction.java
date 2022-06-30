package yjjeon.example.chapter1_4;

@FunctionalInterface
public interface TriFunction<T, U, A, R> {
    R apply(T t, U u, A a);
}
