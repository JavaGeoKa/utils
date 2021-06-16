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
public class Shop {

    private String name;
    private String company;
    private String url;
    @Builder.Default
    List<Currencie> currencies = new ArrayList<>();
    @Builder.Default
    List<Category> categories = new ArrayList<>();
    @Builder.Default
    List<DeliveryOption> deliveryOptions = new ArrayList<>();
    @Builder.Default
    List<Offer> offers = new ArrayList<>();
    @Builder.Default
    List<Gift> gifts = new ArrayList<>();
    @Builder.Default
    List<Promo> promos = new ArrayList<>();



}
