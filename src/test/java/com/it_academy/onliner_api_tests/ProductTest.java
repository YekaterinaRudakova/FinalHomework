package com.it_academy.onliner_api_tests;

import com.it_academy.onliner_api.models.Product;
import com.it_academy.onliner_api.services.ProductService;
import com.it_academy.onliner_api.utils.NamesGetterUtils;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Epic("Sushivesla API tests")
@Feature("Product test")
public class ProductTest extends BaseAPITest {

    @Test
    @DisplayName("Presence name in each product")
    @Description("Getting list of products and checking that each product name is not empty ")
    @Severity(SeverityLevel.NORMAL)
    @Story("Getting products name")
    public void testCheckListOfProducts() {
        ProductService productService = new ProductService();
        List<Product> products = productService.getProducts();
        LOG.info("Products collection: {}", products);
        List<String> productNames = NamesGetterUtils.getProductNames(products);
        LOG.info("Names collection: {}", productNames);
        assertThat(productNames)
                .as("Names are empty")
                .allMatch(name -> !name.isEmpty());
    }
}