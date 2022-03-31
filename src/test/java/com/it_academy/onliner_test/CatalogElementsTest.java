package com.it_academy.onliner_test;

import com.it_academy.onliner.OnlinerLinks;
import com.it_academy.onliner.listeners.AllureWatcher;
import com.it_academy.onliner.page_objects.OnlinerHomePage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@ExtendWith(AllureWatcher.class)
@Epic("Onliner tests")
@Feature("Catalog elements")
public class CatalogElementsTest extends BaseTest {

    @Test
    @DisplayName("Presence elements in Catalog test")
    @Description("Checking that elements in Catalog section present and they are not empty")
    @Severity(SeverityLevel.NORMAL)
    @Story("Getting catalog elements")
    public void testIfElements_PresentInCatalog() {
        OnlinerHomePage onlinerHomePage = new OnlinerHomePage();
        onlinerHomePage.open(OnlinerLinks.MAIN_ONLINER_URL.getLink());
        List<String> catalogElements = onlinerHomePage.clickOnCatalogLink()
                .getListOfCatalogElements();
        log.info("Actual collection of catalog elements {}", catalogElements);
        assertThat(catalogElements)
                .as("Catalog elements are empty")
                .allMatch(element -> !element.isEmpty());
    }
}
