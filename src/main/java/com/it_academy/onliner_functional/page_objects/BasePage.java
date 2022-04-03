package com.it_academy.onliner_functional.page_objects;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public abstract class BasePage {
    protected final Logger logger;

    public BasePage(){
        logger = LoggerFactory.getLogger(this.getClass());
        logger.info("Creating instance");
    }

    @Step("Opening URL")
    public void openURL(String url) {
        logger.info("Opening URL: {}", url);
        open(url);
    }

    @Step("Waiting for element to be clickable ")
    public void waitAndClick(SelenideElement element) {
        element.shouldBe(enabled).click();
    }

    @Step("Waiting for element to be visible")
    public SelenideElement waitVisibility(SelenideElement element) {
        return element.shouldBe(visible);
    }
}