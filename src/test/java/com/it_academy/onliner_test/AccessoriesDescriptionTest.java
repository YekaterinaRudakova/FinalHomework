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

@ExtendWith({AllureWatcher.class})
@Epic("Onliner tests")
@Feature("Description of elements in Accessories section")
public class AccessoriesDescriptionTest extends BaseTest {
    @Test
    @DisplayName("Presence description of elements in Accessories section test")
    @Description("Checking that description below elements titles under Accessories" +
            " section present and they are not null")
    @Severity(SeverityLevel.NORMAL)
    @Story("Getting description of elements")
    public void testIfElementsDescription_PresentUnderEachElementsTitles() {
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.open(OnlinerLinks.CATALOG_ONLINER_URL.getLink());
        List<String> accessoriesDescriptions = catalogPage
                .clickOnComputersAnsNetsSection()
                .clickOnAccessoriesSection()
                .getDescriptionOfAccessoriesElements();
        log.info("Actual collection of description of Accessories elements {}", accessoriesDescriptions);
        assertThat(accessoriesDescriptions)
                .as("Each description of elements in section Accessories should contain p.")
                .allMatch(element -> element.contains("р."));
    }
}
