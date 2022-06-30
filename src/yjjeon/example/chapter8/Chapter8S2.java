package yjjeon.example.chapter8;

import yjjeon.example.chapter6.model.Order;
import yjjeon.example.chapter8.model.User;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Chapter8S2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, -4, 2, 7, 9);

        boolean allPositive = numbers.stream()
                .allMatch(number -> number > 0);
        System.out.println("allPositive : " + allPositive);

        boolean anyNegative = numbers.stream()
                .anyMatch(number -> number < 0);
        System.out.println("anyNegative : " + anyNegative);

        User user1 = new User()
                .setId(101)
                .setName("전예진")
                .setVerified(true)
                .setEmailAddress("yjjeon@naver.com");
        User user2 = new User()
                .setId(102)
                .setName("피카츄")
                .setVerified(false)
                .setEmailAddress("pika@naver.com");
        User user3 = new User()
                .setId(103)
                .setName("파이리")
                .setVerified(false)
                .setEmailAddress("fire@naver.com");
        List<User> users = Arrays.asList(user1, user2, user3);

        boolean allUserVerified = users.stream()
                .allMatch(user -> user.isVerified());
        System.out.println("allUserVerified : " + allUserVerified);

        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED)
                .setCreatedByUserId(101)
                .setAmount(BigDecimal.valueOf(1000));
        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(103)
                .setAmount(BigDecimal.valueOf(4000));
        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED)
                .setCreatedByUserId(102)
                .setAmount(BigDecimal.valueOf(3000));
        Order order4 = new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(104)
                .setAmount(BigDecimal.valueOf(2000));
        Order order5 = new Order()
                .setId(1005)
                .setStatus(Order.OrderStatus.IN_PROGRESS)
                .setCreatedByUserId(101)
                .setAmount(BigDecimal.valueOf(5000));
        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);

        boolean isAnyErrorOrder = orders.stream()
                .anyMatch(order -> order.getStatus() == Order.OrderStatus.ERROR);
        System.out.println("anyErrorOrder : " +  isAnyErrorOrder);
    }
}
