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
@Feature("Computers and nets section")
public class ComputersAndNetsElementsTest extends BaseFunctionalTest {

    @Test
    @DisplayName("Presence elements in Computers and nets section test")
    @Description("Checking that elements under Computers and nets section present and they are not empty")
    @Severity(SeverityLevel.NORMAL)
    @Story("Getting computers and nets elements")
    public void testIfElementsPresent_InComputersAndNetsSection() {
        CatalogPage catalogPage = new CatalogPage();
        LOG.info("CatalogPage is created");
        catalogPage.openURL(CATALOG_ONLINER_URL.getLink());
        LOG.info("CATALOG_ONLINER_URL is opened");
        List<String> computersAndNetsElements = catalogPage
                .clickOnComputersAnsNetsSection("Компьютеры и\u00A0сети")
                .getListOfComputersAndNetsElements();
        LOG.info("Actual collection of Computers and nets elements {}", computersAndNetsElements);
        assertThat(computersAndNetsElements)
                .as("Computers and nets elements are empty")
                .allMatch(element->!element.isEmpty());
    }
}