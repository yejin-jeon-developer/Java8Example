package yjjeon.example.chapter8;

import yjjeon.example.chapter6.model.Order;
import yjjeon.example.chapter8.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Chapter8S1 {
    public static void main(String[] args) {
        Optional<Integer> min = Stream.of(5, 3, 1, 43, 2).min((x, y) -> x - y);
        System.out.println(min.get());
        
        Stream.of(5, 3, 1, 43, 2).max(Comparator.naturalOrder())
                .ifPresent(System.out::println);

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

        users.stream().min((u1, u2) -> u1.getName().compareTo(u2.getName()))
                .map(User::getName)
                .ifPresent(System.out::println);

        long positiveIntegerCount = Stream.of(1, -4, 5, -3, 6)
                .filter(n -> n > 0)
                .count();
        System.out.println(positiveIntegerCount);

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        user1.setCreatedAt(now.minusDays(2));
        user2.setCreatedAt(now.minusHours(10));
        user3.setCreatedAt(now.minusHours(1));
        User user4 = new User()
                .setId(104)
                .setName("파이리")
                .setVerified(false)
                .setEmailAddress("fire@naver.com")
                .setCreatedAt(now.minusHours(27));
        users = Arrays.asList(user1, user2, user3, user4);

        long unVeriedUsersIn24hrs = users.stream()
                .filter(u -> u.getCreatedAt().isAfter(now.minusHours(24)))
                .filter(u -> !u.isVerified())
                .count();
        System.out.println(unVeriedUsersIn24hrs);

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

        BigDecimal maxErrorAmount = orders.stream()
                        .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                        .map(Order::getAmount)
                        .max(BigDecimal::compareTo)
                        .orElse(BigDecimal.ZERO);
        System.out.println("maxErrorAmount : " + maxErrorAmount);



        Stream.of(order1, order2, order3, order4, order5)
                .filter(o -> o.getStatus() == Order.OrderStatus.ERROR)
                .max((o1, o2) -> o1.getAmount().compareTo(o2.getAmount()))
                .ifPresent(System.out::println);

    }
}
