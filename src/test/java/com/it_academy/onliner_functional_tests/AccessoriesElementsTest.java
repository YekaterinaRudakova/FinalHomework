package com.it_academy.onliner_functional_tests;

import com.it_academy.onliner_functional.listeners.AllureWatcher;
import com.it_academy.onliner_functional.page_objects.CatalogPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static com.it_academy.onliner_functional.OnlinerLinks.CATALOG_ONLINER_URL;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@ExtendWith(AllureWatcher.class)
@Epic("Onliner catalog tests")
@Feature("Accessories elements test")
public class AccessoriesElementsTest extends BaseFunctionalTest {

    @Test
    @DisplayName("Presence elements in Accessories section test")
    @Description("Checking that elements under Accessories section present and they are not empty")
    @Severity(SeverityLevel.NORMAL)
    @Story("Getting accessories elements")
    public void testIfElements_PresentInAccessoriesSection() {
        CatalogPage catalogPage = new CatalogPage();
        LOG.info("CatalogPage is created");
        catalogPage.openURL(CATALOG_ONLINER_URL.getLink());
        LOG.info("CATALOG_ONLINER_URL is opened");
        List<String> accessoriesElements = catalogPage
                .clickOnComputersAnsNetsSection("Компьютеры и\u00A0сети")
                .clickOnAccessoriesSection("Комплектующие")
                .getListOfAccessoriesElementsTitles();
        LOG.info("Actual collection of Accessories elements {}", accessoriesElements);
        assertThat(accessoriesElements)
                .as("Accessories elements are empty")
                .allMatch(element -> !element.isEmpty());
    }
}