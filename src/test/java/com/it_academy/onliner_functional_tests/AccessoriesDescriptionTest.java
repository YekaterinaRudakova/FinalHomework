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

@ExtendWith({AllureWatcher.class})
@Epic("Onliner catalog tests")
@Feature("Description of elements in Accessories section")
public class AccessoriesDescriptionTest extends BaseFunctionalTest {

    @Test
    @DisplayName("Presence description of elements in Accessories section test")
    @Description("Checking that description below elements titles under Accessories" +
            " section present and they are not null")
    @Severity(SeverityLevel.NORMAL)
    @Story("Getting description of elements")
    public void testIfElementsDescription_PresentUnderEachElementsTitles() {
        CatalogPage catalogPage = new CatalogPage();
        LOG.info("CatalogPage is created");
        catalogPage.openURL(CATALOG_ONLINER_URL.getLink());
        LOG.info("CATALOG_ONLINER_URL is opened");
        List<String> accessoriesDescriptions = catalogPage
                .clickOnComputersAnsNetsSection("Компьютеры и\u00A0сети")
                .clickOnAccessoriesSection("Комплектующие")
                .getDescriptionOfAccessoriesElements("Комплектующие", "товар");
        LOG.info("Actual collection of description of Accessories elements {}", accessoriesDescriptions);
        assertThat(accessoriesDescriptions)
                .as("Each description of elements in section Accessories should contain p.")
                .allMatch(element -> element.contains("р."));
    }
}