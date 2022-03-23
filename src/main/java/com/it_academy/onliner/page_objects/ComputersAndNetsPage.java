package com.it_academy.onliner.page_objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ComputersAndNetsPage extends BasePage {
    private static final ElementsCollection COMPUTERS_AND_NETS_ELEMENTS_XPATH_PATTERN =
            $$x("//*[@class='catalog-navigation-list__aside-list']//*[@class='catalog-navigation-list__aside-title']");
    public static final SelenideElement ACCESSORIES_SECTION_XPATH_PATTERN =
            $x("//*[contains(@class,'catalog-navigation-list__aside-title') and contains(text(), 'Комплектующие')]");

    public List<String> getListOfComputersAndNetsElements() {
        List<String> stringOfAllElements = new ArrayList<>();
        COMPUTERS_AND_NETS_ELEMENTS_XPATH_PATTERN.stream().map(SelenideElement::getText).forEach(stringOfAllElements::add);
        return stringOfAllElements.stream().skip(13).limit(10).collect(Collectors.toList());
    }

    public AccessoriesPage clickOnAccessoriesSection() {
        waitAndClick(ACCESSORIES_SECTION_XPATH_PATTERN);
        return new AccessoriesPage();
    }
}
