package yjjeon.example.chapter1_4;

import yjjeon.example.chapter1_4.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Chapter4_5 {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User(3, "A"));
        userList.add(new User(1, "B"));
        userList.add(new User(5, "C"));
        System.out.println(userList);

        // ID 순서로 sort해보자
        Comparator<User> idComparator = (u1, u2) -> u1.getId() - u2.getId();
        Collections.sort(userList, idComparator);
        System.out.println(userList);

        // Name 순으로 Sort
        Collections.sort(userList, (u1, u2) -> u1.getName().compareTo(u2.getName()));
        System.out.println(userList);
    }
}
