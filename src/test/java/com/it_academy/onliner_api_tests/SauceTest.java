package com.it_academy.onliner_api_tests;

import com.it_academy.onliner_api.models.Sauce;
import com.it_academy.onliner_api.services.SauceService;
import com.it_academy.onliner_api.utils.NamesGetterUtils;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Epic("Sushivesla API tests")
@Feature("Filter test")
public class SauceTest extends BaseAPITest {

    @Test
    @DisplayName("Presence filter in response")
    @Description("Checking that all of name_prefix from response contain choosing filter")
    @Severity(SeverityLevel.NORMAL)
    @Story("Getting prefixes names")
    public void testCheckNamePrefixInSauce() {
        List<String> list= new ArrayList<>(Arrays.asList("Соус", "Соус", "Соус", "Соус"));
        SauceService sauceService = new SauceService();
        List<Sauce> sauces = sauceService.getSauces();
        LOG.info("Sauces collection: {}", sauces);
        List<String> prefixNames = NamesGetterUtils.getPrefixNames(sauces);
        LOG.info("Filters collection: {}", prefixNames);
        assertThat(prefixNames)
                .as("Name_prefix does not contain filter \"Сoyc\"")
                .containsExactlyElementsOf(list);
    }
}