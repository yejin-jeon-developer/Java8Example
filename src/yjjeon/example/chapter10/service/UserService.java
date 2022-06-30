package yjjeon.example.chapter10.service;

import yjjeon.example.chapter10.model.User;

public class UserService extends AbstartUserService{
    @Override
    protected boolean vaildateUser(User user) {
        System.out.println("Validating user " + user.getName());
        return user.getName() != null && user.getEmailAddress().isPresent();
    }

    @Override
    protected void writeToDB(User user) {
        System.out.println("Writing User " + user.getName() + " to DB");
    }
}
