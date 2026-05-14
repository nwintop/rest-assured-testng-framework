package services;

import io.qameta.allure.Allure;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import pojo.Pet;
import specfications.RequestSpecBuilderUtil;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static io.restassured.RestAssured.*;

public class PetService {

    public Response createPet(Pet petPayload) {

        ByteArrayOutputStream requestBuffer = new ByteArrayOutputStream();
        ByteArrayOutputStream responseBuffer = new ByteArrayOutputStream();

        PrintStream requestStream = new PrintStream(requestBuffer);
        PrintStream responseStream = new PrintStream(responseBuffer);

        Response response =
                given()
                        .spec(RequestSpecBuilderUtil.getRequestSpec())
                        .filter(new RequestLoggingFilter(requestStream))
                        .filter(new ResponseLoggingFilter(responseStream))
                        .body(petPayload)

                        .when()
                        .post("/pet");

        // 🔥 CRITICAL FIX: attach inside step grouping
        Allure.step("API CALL: Create Pet", () -> {

            Allure.addAttachment("Request", requestBuffer.toString());
            Allure.addAttachment("Response", responseBuffer.toString());
        });

        return response;
    }

    public Response getPet(long petId) {

        ByteArrayOutputStream requestBuffer = new ByteArrayOutputStream();
        ByteArrayOutputStream responseBuffer = new ByteArrayOutputStream();

        PrintStream requestStream = new PrintStream(requestBuffer);
        PrintStream responseStream = new PrintStream(responseBuffer);

        Response response =
                given()
                        .spec(RequestSpecBuilderUtil.getRequestSpec())
                        .filter(new RequestLoggingFilter(requestStream))
                        .filter(new ResponseLoggingFilter(responseStream))

                        .when()
                        .get("/pet/" + petId);

        utils.AllureStepLogger.logRequest(requestBuffer.toString());
        utils.AllureStepLogger.logResponse(responseBuffer.toString());

        return response;
    }
}