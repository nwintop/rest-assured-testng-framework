package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import specfications.RequestSpecBuilderUtil;
import specfications.ResponseSpecBuilderUtil;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PetTests extends BaseTest {

    @Test
    public void getPetTest() {

        given()
                .spec(RequestSpecBuilderUtil.getRequestSpec())
                .when()
                .get("/pet/1")

                .then()
                .spec(ResponseSpecBuilderUtil.getResponseSpec())
                .statusCode(anyOf(is(200), is(404)))
                .log().all();
    }
}