package requestbuilder;

import com.tmb.enums.PropertiesType;
import com.tmb.utils.PropertyUtils;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;


public final class RequestBuilder { // Нерасширяемый класс

    private RequestBuilder(){}

    // Метод buildRequestForGetCalls конструирует запрос, благодаря чему мы можем использовать его в наших проверках,
    // а не писать ручками каждый раз uri log all и вот это вот всё
    public static RequestSpecification buildRequestForGetCalls(){
        return given()
                // Теперь URL мы считываем благодаря методу PropertyUtils и константой BASEURL
                .baseUri(PropertyUtils.getValue(PropertiesType.BASEURL))
                .log()
                .all();
    }
    public static RequestSpecification buildRequestForPostCalls() {
        return buildRequestForGetCalls()
                .contentType(ContentType.JSON);
    }

}
