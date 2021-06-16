package com.geo.yml.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Offer {

    String name;
    String url;
    Integer price;
    String currencyId;
    String categoryId;
    boolean delivery;
    @Builder.Default
    List<DeliveryOption> deliveryOptionList = new ArrayList<>();
    String param;
    Double weight;
    String dimensions;

}
