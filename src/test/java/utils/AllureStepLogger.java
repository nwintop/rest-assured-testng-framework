package utils;

import io.qameta.allure.Allure;

public class AllureStepLogger {

    public static void logRequest(String request) {

        Allure.step("REQUEST:\n" + request);
    }

    public static void logResponse(String response) {

        Allure.step("RESPONSE:\n" + response);
    }
}