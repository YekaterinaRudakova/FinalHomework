package com.it_academy.onliner_functional.page_objects;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;


public class CatalogPage extends BasePage {
    private final ElementsCollection catalogElements =
            $$x("//*[@class = 'catalog-navigation-classifier ']" +
                    "//*[@class = 'catalog-navigation-classifier__item ']");
    private static final String CATALOG_CLASSIFIER_LINK_XPATH_PATTERN =
            "//*[contains(@class," +
                    "'catalog-navigation-classifier__item-title-wrapper') " +
                    "and contains(text(), '%s')]";
    private static final int EXPECTED_SIZE_OF_CATALOG_ELEMENTS=10;

    @Step("Getting catalog elements")
    public List<String> getListOfCatalogElements() {
        logger.info("Getting catalog elements");
        return catalogElements.filter(visible)
                .shouldHave(size(EXPECTED_SIZE_OF_CATALOG_ELEMENTS)).texts();
    }

    @Step("Following to Computers and nets link")
    public ComputersAndNetsPage clickOnComputersAnsNetsSection(String link) {
        logger.info("Clicking on catalog classifier link");
        waitAndClick($x(format(CATALOG_CLASSIFIER_LINK_XPATH_PATTERN, link)));
        return new ComputersAndNetsPage();
    }
}