package com.it_academy.onliner_functional_tests;

import com.it_academy.onliner_functional.listeners.AllureWatcher;
import com.it_academy.onliner_functional.page_objects.OnlinerHomePage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static com.it_academy.onliner_functional.OnlinerLinks.MAIN_ONLINER_URL;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@ExtendWith(AllureWatcher.class)
@Epic("Onliner catalog tests")
@Feature("Catalog elements test")
public class CatalogElementsTest extends BaseFunctionalTest {

    @Test
    @DisplayName("Presence elements in Catalog test")
    @Description("Checking that elements in Catalog section present and they are not empty")
    @Severity(SeverityLevel.NORMAL)
    @Story("Getting catalog elements")
    public void testIfElements_PresentInCatalog() {
        OnlinerHomePage onlinerHomePage = new OnlinerHomePage();
        LOG.info("OnlinerHomePage is created");
        onlinerHomePage.openURL(MAIN_ONLINER_URL.getLink());
        LOG.info("MAIN_ONLINER_URL is opened");
        List<String> catalogElements = onlinerHomePage.clickOnCatalogLink("Каталог")
                .getListOfCatalogElements();
        LOG.info("Actual collection of catalog elements {}", catalogElements);
       assertThat(catalogElements)
                .as("Catalog elements are empty")
                .allMatch(element -> !element.isEmpty());
    }
}