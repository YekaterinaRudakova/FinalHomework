package com.it_academy.onliner.utils;

import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {
    protected static final Logger LOG = LoggerFactory.getLogger(ScreenshotUtils.class);

    private ScreenshotUtils() {

    }

    public static void takeScreenshotAndAttachToAllureReport() {
        try {
            File screenshotAs = Screenshots.takeScreenShotAsFile();
            Allure.addAttachment("Screenshot", FileUtils.openInputStream(screenshotAs));
        } catch (IOException ex) {
            LOG.error("Error, cannot create screenshot");
        }
    }
}
