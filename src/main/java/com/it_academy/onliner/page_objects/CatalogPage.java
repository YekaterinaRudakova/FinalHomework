package com.it_academy.onliner.page_objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CatalogPage extends BasePage {
    private static final ElementsCollection CATALOG_LIST_OF_ELEMENTS =
            $$x("//*[@class = 'catalog-navigation-classifier ']//*[@class = 'catalog-navigation-classifier__item ']");
    public static final SelenideElement COMPUTERS_AND_NETS_SECTION =
            $x("//*[contains(@class," +
                    "'catalog-navigation-classifier__item-title-wrapper') " +
                    "and contains(text(), 'Компьютеры и\u00A0сети')]");

    public List<String> getListOfCatalogElements() {
        List<String> catalogElementsTitles = new ArrayList<>();
        CATALOG_LIST_OF_ELEMENTS.stream().map(SelenideElement::getText).forEach(catalogElementsTitles::add);
        return catalogElementsTitles;
    }

    public ComputersAndNetsPage clickOnComputersAnsNetsSection() {
        waitAndClick(COMPUTERS_AND_NETS_SECTION);
        return new ComputersAndNetsPage();
    }
}
