package com.it_academy.onliner.page_objects;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;

public class BasePage {

    @Step("Opening URL")
    public void open(String url) {
        Selenide.open(url);
    }

    @Step("Waiting for element to be clickable ")
    public void waitAndClick(SelenideElement element) {
        element.shouldBe(Condition.enabled).click();
    }

    @Step("Waiting for element to be visible")
    public SelenideElement waitVisibility(SelenideElement element) {
        return element.shouldBe(Condition.visible);
    }

}
