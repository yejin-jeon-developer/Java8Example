package yjjeon.example.chapter10;

import yjjeon.example.chapter10.model.Price;
import yjjeon.example.chapter10.service.BasicPriceProcessor;
import yjjeon.example.chapter10.service.DiscountPriceProcessor;
import yjjeon.example.chapter10.service.PriceProcessor;
import yjjeon.example.chapter10.service.TaxPriceProcessor;

public class Chapter10S2  {
    public static void main(String args[]) {
        Price unprocessedPrice = new Price("Original Price");

        PriceProcessor basicPriceProcessor = new BasicPriceProcessor();
        PriceProcessor discountPriceProcessor = new DiscountPriceProcessor();
        PriceProcessor taxPriceProcessor = new TaxPriceProcessor();

        PriceProcessor decoratedPriceProcessor = basicPriceProcessor
                .andThen(discountPriceProcessor)
                .andThen(taxPriceProcessor); // 원하는대로 processor를 추가하여 decoratedProcessor 생성
        // processor가 많아지면 굉장히 Class가 많아짐. -> 람다를 통해서 가능
        Price processedPrice = decoratedPriceProcessor.process(unprocessedPrice);
        System.out.println(processedPrice.getPrice());

        //바로 정의해서 추가하는것도 가능(람다), 하지만 이렇게 하면 재활용이 불가능하고 현재 스코프에서만 사용 가능
        //그렇기 때문에 이 패턴이 잘 쓰일만한지 판단하고 사용해야됨.
        PriceProcessor decoratedPriceProcessor2 = basicPriceProcessor
                .andThen(taxPriceProcessor)
                .andThen(price -> new Price(price.getPrice() + ", then apply another procedure"));
        Price processedPrice2 = decoratedPriceProcessor2.process(unprocessedPrice);
        System.out.println(processedPrice2.getPrice());
    }
}
