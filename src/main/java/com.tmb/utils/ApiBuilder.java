package com.tmb.utils;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;


public final class ApiBuilder { // Нерасширяемый класс

    private ApiBuilder(){}

    // Метод buildRequestForGetCalls конструирует запрос, благодаря чему мы можем использовать его в наших проверках
    // а не писать ручками каждый раз uri log all и вот это вот всё
    public static RequestSpecification buildRequestForGetCalls(){
        return given()
                .baseUri("http://localhost:3000")
                .log()
                .all();
    }
}
