package com.it_academy.onliner.listeners;

import com.it_academy.onliner.utils.ScreenshotUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class AllureWatcher implements TestWatcher{
    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        ScreenshotUtils.takeScreenshotAndAttachToAllureReport();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        ScreenshotUtils.takeScreenshotAndAttachToAllureReport();
    }
}
