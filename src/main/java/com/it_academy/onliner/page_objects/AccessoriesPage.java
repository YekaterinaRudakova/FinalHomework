package com.it_academy.onliner.page_objects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

public class AccessoriesPage extends BasePage {
    private static final ElementsCollection ACCESSORIES_TITLES =
            $$x("//*[@class='catalog-navigation-list__aside-item " +
                    "catalog-navigation-list__aside-item_active']" +
                    "//*[@class = 'catalog-navigation-list__dropdown-list']" +
                    "//*[@class = 'catalog-navigation-list__dropdown-title']");

    private static final ElementsCollection ACCESSORIES_ELEMENTS_DESCRIPTION =
            $$x("//*[@class='catalog-navigation-list__aside-item " +
                    "catalog-navigation-list__aside-item_active']" +
                    "//*[@class='catalog-navigation-list__aside-title' and contains(text(),'Комплектующие')]" +
                    "//following-sibling::div[@class='catalog-navigation-list__dropdown']" +
                    "//a//span[contains(@class, 'list__dropdown-description') and contains(text(), 'товар')]");

    private static final int EXPECTED_SIZE=13;

    @Step("Getting elements titles from Accessories section")
    public List<String> getListOfAccessoriesElementsTitles() {
        return ACCESSORIES_TITLES.filter(Condition.visible).
                shouldHave(CollectionCondition.size(EXPECTED_SIZE)).texts();
    }

    @Step("Getting description of elements from Accessories section")
    public List<String> getDescriptionOfAccessoriesElements() {
        return ACCESSORIES_ELEMENTS_DESCRIPTION
                .filter(Condition.visible).shouldHave(CollectionCondition.size(EXPECTED_SIZE)).texts();
    }
}

