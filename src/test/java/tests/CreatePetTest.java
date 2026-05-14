package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;

import org.testng.annotations.Test;
import payloads.PayloadManager;
import pojo.Pet;
import specfications.RequestSpecBuilderUtil;
import specfications.ResponseSpecBuilderUtil;
import utils.FakerUtils;


import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class CreatePetTest extends BaseTest {

    @Test()
    @Description("Verify pet creation API")
    @Owner("Nilesh")
    @Severity(SeverityLevel.CRITICAL)
    public void createPetTest() {

        Pet pet = PayloadManager.createPetPayload(
                FakerUtils.getPetId(),
                FakerUtils.getPetName(),
                FakerUtils.getPetStatus());

        Response response =

                given()
                        .spec(RequestSpecBuilderUtil.getRequestSpec())
                        .body(pet)

                        .when()
                        .post("/pet");

        response.then()
                .spec(ResponseSpecBuilderUtil.getResponseSpec())
                .statusCode(200)

                .body("name", equalTo(pet.getName()))
                .body("status", equalTo(pet.getStatus()))

                .body(
                        matchesJsonSchemaInClasspath(
                                "schemas/pet-schema.json"))

                .log().all();
    }
}