package com.it_academy.onliner_test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {
    protected static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    private static void setUpBrowser() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.screenshots = false;
        Configuration.pageLoadTimeout=7000;
        Configuration.timeout=7000;
        Configuration.browserSize = "1792x1120";
        Configuration.pageLoadStrategy="normal";
    }

    @BeforeAll
    public static void init() {
        setUpBrowser();
    }

    @BeforeAll
    public static void setUpAllureReports() {
        SelenideLogger
                .addListener("AllureSelenide",
                        new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @AfterAll
    @Step("Close WebDriver")
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}
