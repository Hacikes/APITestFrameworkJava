package tests;

import requestbuilder.RequestBuilder;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GetTests {

    @Test
    public void getEmployeeDetails(){
        Response response = RequestBuilder.buildRequestForGetCalls()
                .get("/posts");//class or config.properties

        response.prettyPrint();

        Assertions.assertThat(response.getStatusCode())
                .isEqualTo(200);
        // Поиск ключа и сравнение его значения из ответа
        assertThat(response.jsonPath().getString("author"))
                .as("Сравнение автора с ответом").isEqualTo("[typicode]")
                .hasSizeBetween(3,20); // проверка размера значения typicode из ответа



    }

    @Test
    public void getEmployeeDetail() {
        Response response = RequestBuilder.buildRequestForGetCalls()
                .pathParam("id", 2)
                .get("/posts/{id}");//class or config.properties

        response.prettyPrint();

        Assertions.assertThat(response.getStatusCode())
                .isEqualTo(404);


    }
}
