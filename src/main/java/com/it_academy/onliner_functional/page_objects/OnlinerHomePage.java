package com.it_academy.onliner_functional.page_objects;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class OnlinerHomePage extends BasePage {
    private static final String MAIN_NAVIGATION_LINK_XPATH_PATTERN = "//*[contains(@class, " +
            "'b-main-page-blocks-header-2 cfix')]//a[contains(text(), '%s')]";

    @Step("Following to Catalog link")
    public CatalogPage clickOnCatalogLink(String link) {
        logger.info("Clicking on main navigation link");
        waitAndClick($x(format(MAIN_NAVIGATION_LINK_XPATH_PATTERN, link)));
        return new CatalogPage();
    }
}