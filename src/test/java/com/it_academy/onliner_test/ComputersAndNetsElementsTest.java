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
@Feature("Computers and nets elements")
public class ComputersAndNetsElementsTest extends BaseTest {

    @Test
    @DisplayName("Presence elements in Computers and nets section test")
    @Description("Checking that elements under Computers and nets section present and they are not empty")
    @Severity(SeverityLevel.NORMAL)
    @Story("Getting computers and nets elements")
    public void testIfElementsPresent_InComputersAndNetsSection() {
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.open(OnlinerLinks.CATALOG_ONLINER_URL.getLink());
        List<String> computersAndNetsElements = catalogPage
                .clickOnComputersAnsNetsSection()
                .getListOfComputersAndNetsElements();
        log.info("Actual collection of Computers and nets elements {}", computersAndNetsElements);
        assertThat(computersAndNetsElements)
                .as("Computers and nets elements are empty")
                .allMatch(element->!element.isEmpty());
    }
}
