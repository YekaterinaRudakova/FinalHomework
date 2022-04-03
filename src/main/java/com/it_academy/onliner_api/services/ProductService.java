package com.it_academy.onliner_api.services;

import com.it_academy.onliner_api.EndPointsFileReader;
import com.it_academy.onliner_api.models.Product;
import com.it_academy.onliner_api.utils.GetRequestUtils;
import com.it_academy.onliner_api.utils.ResponseBodyUtils;
import io.qameta.allure.Step;
import io.restassured.response.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProductService {
    private static final Logger LOG = LoggerFactory.getLogger(ProductService.class);

    @Step("Getting products")
    public List<Product> getProducts() {
        LOG.debug("Getting product... ");
        ResponseBody responseBody = GetRequestUtils
                .makeRequestAndGetResponseBody(EndPointsFileReader
                        .getEndPointProperty("PRODUCT_ENDPOINT"), null, null);
        LOG.debug("Response body: {}", responseBody);
        return ResponseBodyUtils.getObjectsByJsonPath(responseBody, "products", Product.class);
    }
}