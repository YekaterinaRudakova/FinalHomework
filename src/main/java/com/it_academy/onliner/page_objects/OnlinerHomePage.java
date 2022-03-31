package com.it_academy.onliner.page_objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class OnlinerHomePage extends BasePage {
    private static final SelenideElement CATALOG_LINK = $x("//*[contains(@class, " +
            "'b-main-page-blocks-header-2 cfix')]//a[contains(text(), 'Каталог')]");

    @Step("Passing to Catalog")
    public CatalogPage clickOnCatalogLink() {
        waitAndClick(CATALOG_LINK);
        return new CatalogPage();
    }
}
