package yjjeon.example.chapter8;

import yjjeon.example.chapter8.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Chapter8S9 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 2, 1);
        numbers.stream().forEach(number -> System.out.println("This number is " + number));
        numbers.forEach(number -> System.out.println("This number is " + number)); //iterable 일경우 바로 사용 가능

        EmailService emailService = new EmailService();
        User user1 = new User()
                .setId(101)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("alice@test.co.kr");
        User user2 = new User()
                .setId(102)
                .setName("Bob")
                .setVerified(false)
                .setEmailAddress("bob@test.co.kr");
        User user3 = new User()
                .setId(103)
                .setName("Charlie")
                .setVerified(false)
                .setEmailAddress("charlie@test.co.kr");
        List<User> users = Arrays.asList(user1, user2, user3);

        users.stream().filter(user -> !user.isVerified())
                .forEach(emailService::verifyYourEmailEmail);

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            System.out.println(user);
        }
        //index 사용 for loop 대체
        IntStream.range(0, users.size()).forEach(i -> {
            User user = users.get(i);
            System.out.println(user);
        });
    }
}
