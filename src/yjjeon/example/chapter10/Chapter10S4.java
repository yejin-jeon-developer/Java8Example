package yjjeon.example.chapter10;

import yjjeon.example.chapter10.model.User;
import yjjeon.example.chapter10.service.InternalUserService;
import yjjeon.example.chapter10.service.UserService;
import yjjeon.example.chapter10.service.UserServiceInFunctionalWay;

import java.util.Arrays;

public class Chapter10S4 {
    public static void main(String args[]) {
        User user1 = User.builder(1, "Alice")
                .with(builder -> {
                    builder.emailAddress = "alice@test.co.kr";
                    builder.isVerified = false;
                    builder.friendUserIds = Arrays.asList(201, 202, 203, 204, 211, 212, 213, 214);
                }).build();

        UserService userService = new UserService();
        InternalUserService internalUserService = new InternalUserService();

        userService.createUser(user1);
        internalUserService.createUser(user1);

        UserServiceInFunctionalWay userServiceInFunctionalWay
                = new UserServiceInFunctionalWay(user -> {
                        System.out.println("Validating User in functional way");
                        return user.getEmailAddress().isPresent() && user.getName() != null;
                    },
                    user -> System.out.println("Write user " + user.getName() + " to DB"));

        userServiceInFunctionalWay.createUser(user1);
    }
}
