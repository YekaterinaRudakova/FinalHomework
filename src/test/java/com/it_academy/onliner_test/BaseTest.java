package com.it_academy.onliner_test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    private static void setUp() {
      Configuration.browser="chrome";
        Configuration.headless = false;
        Configuration.screenshots = false;
        Configuration.timeout = 5000;
        Configuration.browserSize = "1536x960";
    }

    @BeforeAll
    public static void init() {
        setUp();
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }

    public static void clearAndRefresh() {
        Selenide.localStorage().clear();
        Selenide.refresh();
    }
}
