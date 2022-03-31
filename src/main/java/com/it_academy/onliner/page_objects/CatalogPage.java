package com.it_academy.onliner.page_objects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CatalogPage extends BasePage {
    private static final ElementsCollection CATALOG_ELEMENTS =
            $$x("//*[@class = 'catalog-navigation-classifier ']" +
                    "//*[@class = 'catalog-navigation-classifier__item ']");
    public static final SelenideElement COMPUTERS_AND_NETS_SECTION =
            $x("//*[contains(@class," +
                    "'catalog-navigation-classifier__item-title-wrapper') " +
                    "and contains(text(), 'Компьютеры и\u00A0сети')]");

    private static final int EXPECTED_SIZE=10;

    @Step("Getting catalog elements")
    public List<String> getListOfCatalogElements() {
        return CATALOG_ELEMENTS.filter(Condition.visible)
                .shouldHave(CollectionCondition.size(EXPECTED_SIZE)).texts();
    }

    @Step("Passing to Computers and nets section ")
    public ComputersAndNetsPage clickOnComputersAnsNetsSection() {
        waitAndClick(COMPUTERS_AND_NETS_SECTION);
        return new ComputersAndNetsPage();
    }
}
