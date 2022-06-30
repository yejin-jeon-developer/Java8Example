package yjjeon.example.chapter8;

import yjjeon.example.chapter8.model.User;

public class EmailService {
    public void sendPlayWithFriendsEmail(User user) {
        user.getEmailAddress().ifPresent(email -> System.out.println("Sending 'Play with Friends' email to " + email));
    }

    public void sendMoreFriendsEmail(User user) {
        user.getEmailAddress().ifPresent(email -> System.out.println("Sending 'More Friends' email to " + email));
    }

    public void verifyYourEmailEmail(User user) {
         user.getEmailAddress().ifPresent(email -> System.out.println("Sending 'Verify your Email' to " + email));
    }
}
