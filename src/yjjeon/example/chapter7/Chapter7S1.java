package yjjeon.example.chapter7;

import yjjeon.example.chapter7.model.User;

import java.util.Optional;

public class Chapter7S1 {
    public static void main(String[] args) {
        User user1 = new User()
                .setId(1001)
                .setName("Alice")
                .setVerified(false);
        User user2 = new User()
                .setId(1001)
                .setName("Alice")
                .setEmailAddress("Alice@naver.com")
                .setVerified(false);
        System.out.println(userEquals(user2, user1)); // user2부터 넣으면 에러 안나지만 user1 부터 넣으면 NPE 발생

        String someEmail = "some@email.com";
        String nullEmail = null;

        Optional<String> maybeEmail = Optional.of(someEmail);
        Optional<String> maybeEmail2 = Optional.empty();
        Optional<String> maybeEmail3 = Optional.ofNullable(someEmail);
        Optional<String> maybeEmail4 = Optional.ofNullable(nullEmail);

        String email = maybeEmail.get();
        System.out.println(email);
        // String email2 = maybeEmail2.get(); // NoSuchElementException
        if (maybeEmail2.isPresent()) {
            String email2 = maybeEmail2.get();
        }

        String defaultEmail = "default@email.com";
        String email3 = maybeEmail2.orElse(defaultEmail);
        System.out.println(email3);
        String email4 = maybeEmail2.orElseGet(() -> defaultEmail);
        System.out.println(email4);
        String email5 = maybeEmail2.orElseThrow(() -> new RuntimeException("email is not present"));
    }

    public static boolean userEquals(User u1, User u2) {
        return u1.getId() == u2.getId()
                && u1.getName().equals(u2.getName())
                && u1.getEmailAddress().equals(u2.getEmailAddress())
                && u1.isVerified() == u2.isVerified();
    }
}
