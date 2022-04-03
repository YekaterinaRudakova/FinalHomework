package com.it_academy.onliner_functional_tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.it_academy.onliner_functional.ConfigFileReader;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseFunctionalTest {
    protected static final Logger LOG = LoggerFactory.getLogger(BaseFunctionalTest.class);

    private static void setUpBrowser() {
        Configuration.remote = ConfigFileReader
               .readConfigurationStringProperties("REMOTE");
        Configuration.headless = ConfigFileReader
                .readConfigurationBooleanProperties("HEADLESS");
        Configuration.screenshots = ConfigFileReader
                .readConfigurationBooleanProperties("SCREENSHOTS");
        Configuration.pageLoadTimeout = ConfigFileReader
                .readConfigurationIntegerProperties("PAGE_LOAD_TIMEOUT");
        Configuration.timeout = ConfigFileReader
                .readConfigurationIntegerProperties("TIMEOUT");
        Configuration.browserSize = ConfigFileReader
                .readConfigurationStringProperties("BROWSER_SIZE");
        Configuration.browserPosition = ConfigFileReader
                .readConfigurationStringProperties("BROWSER_POSITION");
        Configuration.pageLoadStrategy = ConfigFileReader
                .readConfigurationStringProperties("PAGE_LOAD_STRATEGY");

        LOG.info("Configuration.remote: {}", Configuration.remote);
        LOG.info("Configuration.headless: {}", Configuration.headless);
        LOG.info("Configuration.screenshots: {}", Configuration.screenshots);
        LOG.info("Configuration.pageLoadTimeout: {}", Configuration.pageLoadTimeout);
        LOG.info("Configuration.timeout: {}", Configuration.timeout);
        LOG.info("Configuration.browserSize: {}", Configuration.browserSize);
        LOG.info("Configuration.browserPosition: {}", Configuration.browserPosition);
        LOG.info("Configuration.pageLoadStrategy: {}", Configuration.pageLoadStrategy);
    }

    @BeforeAll
    public static void init() {
        LOG.info("Browser is initializing...");
        setUpBrowser();
        LOG.info("Browser is initialized");
    }

    @BeforeAll
    public static void setUpAllureReports() {
        LOG.info("Adding Selenide listener");
        SelenideLogger
                .addListener("AllureSelenide",
                        new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @AfterAll
    @Step("Close WebDriver")
    public static void tearDown() {
        LOG.info("Browser is closing");
        closeWebDriver();
        LOG.info("Browser is closed");
    }
}