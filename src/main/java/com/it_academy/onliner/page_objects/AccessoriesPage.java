package com.it_academy.onliner.page_objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;

public class AccessoriesPage extends BasePage {
    private static final ElementsCollection ACCESSORIES_ELEMENTS_XPATH =
            $$x("//*[@class = 'catalog-navigation-list__dropdown-list']//*[@class = 'catalog-navigation-list__dropdown-title']");

    private static final ElementsCollection ACCESSORIES_ELEMENTS_DESCRIPTION_XPATH =
            $$x("//*[@class='catalog-navigation-list__aside-title' " +
                    "and contains(text(),'Комплектующие')]" +
                    "//following-sibling::div[@class='catalog-navigation-list__dropdown']" +
                    "//a//span[contains(@class, 'list__dropdown-description') and contains(text(), 'товар')]");

    public List<String> getListOfAccessoriesElements() {
        List<String> stringOfAllElements = new ArrayList<>();
        ACCESSORIES_ELEMENTS_XPATH.stream().map(SelenideElement::getText).forEach(stringOfAllElements::add);
        return stringOfAllElements.stream().skip(162).limit(13).collect(Collectors.toList());
    }

    public List<String> getDescriptionOfAccessoriesElements() {
        List<String> stringOfAllElements = new ArrayList<>();
        ACCESSORIES_ELEMENTS_DESCRIPTION_XPATH.stream().map(SelenideElement::getText).forEach(stringOfAllElements::add);
        return stringOfAllElements.stream().limit(13).collect(Collectors.toList());
    }
}
