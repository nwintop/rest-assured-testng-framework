package specfications;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecBuilderUtil {
    public static ResponseSpecification getResponseSpec() {

        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
    }
}
