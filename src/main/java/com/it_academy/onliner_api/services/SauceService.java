package com.it_academy.onliner_api.services;

import com.it_academy.onliner_api.EndPointsFileReader;
import com.it_academy.onliner_api.models.Sauce;
import com.it_academy.onliner_api.utils.GetRequestUtils;
import com.it_academy.onliner_api.utils.ResponseBodyUtils;
import io.qameta.allure.Step;
import io.restassured.response.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SauceService {
    private static final Logger LOG = LoggerFactory.getLogger(SauceService.class);

    @Step("Getting sauces")
    public List<Sauce> getSauces() {
        LOG.debug("Getting product... ");
        ResponseBody responseBody = GetRequestUtils
                .makeRequestAndGetResponseBody(EndPointsFileReader
                        .getEndPointProperty("SAUCE_ENDPOINT"), null, null);
        LOG.debug("Response body: {}", responseBody);
        return ResponseBodyUtils.getObjectsByJsonPath(responseBody, "products", Sauce.class);
    }
}