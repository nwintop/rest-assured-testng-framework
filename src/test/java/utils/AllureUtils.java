package utils;

import io.qameta.allure.Attachment;

public class AllureUtils {

    @Attachment(value = "Request", type = "text/plain")
    public static String attachRequest(String request) {
        return request;
    }

    @Attachment(value = "Response", type = "text/plain")
    public static String attachResponse(String response) {
        return response;
    }
}