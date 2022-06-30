package yjjeon.example.chapter5;

import yjjeon.example.chapter5.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

public class Chapter5S2 {
    public static void main(String[] args) {
        Function<String, Integer> strLength = String::length;
        int length = strLength.apply("Hello world");
        System.out.println(length);

        BiPredicate<String, String> strEquals = String::equals;
        boolean isEqual = strEquals.test("hello", "hello");
        System.out.println(isEqual);

        List<User> users = new ArrayList<>();
        users.add(new User(1, "A"));
        users.add(new User(5, "B"));
        users.add(new User(3, "C"));

        printUserFields(users, user -> user.getId());
        printUserFields(users, User::getId);
        printUserFields(users, User::toString);

        User user = new User(1, "A"); // 매개변수 2개 리턴타입 1개 BiFunction으로 매칭가능
        BiFunction<Integer, String, User> userCreator = (id, name) -> new User(id, name);
        BiFunction<Integer, String, User> userCreator2 = User::new;
    }

    public static void printUserFields(List<User> users, Function<User, Object> getter) {
        for (User user : users) {
            System.out.println(getter.apply(user));
        }
    }
}
