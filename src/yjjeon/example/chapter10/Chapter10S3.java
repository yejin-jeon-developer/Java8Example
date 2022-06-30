package yjjeon.example.chapter10;

import yjjeon.example.chapter10.model.User;
import yjjeon.example.chapter10.service.EmailProvider;
import yjjeon.example.chapter10.service.EmailSender;
import yjjeon.example.chapter10.service.MakeMoreFriendsEmailProvider;
import yjjeon.example.chapter10.service.VerifyYourEmailAdressEmailProvider;

import java.util.Arrays;
import java.util.List;

public class Chapter10S3 {
    public static void main(String args[]) {
        User user1 = User.builder(1, "Alice")
                .with(builder -> {
                    builder.emailAddress = "alice@test.co.kr";
                    builder.isVerified = false;
                    builder.friendUserIds = Arrays.asList(201, 202, 203, 204, 211, 212, 213, 214);
                }).build();
        User user2 = User.builder(2, "Bob")
                .with(builder -> {
                    builder.emailAddress = "bob@test.co.kr";
                    builder.isVerified = true;
                    builder.friendUserIds = Arrays.asList(212, 213, 214);
                }).build();
        User user3 = User.builder(3, "Charlie")
                .with(builder -> {
                    builder.emailAddress = "charlie@test.co.kr";
                    builder.isVerified = true;
                    builder.friendUserIds = Arrays.asList(201, 202, 203, 204, 211, 212);
                }).build();
        List<User> users = Arrays.asList(user1, user2, user3);

        EmailSender emailSender = new EmailSender();
        EmailProvider verifyYourEmailAdressEmailProvider = new VerifyYourEmailAdressEmailProvider();
        EmailProvider makeMoreFriendsEmailProvider = new MakeMoreFriendsEmailProvider();

        emailSender.setEmailProvider(verifyYourEmailAdressEmailProvider);
        users.stream()
                .filter(user -> !user.isVerified())
                .forEach(emailSender::sendEmail);

        emailSender.setEmailProvider(makeMoreFriendsEmailProvider);
        users.stream()
                .filter(User::isVerified)
                .filter(user -> user.getFriendUserIds().size() < 5)
                .forEach(emailSender::sendEmail);

        emailSender.setEmailProvider(user -> "'Play with Friends' email for " + user.getName());
        users.stream()
                .filter(User::isVerified)
                .filter(user -> user.getFriendUserIds().size() >= 5)
                .forEach(emailSender::sendEmail);
    }
}
