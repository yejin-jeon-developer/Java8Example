package yjjeon.example.chapter6;

import yjjeon.example.chapter6.model.Order;
import yjjeon.example.chapter6.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter6S3 {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(3, 6, -4);
        List<Integer> numberListX2 = numberList.stream()
                .map(x -> x * 2)
                .collect(Collectors.toList());
        System.out.println(numberListX2);

        Stream<Integer> numberListStream = numberList.stream();
        List<String> strList =  numberListStream.map(x -> "Number is " + x)
                .collect(Collectors.toList());
        System.out.println(strList);

        User user1 = new User()
                .setId(101)
                .setName("Ailce")
                .setVerified(true)
                .setEmailAddress("Ailce@naver.com");
        User user2 = new User()
                .setId(102)
                .setName("Bob")
                .setVerified(false)
                .setEmailAddress("Bob@naver.com");
        User user3 = new User()
                .setId(103)
                .setName("Charlie")
                .setVerified(true)
                .setEmailAddress("Charlie@naver.com");

        List<User> users = Arrays.asList(user1, user2, user3);
        List<String> emailList = users.stream()
                .map(User::getEmailAddress )//.map(user -> user.getEmailAddress())
                .collect(Collectors.toList());
        System.out.println(emailList);

        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED)
                .setCreatedByUserId(101);
        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(103);
        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED)
                .setCreatedByUserId(102);
        Order order4 = new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(104);
        Order order5 = new Order()
                .setId(1005)
                .setStatus(Order.OrderStatus.IN_PROGRESS)
                .setCreatedByUserId(101);

        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);
        List<Long> createdUsers = orders.stream()
                .map(Order::getCreatedByUserId )//.map(order -> order.getCreatedByUserId())
                .collect(Collectors.toList());
        System.out.println(createdUsers);
    }
}
