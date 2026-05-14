package payloads;

import pojo.Pet;

public class PayloadManager {

    public static Pet createPetPayload(
            long id,
            String name,
            String status) {

        Pet pet = new Pet();

        pet.setId(id);
        pet.setName(name);
        pet.setStatus(status);

        return pet;
    }
}