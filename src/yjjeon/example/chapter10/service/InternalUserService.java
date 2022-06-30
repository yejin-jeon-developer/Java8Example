package yjjeon.example.chapter10.service;

import yjjeon.example.chapter10.model.User;

public class InternalUserService extends AbstartUserService {
    @Override
    protected boolean vaildateUser(User user) {
        System.out.println("validating internal user " + user.getName());
        return true;
    }

    @Override
    protected void writeToDB(User user) {
        System.out.println("Writing user " + user.getName() + " to internal  DB");
    }
}
