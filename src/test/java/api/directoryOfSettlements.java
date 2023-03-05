package api;

import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class directoryOfSettlements extends ApiBaseTest {

    String API_key = "22a14aad6aaf4e3105af3a947c088582";
    private HashMap<String, Object> reqBody = new HashMap<>();

    @BeforeMethod
    public void checkReqBody() {
        Map<String, Object> methodProperties = new HashMap<>();

        methodProperties.put("Page", "1");
        methodProperties.put("Warehouse", "1");
        methodProperties.put("FindByString", "Київ");
        methodProperties.put("Limit", "20");

        reqBody.put("apiKey", API_key);
        reqBody.put("modelName", "Address");
        reqBody.put("calledMethod", "getSettlements");
        reqBody.put("methodProperties", methodProperties);
    }

    @Test
    public void checkIfSuccessfull() {

        given()
                .spec(requestSpecification)
                .contentType(ContentType.JSON)
                .body(reqBody)
                .when()
                .post()
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .assertThat()
                .body("success", equalTo(true));
    }

    @org.testng.annotations.Test
    public void checkArea() {
        given()
                .spec(requestSpecification)
                .contentType(ContentType.JSON)
                .body(reqBody)
                .when()
                .post()
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .assertThat()
                .body("success", equalTo(true))
                .body("data[0].AreaDescription", equalTo("Київська"))
                .body("data[0].AreaDescriptionTranslit", equalTo("Kyivska"));

    }

    //не робочий тест. Потрібно розібратись
    @Test
    public void checkWarehouse() {
        List<Address> addressList = given()
                .spec(requestSpecification)
                .contentType(ContentType.JSON)
                .body(reqBody)
                .when()
                .post()
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .extract()
                .body().jsonPath().getList("data.Warehouse", Address.class);
        System.out.println(addressList);
    }
}

