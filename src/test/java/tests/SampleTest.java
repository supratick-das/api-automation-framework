package tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class SampleTest {

    @Test
    public void getUsers() {
        RestAssured
                .given()
                .log().all()
                .when()
                .get("https://jsonplaceholder.typicode.com/users")
                .then()
                .log().all()
                .statusCode(200);
    }
}