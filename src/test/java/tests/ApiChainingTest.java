package tests;

import base.BaseTest;
import io.restassured.response.Response;

import org.testng.annotations.Test;

import payloads.PayloadManager;
import pojo.Pet;
import services.PetService;
import specfications.ResponseSpecBuilderUtil;
import utils.FakerUtils;

import static org.hamcrest.Matchers.equalTo;

public class ApiChainingTest extends BaseTest {

    @Test
    public void createAndGetPetTest() {

        // Create Dynamic Payload

        Pet pet = PayloadManager.createPetPayload(
                FakerUtils.getPetId(),
                FakerUtils.getPetName(),
                FakerUtils.getPetStatus());

        PetService petService = new PetService();

        // Create Pet API

        Response createResponse =
                petService.createPet(pet);

        createResponse.then()
                .spec(ResponseSpecBuilderUtil.getResponseSpec())
                .statusCode(200);

        // Extract Pet ID

        long petId =
                createResponse.jsonPath().getLong("id");

        // Get Pet API

        Response getResponse =
                petService.getPet(petId);

        // Validation

        getResponse.then()
                .spec(ResponseSpecBuilderUtil.getResponseSpec())
                .statusCode(200)

                .body("id", equalTo((int) petId))
                .body("name", equalTo(pet.getName()))
                .body("status", equalTo(pet.getStatus()))

                .log().all();
    }
}