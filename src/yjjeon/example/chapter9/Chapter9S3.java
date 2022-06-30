package yjjeon.example.chapter9;

import yjjeon.example.chapter9.model.Order;
import yjjeon.example.chapter9.model.OrderLine;
import yjjeon.example.chapter9.priceprocessor.OrderLineAggregationPriceProcessor;
import yjjeon.example.chapter9.priceprocessor.TaxPriceProcessor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Chapter9S3 {
    public static void main(String[] args) {
        Function<Integer, Integer> multiplyByTwo = x -> 2 * x;
        Function<Integer, Integer> addTen = x -> 10 + x;

        Function<Integer, Integer> composedFunction = multiplyByTwo.andThen(addTen);
        System.out.println(composedFunction.apply(2)); // 2 곱하고 10 더함

        Order unprocessedOrder = new Order()
                .setId(1001L)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(2000))));
        List<Function<Order, Order>> priceProcessors = getPriceProcessors(unprocessedOrder);

        Function<Order, Order> mergedPriceProcessor = priceProcessors.stream()
                .reduce(Function.identity(),Function::andThen); // 아래와 동일
                //.reduce(Function.identity(),(priceProcessor1, priceProcessor2) -> priceProcessor1.andThen(priceProcessor2));
        Order processedOrder = mergedPriceProcessor.apply(unprocessedOrder);
        System.out.println(processedOrder);
    }

    public static List<Function<Order, Order>> getPriceProcessors(Order order) {
        //실제로는 매개변수 order의 성질에 따라 다른 PriceProcessors 리턴
        return Arrays.asList(new OrderLineAggregationPriceProcessor(),
                new TaxPriceProcessor(new BigDecimal(9.375)));
    }
}
