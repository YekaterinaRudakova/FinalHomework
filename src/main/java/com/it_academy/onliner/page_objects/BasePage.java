package com.it_academy.onliner.page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class BasePage {
    public void open(String url) {
        Selenide.open(url);
    }

    public void waitAndClick(SelenideElement element) {
        element.shouldBe(Condition.enabled).click();
    }

    public SelenideElement waitVisibility(SelenideElement element) {
        return element.shouldBe(Condition.visible);
    }
}
