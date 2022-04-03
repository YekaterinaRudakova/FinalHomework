package com.it_academy.onliner_api_tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseAPITest {
    protected static final Logger LOG = LoggerFactory.getLogger(BaseAPITest.class);

    @BeforeAll
    public static void setUpAllureReports() {
        LOG.info("Adding Selenide listener");
        SelenideLogger
                .addListener("AllureSelenide",
                        new AllureSelenide()
                                .includeSelenideSteps(true)
                                .savePageSource(true));
    }
}