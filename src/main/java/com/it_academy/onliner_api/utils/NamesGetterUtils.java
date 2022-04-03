package com.it_academy.onliner_api.utils;

import com.it_academy.onliner_api.models.Product;
import com.it_academy.onliner_api.models.Sauce;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

public class NamesGetterUtils {

    private NamesGetterUtils() {
    }

    @Step("Getting products names")
    public static List<String> getProductNames(List<Product> products) {
        List<String> productNames = new ArrayList<>();
        products.stream()
                .map(Product::getName)
                .forEach(productNames::add);
        return productNames;
    }

    @Step("Getting prefixes names")
    public static List<String> getPrefixNames(List<Sauce> sauces) {
        List<String> prefixNames = new ArrayList<>();
        sauces.stream()
                .map(Sauce::getName_prefix)
                .forEach(prefixNames::add);
        return prefixNames;
    }
}