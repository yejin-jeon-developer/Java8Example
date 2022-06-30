package yjjeon.example.chapter10.service;

import yjjeon.example.chapter10.model.User;

@FunctionalInterface
public interface EmailProvider {
    String getEmail (User user);
}
