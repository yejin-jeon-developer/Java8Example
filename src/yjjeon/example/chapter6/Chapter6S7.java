package yjjeon.example.chapter6;

import yjjeon.example.chapter6.model.Order;
import yjjeon.example.chapter6.model.OrderLine;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter6S7 {
    public static void main(String[] args) {
        String[][] cities = new String[][] {
                {"Seoul", "Busan"},
                {"San Francisco", "New York"},
                {"Madrid", "Barcelona"}
        };

        Stream<String[]> citySteam = Arrays.stream(cities);
        Stream<Stream<String>> cityStreamString = citySteam.map(x -> Arrays.stream(x)); // 스트림안에 스트림 리턴됨
        List<Stream<String>> cityStreamlist = cityStreamString.collect(Collectors.toList()); //Stream이 들어간 List..출력이 안됨

        Stream<String[]> cityStream2 = Arrays.stream(cities);
        Stream<String> flattenedCityStream = cityStream2.flatMap(x -> Arrays.stream(x));
        List<String> flattenedCityList = flattenedCityStream.collect(Collectors.toList());
        System.out.println(flattenedCityList);

        Order order1 = new Order()
                .setId(1001)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10001)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(5000)),
                        new OrderLine()
                                .setId(10002)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(4000))
                ));
        Order order2 = new Order()
                .setId(1002)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10003)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(2000)),
                        new OrderLine()
                                .setId(10004)
                                .setType(OrderLine.OrderLineType.DISCOUNT)
                                .setAmount(BigDecimal.valueOf(-1000))
                ));
        Order order3 = new Order()
                .setId(1003)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10005)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(2000))
                ));

        List<Order> orders = Arrays.asList(order1, order2, order3);
        List<OrderLine> mergedOrderLines = orders.stream() // Stream<Order>
                .map(Order::getOrderLines) //Stream<List<OrderLine>>
                //.map(List::stream) //Stream<Stream<OrderLine>>
                .flatMap(List::stream) // Stream<OrderLine>
                .collect(Collectors.toList());
        System.out.println(mergedOrderLines );
    }
}
