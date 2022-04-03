package com.it_academy.onliner_functional.page_objects;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class ComputersAndNetsPage extends BasePage {
    private final ElementsCollection computersAndNetsElements =
            $$x("//*[@class = 'catalog-navigation-list__category' and @data-id='2']" +
                    "//*[@class = 'catalog-navigation-list__aside-item']" +
                    "//*[@class='catalog-navigation-list__aside-title']");
    private static final String COMPUTERS_AND_NETS_CLASSIFIER_LINK_XPATH_PATTERN =
            "//*[contains(@class,'catalog-navigation-list__aside-title')" +
                    " and contains(text(), '%s')]";
    private static final int EXPECTED_SIZE_OF_COMPUTERS_AND_NETS_ELEMENTS = 10;

    @Step("Getting elements from Computers and nets section")
    public List<String> getListOfComputersAndNetsElements() {
        logger.info("Getting elements from Computers and nets section");
        return computersAndNetsElements.filter(visible)
        .shouldHave(size(EXPECTED_SIZE_OF_COMPUTERS_AND_NETS_ELEMENTS)).texts();
    }

    @Step("Following to Accessories link")
    public AccessoriesPage clickOnAccessoriesSection(String link) {
        logger.info("Clicking on computers and nets classifier link");
        waitAndClick($x(format(COMPUTERS_AND_NETS_CLASSIFIER_LINK_XPATH_PATTERN, link)));
        return new AccessoriesPage();
    }
}