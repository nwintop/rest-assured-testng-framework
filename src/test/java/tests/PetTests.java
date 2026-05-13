package tests;

import base.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PetTests extends BaseTest {

    @Test
    public void getPetTest() {

        given()

                .when()
                .get("/pet/1")

                .then()
                .statusCode(anyOf(is(200), is(404)))
                .log().all();
    }
}