package com.it_academy.onliner.page_objects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ComputersAndNetsPage extends BasePage {
    private static final ElementsCollection COMPUTERS_AND_NETS_ELEMENTS =
            $$x("//*[@class = 'catalog-navigation-list__category' and @data-id='2']" +
                    "//*[@class = 'catalog-navigation-list__aside-item']" +
                    "//*[@class='catalog-navigation-list__aside-title']");
    private static final SelenideElement ACCESSORIES_SECTION =
            $x("//*[contains(@class,'catalog-navigation-list__aside-title')" +
                    " and contains(text(), 'Комплектующие')]");

    private static final int EXPECTED_SIZE = 10;

    @Step("Getting elements from Computers and nets section")
    public List<String> getListOfComputersAndNetsElements() {
        return COMPUTERS_AND_NETS_ELEMENTS.filter(Condition.visible)
        .shouldHave(CollectionCondition.size(EXPECTED_SIZE)).texts();
    }

    @Step("Passing to Accessories Section")
    public AccessoriesPage clickOnAccessoriesSection() {
        waitAndClick(ACCESSORIES_SECTION);
        return new AccessoriesPage();
    }
}
