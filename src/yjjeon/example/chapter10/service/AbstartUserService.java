package yjjeon.example.chapter10.service;

import yjjeon.example.chapter10.model.User;

public abstract class AbstartUserService {
    protected abstract boolean vaildateUser(User user);
    protected abstract void writeToDB(User user);
    public void createUser(User user) {
        if (vaildateUser(user)) {
            writeToDB(user);
        } else {
            System.out.println("Cannot create user");
        }

    }
}
