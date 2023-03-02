package com.tmb.tests;

import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GetTests {

    @Test
    public void getEmployeeDetails(){
        Response response = given()
                .baseUri("http://localhost:3000")
                .pathParam("id", "1") // переменная для параметра id
                .get("/posts/{id}");//class or config.properties // используется переменная для изменения параметра

        response.prettyPrint();

        Assertions.assertThat(response.getStatusCode())
                .isEqualTo(200);
        // Получение списка и поиск его размера
        assertThat(response.jsonPath().getMap("$").size())
                .isPositive() // позитивен ли размер
                .as("Validating the size of the employee array").isGreaterThan(0); // размер массива сотрудников больше 0?
                // а так же добавлено наше описание в ошибку


    }


}
