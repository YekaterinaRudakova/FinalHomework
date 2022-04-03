package com.it_academy.onliner_functional.page_objects;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.it_academy.onliner_functional.constants.TimeoutConstants.GENERAL_TIMEOUT;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class AccessoriesPage extends BasePage {
    private final ElementsCollection accessoriesTitles =
            $$x("//*[@class='catalog-navigation-list__aside-item " +
                    "catalog-navigation-list__aside-item_active']" +
                    "//*[@class = 'catalog-navigation-list__dropdown-list']" +
                    "//*[@class = 'catalog-navigation-list__dropdown-title']");

    private static final String ACCESSORIES_ELEMENTS_DESCRIPTION_XPATH_PATTERN =
            "//*[@class='catalog-navigation-list__aside-item " +
                    "catalog-navigation-list__aside-item_active']" +
                    "//*[@class='catalog-navigation-list__aside-title' and contains(text(),'%s')]" +
                    "//following-sibling::div[@class='catalog-navigation-list__dropdown']" +
                    "//a//span[contains(@class, 'list__dropdown-description') and contains(text(), '%s')]";

    private static final int EXPECTED_SIZE_OF_ACCESSORIES_ELEMENTS = 13;

    @Step("Getting elements titles from Accessories section")
    public List<String> getListOfAccessoriesElementsTitles() {
        logger.info("Getting elements titles from Accessories section");
        return accessoriesTitles.filter(visible).
                shouldHave(size(EXPECTED_SIZE_OF_ACCESSORIES_ELEMENTS), ofSeconds(GENERAL_TIMEOUT)).texts();
    }

    @Step("Getting description of elements from Accessories section")
    public List<String> getDescriptionOfAccessoriesElements(String link, String goodsDescription) {
        logger.info("Getting description of elements from Accessories section");
        return $$x(format((ACCESSORIES_ELEMENTS_DESCRIPTION_XPATH_PATTERN), link, goodsDescription))
                .filter(visible).shouldHave(size(EXPECTED_SIZE_OF_ACCESSORIES_ELEMENTS),
                        ofSeconds(GENERAL_TIMEOUT)).texts();
    }
}