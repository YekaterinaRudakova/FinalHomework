package com.it_academy.onliner_test;

import com.it_academy.onliner.page_objects.CatalogPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ComputersAndElementsTest extends BaseTest {

    @DisplayName("Presence elements in Computers and nets section test")
    @Test
    public void testIfElementsPresent_InComputersAndNetsSection() {
        String CATALOG_URL = "https://catalog.onliner.by/";
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.open(CATALOG_URL);
        clearAndRefresh();
        List<String> computersAndNetsElements = catalogPage
                .clickOnComputersAnsNetsSection()
                .getListOfComputersAndNetsElements();
        assertThat(computersAndNetsElements.iterator())
                .as("Computers and nets elements are not presented")
                .isNotNull()
                .hasNext();
    }
}
