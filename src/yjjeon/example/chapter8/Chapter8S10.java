package yjjeon.example.chapter8;

import yjjeon.example.chapter8.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Chapter8S10 {
    public static void main(String[] args) {
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
        User user4 = new User()
                .setId(104)
                .setName("David")
                .setVerified(true)
                .setEmailAddress("david@test.co.kr");
        User user5 = new User()
                .setId(105)
                .setName("Eve")
                .setVerified(false)
                .setEmailAddress("eve@test.co.kr");
        User user6 = new User()
                .setId(106)
                .setName("Frank")
                .setVerified(false)
                .setEmailAddress("frank@test.co.kr");
        List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6);

        long startTime = System.currentTimeMillis();
        users.stream()
                .filter(user -> !user.isVerified())
                .forEach(emailService::verifyYourEmailEmail);
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential : " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        users.stream().parallel()
                .filter(user -> !user.isVerified())
                .forEach(emailService::verifyYourEmailEmail);
        endTime = System.currentTimeMillis();
        System.out.println("Parallel : " + (endTime - startTime) + "ms");

        //중간처리는 순서가 뒤죽박죽. 하지만 종결처리 과정에서 순서 맞춰줌
        //중간처리가 순서에 민감한 작업이면 병렬처리 사용 X
        List<User> processedUser = users.parallelStream()
                .map(user -> {
                    System.out.println("Capitalize user name for user : " + user.getId());
                    user.setName(user.getName().toUpperCase());
                    return user;
                })
                .map(user -> {
                    System.out.println("Set 'isVerified' to true for user : " + user.getId());
                    user.setVerified(true);
                    return user;
                })
                .collect(Collectors.toList());
        System.out.println(processedUser);
    }
}
