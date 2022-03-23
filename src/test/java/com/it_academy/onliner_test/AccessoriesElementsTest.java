package com.it_academy.onliner_test;

import com.it_academy.onliner.page_objects.CatalogPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class AccessoriesElementsTest extends BaseTest {

    @DisplayName("Presence elements in Accessories section test")
    @Test
    public void testIfElements_PresentInAccessoriesSection() {
        String CATALOG_URL = "https://catalog.onliner.by/";
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.open(CATALOG_URL);
        clearAndRefresh();
        List<String> accessoriesElements = catalogPage
                .clickOnComputersAnsNetsSection()
                .clickOnAccessoriesSection()
                .getListOfAccessoriesElements();
        System.out.println(accessoriesElements);
        assertThat(accessoriesElements.iterator())
                .as("Accessories elements are not presented")
                .isNotNull()
                .hasNext();
    }
}
