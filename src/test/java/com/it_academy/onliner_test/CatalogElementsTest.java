package com.it_academy.onliner_test;

import com.it_academy.onliner.page_objects.OnlinerHomePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CatalogElementsTest extends BaseTest {

    @DisplayName("Presence elements in Catalog test")
    @Test
    public void testIfElements_PresentInCatalog() {
        String ONLINER_WEBSITE_URL = "https://www.onliner.by/";
        OnlinerHomePage onlinerHomePage = new OnlinerHomePage();
        onlinerHomePage.open(ONLINER_WEBSITE_URL);
        clearAndRefresh();
        List<String> catalogElements = onlinerHomePage.clickOnCatalogLink()
                .getListOfCatalogElements();
        System.out.println(catalogElements);
        assertThat(catalogElements.iterator())
                .as("Catalog elements are not presented")
                .isNotNull()
                .hasNext();
    }
}
