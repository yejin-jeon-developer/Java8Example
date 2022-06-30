package yjjeon.example.chapter7;

import yjjeon.example.chapter7.model.User;

import java.util.Optional;

public class Chapter7S2 {
    public static void main(String[] args) {
        Optional<User> maybeUser = Optional.ofNullable(maybeGetUser(true));
        maybeUser.ifPresent(System.out::println);

        String userName = Optional.ofNullable(maybeGetUser(true))
                .map(User::getId)
                .map(id -> "the id is " + id)
                .orElse("the id is empty"); // 여러개 연결해서 사용 가능

        Optional<Optional<String>> maybeEmail = Optional.ofNullable(maybeGetUser(true))
                .map(User::getEmailAddress);
        Optional<String> maybeEmail2 = Optional.ofNullable(maybeGetUser(true))
                .flatMap(User::getEmailAddress); // 1단계로 줄여줌
        maybeEmail2.ifPresent(System.out::println);
    }

    public static User maybeGetUser(boolean returnUser) {
        if (returnUser) {
            return new User()
                    .setId(1001)
                    .setName("yejin")
                    .setEmailAddress("jeonye@test.co.kr")
                    .setVerified(false);
        }
        return null;
    }
}
