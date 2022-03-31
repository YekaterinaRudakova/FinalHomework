package com.it_academy.onliner_test;

import com.it_academy.onliner.OnlinerLinks;
import com.it_academy.onliner.listeners.AllureWatcher;
import com.it_academy.onliner.page_objects.CatalogPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@ExtendWith(AllureWatcher.class)
@Epic("Onliner tests")
@Feature("Accessories elements")
public class AccessoriesElementsTest extends BaseTest {
    @Test
    @DisplayName("Presence elements in Accessories section test")
    @Description("Checking that elements under Accessories section present and they are not empty")
    @Severity(SeverityLevel.NORMAL)
    @Story("Getting accessories elements")
    public void testIfElements_PresentInAccessoriesSection() {
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.open(OnlinerLinks.CATALOG_ONLINER_URL.getLink());
        List<String> accessoriesElements = catalogPage
                .clickOnComputersAnsNetsSection()
                .clickOnAccessoriesSection()
                .getListOfAccessoriesElementsTitles();
        log.info("Actual collection of Accessories elements {}", accessoriesElements);
        assertThat(accessoriesElements)
                .as("Accessories elements are empty")
                .allMatch(element->!element.isEmpty());
    }
}
