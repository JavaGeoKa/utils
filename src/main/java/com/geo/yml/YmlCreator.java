package com.geo.yml;

import com.geo.yml.model.*;
import com.thoughtworks.xstream.XStream;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;

public class YmlCreator {

    @Value("${app.yml.outputfolder}")private String outputFolder;

    private String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";


    public static void main(String[] args) {

        System.out.println("begin create -> ");

        Shop shop = Shop.builder()
                .name("testShop")
                .company("Realtrade")
                .url("http://rtrade.shop")
                .currencies(Arrays.asList(Currencie.builder()
                        .id("RUR")
                        .rate(1)
                        .build()))
                .categories(Arrays.asList(Category.builder()
                        .name("Cryptocurrencies")
                        .build()))
                .deliveryOptions(Arrays.asList(DeliveryOption.builder()
                        .cost(89)
                        .id(1)
                        .build()))
                .offers(Arrays.asList(Offer.builder()
                        .name("BTC")
                        .build(), Offer.builder()
                        .name("ETH")
                        .build()))
                 .gifts(Arrays.asList(Gift.builder()
                         .name("XMR")
                         .build()))
                .promos(Arrays.asList(Promo.builder()
                        .name("promo")
                        .build()))

                .build();

        System.out.println(shop);
        XStream xstream = new XStream();
        String xml = xstream.toXML(shop);
        System.out.println(xml);





    }
}
