package yjjeon.example.chapter10.service;

import yjjeon.example.chapter10.model.User;

public class VerifyYourEmailAdressEmailProvider implements EmailProvider {
    @Override
    public String getEmail(User user) {
        return "'Verify your email adress' email for " + user.getName();
    }
}
