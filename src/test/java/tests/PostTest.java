package tests;

import com.tmb.pojo.Employee;
import com.tmb.utils.ApiBuilder;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import static com.tmb.utils.RandonUtils.*;

public class PostTest {
    @Test
    public void postCallTest(){
        // Create Post call
        // Данные генерируются методами из класса RandonUtils, который находятся в импорте
        Employee employee = Employee
                .builder()
                .setFname(getFirstName())
                .setLname(getLastName())
                .setId(getId()) // Так использовать стороннюю библиотеку нельзя
                .build();

        Response response = ApiBuilder.buildRequestForGetCalls()
                .body(employee)
                .post("/posts");
        response.prettyPrint();

        Assertions.assertThat(response.getStatusCode()).isEqualTo(201);


    }

}
