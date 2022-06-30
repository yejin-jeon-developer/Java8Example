package yjjeon.example.chapter8;

import yjjeon.example.chapter6.model.Order;
import yjjeon.example.chapter6.model.OrderLine;
import yjjeon.example.chapter8.model.User;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Chapter8S4 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 4, -5, 2, 3);
         int sum = numbers.stream()
                .reduce((x, y) -> x + y)
                .get();
        System.out.println(sum);

        int min = numbers.stream()
                .reduce((x, y) -> x < y ? x : y).get();
        System.out.println(min);

        int product = numbers.stream()
                .reduce(1, (x, y) -> x * y);
        System.out.println(product);

        List<String> numberStrList = Arrays.asList("3", "2", "5", "-4");
        int sumOfNumberList = numberStrList.stream()
                    .map(Integer::parseInt)
                    .reduce(0, (x, y) -> x + y);
        System.out.println("sumOfNumberList : " + sumOfNumberList);

        //위에 처럼 map, reduce를 따로쓰는게 더 흔하고 밑에꺼는 잘안씀
        int sumOfNumberList2 = numberStrList.stream()
                .reduce(0, (number, str) -> number + Integer.parseInt(str), (num1, num2) -> num1 + num2);
        System.out.println("sumOfNumberList2 : " + sumOfNumberList2);

        User user1 = new User()
                .setId(101)
                .setName("전예진")
                .setVerified(true)
                .setEmailAddress("yjjeon@naver.com")
                .setFriendUserIds(Arrays.asList(201, 202, 203, 204));

        User user2 = new User()
                .setId(102)
                .setName("피카츄")
                .setVerified(false)
                .setEmailAddress("pika@naver.com")
                .setFriendUserIds(Arrays.asList(204, 205, 206));
        User user3 = new User()
                .setId(103)
                .setName("파이리")
                .setVerified(false)
                .setEmailAddress("fire@naver.com")
                .setFriendUserIds(Arrays.asList(204, 205, 207 ));
        List<User> users = Arrays.asList(user1, user2, user3);

        int sumOfNumberOfFriends = users.stream()
                //.map(u -> u.getFriendUserIds().size())
                .map(User::getFriendUserIds)
                .map(List::size)
                .reduce(0, (x, y) -> x + y);
        System.out.println("sumOfNumberOfFriends : " + sumOfNumberOfFriends);

        Order order1 = new Order()
                .setId(1001L)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(2000))));
        Order order2 = new Order()
                .setId(1002L)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(2000)),
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(3000))));
        Order order3 = new Order()
                .setId(1002L)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(2000))));
        List<Order> orders = Arrays.asList(order1, order2, order3);

        //find the sum of amount;
        BigDecimal sumOfAmount = orders.stream()
                .map(Order::getOrderLines)
                .flatMap(List::stream)
                .map(OrderLine::getAmount)
                .reduce(BigDecimal.ZERO, (x, y) -> x.add(y));
        System.out.println(sumOfAmount);
    }
}
