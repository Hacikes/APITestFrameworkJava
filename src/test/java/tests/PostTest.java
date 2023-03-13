package tests;

import com.tmb.constants.FCwithSingleton;
import com.tmb.pojo.Employee;
import com.tmb.utils.ApiUtils;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import requestbuilder.RequestBuilder;

import java.lang.reflect.Method;

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

        Response response = RequestBuilder.buildRequestForGetCalls()
                .body(employee)
                .post("/posts");
        response.prettyPrint();

        Assertions.assertThat(response.getStatusCode()).isEqualTo(201);

    }
// Простой, но не рабочий метод
/*
    @Test
    public void postRequestUsingExternalFile(Method method){ // используя метод появляется экспешпн
        String resource = ApiUtils
                // Используем константу FrameworkConstants getGetRequestJsonFolderPath для чтения из файла
                // и в параметре используем имя
                .readJsonAndGetAsString(FrameworkConstants.getRequestJsonFolderPath()+method.getName())
                // Изменяются имя и id через замену значений
                // не забываем, что методы идут из импортированного класса RandonUtils
                .replace("Alex", getFirstName())
                .replace("number", String.valueOf(RandonUtils.getId()));

        Response response = RequestBuilder.buildRequestForGetCalls()
                .body(resource)
                .post("/posts");
        response.prettyPrint();

        ApiUtils.storeStringAsJsonFile(FrameworkConstants.getResponseJsonFolderPath()+method.getName()+"response.json", response);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(201);
    }

*/

    // Сложный метод
    @Test
    public void postRequestUsingExternalFile1(Method method){
        String resource = ApiUtils
                // Используем константу FCwithSingleton getGetRequestJsonFolderPath для чтения из файла
                // так метод не статичный, необходимо создать новый объект, что мы и сделали используя new
                .readJsonAndGetAsString(FCwithSingleton.getInstance().getGetRequestJsonFolderPath() +"request.json")
                // Изменяются имя и id через замену значений
                // не забываем, что методы идут из импортированного класса RandonUtils
                .replace("Alex", getFirstName())
                .replace("number", String.valueOf(getId()));

        Response response = RequestBuilder.buildRequestForGetCalls()
                .body(resource)
                .post("/posts");
        response.prettyPrint();
        // Прописываем по сути путь к файлу используя пути из FCwithSingleton
        ApiUtils.storeStringAsJsonFile(FCwithSingleton.getInstance().getGetResponseJsonFolderPath() +method.getName()+"response.json", response);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(201);
    }

}
