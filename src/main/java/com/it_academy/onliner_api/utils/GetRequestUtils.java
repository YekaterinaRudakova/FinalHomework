package com.it_academy.onliner_api.utils;

import io.qameta.allure.Step;
import io.restassured.response.ResponseBody;
import org.apache.http.HttpStatus;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.apache.commons.collections4.MapUtils.emptyIfNull;

public class GetRequestUtils {

    private GetRequestUtils() {
    }

    @Step("Make request and getting response body")
    public static ResponseBody makeRequestAndGetResponseBody(String endPoint, Map<String, Object> headers,
                                                             Map<String, Object> params) {
        return given()
                .headers(emptyIfNull(headers))
                .params(emptyIfNull(params))
                .when()
                .get(endPoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .body();
    }
}