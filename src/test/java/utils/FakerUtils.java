package utils;

import com.github.javafaker.Faker;

public class FakerUtils {

    static Faker faker = new Faker();

    public static long getPetId() {

        return faker.number()
                .numberBetween(1000, 9999);
    }

    public static String getPetName() {

        return faker.animal()
                .name();
    }

    public static String getPetStatus() {

        return "available";
    }
}