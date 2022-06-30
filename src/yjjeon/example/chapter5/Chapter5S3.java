package yjjeon.example.chapter5;

import yjjeon.example.chapter5.model.Car;
import yjjeon.example.chapter5.model.Sedan;
import yjjeon.example.chapter5.model.Suv;
import yjjeon.example.chapter5.model.Van;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Chapter5S3 {
    public static void main(String[] args) {
        //기존 방식은 if(sedan) new Sedan(); 이런 방식. 이런 방식으로 할 경우 차 종류가 많아지면 if/else문이 늘어
        Map<String, BiFunction<String, String, Car>> carTypeToConstructorMap = new HashMap<>();
        carTypeToConstructorMap.put("sedan", Sedan::new);
        carTypeToConstructorMap.put("van", Van::new);
        carTypeToConstructorMap.put("suv", Suv::new);

        String[][] inputs = new String[][] {
                {"sedan", "Sonata", "Hyundai"},
                {"van", "Sienna", "Toyota"},
                {"sedan", "Model S", "Tesla"},
                {"suv", "Sonata", "KIA"}
        };

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < inputs.length; i++) {
            String[] input = inputs[i];
            String carType = input[0];
            String name = input[1];
            String brand = input[2];

            cars.add(carTypeToConstructorMap.get(carType).apply(name, brand));
        }

        for (Car c : cars) {
            c.drive();
        }
    }
}
