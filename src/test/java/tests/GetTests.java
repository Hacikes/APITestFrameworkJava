package tests;

import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import requestbuilder.RequestBuilder;

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
                .as("Сравнение автора с ответом").isEqualTo("[typecode]")
                .hasSizeBetween(3,20); // проверка размера значения typecode из ответа
    }

    // Поставщик данных
    @SuppressWarnings("TestDataSupplier")
    @Test(dataProvider = "getData")
    public void getEmployeeDetail(Integer id, String lastname) {

        //int counter = new myCounter().increment();

        Response response = RequestBuilder
                .buildRequestForGetCalls()
                // Использовать pathParam, так как только в таком случае перебираются все объекты JSON
                .pathParam("id", id)
                .get("/posts/{id}");//class or config.properties

        response.prettyPrint();

        Assertions.assertThat(response.getStatusCode())
                .isEqualTo(200);

        // Поиск ключа и сравнение его значения из ответа
        assertThat(response.jsonPath().getString("author"))
                .as("Сравнение автора с ответом").isEqualTo(lastname)
                .hasSizeBetween(3,20); // проверка размера значения typecode из ответа
    }

    // Благодаря тому, что мы объявили dataProvider в самом запросе, мы можем использовать поставщик данных,
    // который используем ниже для проверки сразу нескольких значений
    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                // {id, Значение поля author}
                {1, "typecode"},
                {2, "dfdfdf"},
                {3, "dfdfdfdf"},
        };
    }
}
